package com.collection.lazy.primitive.doubles.factory;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;

import com.collection.lazy.primitive.doubles.iterators.DoublePeekingIterator;

/**
 * 
 * @author kkishore
 *
 */
public class DoubleIteratorFactory {
	
	public static double head(final PrimitiveIterator.OfDouble iterator){
		if(iterator.hasNext()){
			return iterator.next();
		}
		throw new NoSuchElementException();
	}
	
	public static PrimitiveIterator.OfDouble tail(final PrimitiveIterator.OfDouble iterator){
		if(iterator.hasNext()){
			iterator.next();
			return new DoublePeekingIterator(iterator);
		}
		throw new NoSuchElementException();
	}

}
