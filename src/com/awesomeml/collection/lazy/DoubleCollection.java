package com.awesomeml.collection.lazy;

import java.util.PrimitiveIterator;

public interface DoubleCollection extends DoubleIterable{
	
	public PrimitiveIterator.OfDouble iterator();
	
	public int size();
	
	boolean isEmpty();

}
