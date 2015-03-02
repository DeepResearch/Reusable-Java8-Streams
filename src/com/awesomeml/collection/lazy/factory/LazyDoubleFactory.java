package com.awesomeml.collection.lazy.factory;

import java.util.PrimitiveIterator;
import java.util.PrimitiveIterator.OfDouble;

import com.awesomeml.collection.lazy.DoubleIterable;
import com.awesomeml.collection.lazy.impl.LazyDoubleCollection;
import com.awesomeml.collection.lazy.iterators.DoubleArrayIterator;
import com.awesomeml.collection.lazy.iterators.DoubleEmptyIterator;


public class LazyDoubleFactory {
	
	public static LazyDoubleCollection empty(){
		
		return new LazyDoubleCollection() {
				
			@Override
			public final PrimitiveIterator.OfDouble iterator() {				
				return new DoubleEmptyIterator();
			}
		};
	}
	
	public static double first(final DoubleIterable iterable){
		return head(iterable);
	}
	
	public static double head(final DoubleIterable iterable){
		return DoubleIteratorFactory.head(iterable.iterator());
	}
	
	public static LazyDoubleCollection tail(final DoubleIterable iterable){		
		return new LazyDoubleCollection() {
			
			@Override
			public OfDouble iterator() {
				
				return null;
			}
		};
	}
	
	public static LazyDoubleCollection doubleSequence(final double... values){
		if(values == null || values.length == 0){
			return empty();
		}
		return new LazyDoubleCollection() {
			
			@Override
			public final PrimitiveIterator.OfDouble iterator() {				
				return new DoubleArrayIterator(values);
			}
		};
	}
	
	public static int size(final DoubleIterable iterable){
		final PrimitiveIterator.OfDouble iterator = iterable.iterator();
		int count = 0;
		while(iterator.hasNext()){
			iterator.next();
			count++;			
		}
		return count;
	}
	
	public static double[] toArray(final DoubleIterable iterable){
		final PrimitiveIterator.OfDouble iterator = iterable.iterator();
		final int size = size(iterable);
		final double[] result = new double[size];
		for(int i = 0; i < size; i++){
			result[i] = iterator.nextDouble();
		}
		return result;
	}
	

}
