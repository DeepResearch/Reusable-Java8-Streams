package com.awesomeml.collection.lazy.iterators;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.function.DoubleConsumer;

public class DoubleArrayIterator implements PrimitiveIterator.OfDouble{
	
	private final double[] array;
	private int index = 0;
	
	public DoubleArrayIterator(final double[] array) {
		this.array = array;
	}

	@Override
	public void forEachRemaining(DoubleConsumer action) {
		while(hasNext()){
			action.accept(nextDouble());
		}
	}

	@Override
	public boolean hasNext() {		
		return index < array.length;
	}

	@Override
	public Double next() {
		 return nextDouble();
	}

	@Override
	public double nextDouble() {
		 if(hasNext()){
	            return array[index++];
	     }
	     throw new NoSuchElementException();
	}

}
