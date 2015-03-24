package com.collection.lazy.primitive.doubles;

import java.util.PrimitiveIterator;

/**
 * 
 * @author kkishore
 *
 */
public interface DoubleCollection extends DoubleIterable{
	
	public PrimitiveIterator.OfDouble iterator();
	
	public int size();
	
	boolean isEmpty();

}
