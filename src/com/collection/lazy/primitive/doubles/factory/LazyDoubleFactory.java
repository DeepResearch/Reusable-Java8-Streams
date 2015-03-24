package com.collection.lazy.primitive.doubles.factory;

import java.util.PrimitiveIterator;
import java.util.PrimitiveIterator.OfDouble;

import com.collection.lazy.primitive.doubles.DoubleIterable;
import com.collection.lazy.primitive.doubles.iterators.DoubleArrayIterator;
import com.collection.lazy.primitive.doubles.iterators.DoubleEmptyIterator;
import com.collection.lazy.util.primitives.LazyDoubleCollection;


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
