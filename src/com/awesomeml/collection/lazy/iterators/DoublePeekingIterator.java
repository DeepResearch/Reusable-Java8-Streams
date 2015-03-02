package com.awesomeml.collection.lazy.iterators;

import java.util.PrimitiveIterator;



public class DoublePeekingIterator extends DoubleStatefulIterator{
	
	private final PrimitiveIterator.OfDouble iterator;
	
	public DoublePeekingIterator(final PrimitiveIterator.OfDouble iterator) {
		this.iterator = iterator;
	}
	
	protected double getNext(){
		 if (iterator.hasNext()) {
	            return iterator.nextDouble();
	     }
	     return finished();
	}
}
