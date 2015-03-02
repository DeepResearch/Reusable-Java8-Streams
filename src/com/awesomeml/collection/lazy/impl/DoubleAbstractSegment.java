package com.awesomeml.collection.lazy.impl;

import java.util.PrimitiveIterator;

import com.awesomeml.collection.lazy.DoubleIterable;
import com.awesomeml.collection.lazy.DoubleSegment;


public abstract class DoubleAbstractSegment implements DoubleSegment, DoubleIterable{
	
	public DoubleSegment empty(){
		return DoubleSegment.doubleConstructors.emptySegment();
	}
	
	public DoubleSegment cons(final double head){
		return DoubleSegment.doubleConstructors.cons(head, this);
	}
	
	public PrimitiveIterator.OfDouble iterator(){
		return null;
	}

}
