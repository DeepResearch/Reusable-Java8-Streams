package com.collection.lazy.primitive.doubles;

import java.util.PrimitiveIterator;

/**
 * 
 * @author kkishore
 *
 */
public abstract class DoubleAbstractCollection implements DoubleCollection{
	
	protected DoubleAbstractCollection() {
		
	}
	
	public abstract PrimitiveIterator.OfDouble iterator();
	
	public abstract int size();
	
	public boolean isEmpty(){
		return size() == 0;
	}
		

}
