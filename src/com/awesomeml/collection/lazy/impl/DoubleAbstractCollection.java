package com.awesomeml.collection.lazy.impl;

import java.util.PrimitiveIterator;

import com.awesomeml.collection.lazy.DoubleCollection;

public abstract class DoubleAbstractCollection implements DoubleCollection{
	
	protected DoubleAbstractCollection() {
		
	}
	
	public abstract PrimitiveIterator.OfDouble iterator();
	
	public abstract int size();
	
	public boolean isEmpty(){
		return size() == 0;
	}
		

}
