package com.collection.lazy.generic.factory;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.collection.lazy.generic.iterators.PeekingIterator;




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

}
