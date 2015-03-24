package com.collection.lazy.generic.factory;

import java.util.Iterator;

import com.collection.lazy.generic.iterators.ArrayIterator;
import com.collection.lazy.generic.iterators.EmptyIterator;
import com.collection.lazy.util.LazyCollection;
import static com.collection.lazy.generic.factory.Unchecked.cast;

public class LazyFactory {
	
	public static <T> LazyCollection<T> empty(){
		return new LazyCollection<T>() {			
			@Override
			public final Iterator<T> iterator() {				
				return new EmptyIterator<>();
			}						
		};
	}
	
	public static <T> LazyCollection<T> lazyCollection(){
		return empty();
	}
	
	@SuppressWarnings("unused")
	@SafeVarargs
	private static <T> LazyCollection<T> internal(final T... items){
		return sequence(items);
	}
	
	@SafeVarargs
	public static <T> LazyCollection<T> sequence(final T... items){
		 if (items == null || items.length == 0) {
	            return empty();
	     }
		 return new LazyCollection<T>() {
			@Override
			public final Iterator<T> iterator() {				
				return new ArrayIterator<>(items);
			}
			 
		};
	}
	
	public static <T> LazyCollection<T> sequence(final Iterable<T> iterable){
		return sequence(iterable.iterator());
	}
	
	
	public static <T> LazyCollection<T> sequence(final Iterator<T> iterator){
		if (iterator == null) return empty();

        if (iterator instanceof LazyCollection) return cast(iterator);

        return new LazyCollection<T>() {
            public final Iterator<T> iterator() {
                return cast(iterator);
            }
        };
	}
	
	 public static <T> T first(final Iterable<? extends T> iterable) {
	        return head(iterable);
	 }
	 
	 public static <T> T head(final Iterable<? extends T> iterable) {
	        return IteratorFactory.head(iterable.iterator());
	 }
	 
	 public static <T> LazyCollection<T> tail(final Iterable<? extends T> iterable){
		 	return new LazyCollection<T>() {
		 		
				@Override
				public final Iterator<T> iterator() {				
					return IteratorFactory.tail(iterable.iterator());
				}
		 		
			};
	 }
	 
	 public static <T> LazyCollection<T> cons(final T t, final Iterable<? extends T> iterable){
		 return new LazyCollection<T>() {
			@Override
			public Iterator<T> iterator() {
				return null;
			}
			 
		};
	 }
	 
	 public static <T> int size(final Iterable<? extends T> iterable){
		 return IteratorFactory.size(iterable.iterator());
	 }

}
