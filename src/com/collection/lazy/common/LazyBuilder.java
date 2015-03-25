package com.collection.lazy.common;

import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

import com.collection.lazy.generic.factory.LazyFactory;
import com.collection.lazy.util.LazyCollection;

public class LazyBuilder {
	private static abstract class BuilderImpl<T, S extends Spliterator<T>> implements Spliterator<T> {
        // >= 0 when building, < 0 when built
        // -1 == no elements
        // -2 == one element, held by first
        // -3 == two or more elements, held by buffer
        int count;

        // Spliterator implementation for 0 or 1 element
        // count == -1 for no elements
        // count == -2 for one element held by first

        @Override
        public S trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return -count - 1;
        }

        @Override
        public int characteristics() {
            return Spliterator.SIZED | Spliterator.SUBSIZED |
                   Spliterator.ORDERED | Spliterator.IMMUTABLE;
        }
    }
	
	public static final class LazyBuilderImpl<T> extends BuilderImpl<T, Spliterator<T>> implements Builder<T> {
		// The first element in the stream
		// valid if count == 1
		T first;

		// The first and subsequent elements in the stream
		// non-null if count == 2
		LazyBuffer<T> buffer;

		/**
		 * Constructor for building a stream of 0 or more elements.
		 */
		public LazyBuilderImpl() {
		}

		/**
		 * Constructor for a singleton stream.
		 *
		 * @param t
		 *            the single element
		 */
		LazyBuilderImpl(T t) {
			first = t;
			count = -2;
		}

		// StreamBuilder implementation

		@Override
		public void accept(T t) {
			if (count == 0) {
				first = t;
				count++;
			} else if (count > 0) {
				if (buffer == null) {
					buffer = new LazyBuffer<>();
					buffer.accept(first);
					count++;
				}

				buffer.accept(t);
			} else {
				throw new IllegalStateException();
			}
		}

		public Builder<T> add(T t) {
			accept(t);
			return this;
		}

		@Override
		public LazyCollection<T> build() {
			int c = count;
			if (c >= 0) {
				// Switch count to negative value signalling the builder is
				// built
				count = -count - 1;
				// Use this spliterator if 0 or 1 elements, otherwise use
				// the spliterator of the spined buffer
				return (c < 2) ? LazyFactory.sequence(this.first, buffer.get(1))
						: LazyFactory.sequence(Spliterators.iterator(buffer.spliterator()));				
			}

			throw new IllegalStateException();
		}

		// Spliterator implementation for 0 or 1 element
		// count == -1 for no elements
		// count == -2 for one element held by first

		@Override
		public boolean tryAdvance(Consumer<? super T> action) {
			Objects.requireNonNull(action);

			if (count == -2) {
				action.accept(first);
				count = -1;
				return true;
			} else {
				return false;
			}
		}

		@Override
		public void forEachRemaining(Consumer<? super T> action) {
			Objects.requireNonNull(action);

			if (count == -2) {
				action.accept(first);
				count = -1;
			}
		}
	}
}
