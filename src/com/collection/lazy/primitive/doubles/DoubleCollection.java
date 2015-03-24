package com.collection.lazy.primitive.doubles;

import java.util.PrimitiveIterator;

public interface DoubleCollection extends DoubleIterable{
	
	public PrimitiveIterator.OfDouble iterator();
	
	public int size();
	
	boolean isEmpty();

}
