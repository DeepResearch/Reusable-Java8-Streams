package com.collection.lazy.generic.factory;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.collection.lazy.generic.iterators.FlattenIterator;
import com.collection.lazy.generic.iterators.PeekingIterator;
import static com.collection.lazy.generic.factory.LazyFactory.one;
import static com.collection.lazy.generic.factory.LazyFactory.sequence;


/**
 * 
 * @author kkishore
 *
 */
public class IteratorFactory {
	
	public static <T>  T head(final Iterator<T> iterator){
		if(iterator.hasNext()){
			return iterator.next();
		}
		throw new NoSuchElementException();
	}
	
	public static <T> Iterator<T> tail(final Iterator<? extends T> iterator) {
        if (iterator.hasNext()) {
            iterator.next();
            return new PeekingIterator<T>(iterator);
        }
        throw new NoSuchElementException();
    }
	
	public static <T> int size(final Iterator<? extends T> iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
	}
	
	public static <T> Iterator<T> flatten(final Iterator<? extends Iterator<? extends T>> iterator) {
        return new FlattenIterator<T>(iterator);
	}
	
	public static <T> Iterator<T> cons(final T t, final Iterator<? extends T> iterator) {
        return join(one(t).iterator(), iterator);
    }
	
	public static <T> Iterator<T> join(final Iterator<? extends T> first, final Iterator<? extends T> second) {
        return join(sequence(first, second));
    }
	
	public static <T> Iterator<T> join(final Iterable<? extends Iterator<? extends T>> iterable) {
	    return flatten(iterable.iterator());
	}

}
