package com.collection.lazy.generic;

import java.util.NoSuchElementException;

/**
 * 
 * @author kkishore
 *
 * @param <T>
 */
public interface Segment<T> {
	
	boolean isEmpty();
	
	T head() throws NoSuchElementException;
	
	Segment<T> empty();
	
	Segment<T> cons(T head);
	
	Segment<T> tail() throws NoSuchElementException;
	
	final static class constructors {	      

        public static <T> Segment<T> emptySegment() {
            return new EmptySegment<T>();
        }

        public static <T> Segment<T> segment(final T head) {
            return segment(head, constructors.<T>emptySegment());
        }

        public static <T> Segment<T> segment(T head, Segment<T> tail) {
            return ASegment.segment(head, tail);
        }

        public static <T> Segment<T> cons(T head, Segment<T> tail) {
            return segment(head, tail);
        }
	}
	
	final static class ASegment<T> extends AbstractSegment<T> {
        private final T head;
        private final Segment<T> tail;

        private ASegment(T head, Segment<T> tail) {
            this.head = head;
            this.tail = tail;
        }

        static <T> ASegment<T> segment(T head, Segment<T> tail) {
            return new ASegment<T>(head, tail);
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public T head() throws NoSuchElementException {
            return head;
        }

        @Override
        public Segment<T> tail() throws NoSuchElementException {
            return tail;
        }

    }
	
	
	final static class EmptySegment<T> extends AbstractSegment<T> {
        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public T head() throws NoSuchElementException {
            throw new NoSuchElementException();
        }

        @Override
        public Segment<T> tail() throws NoSuchElementException {
            throw new NoSuchElementException();
        }
    }

}
