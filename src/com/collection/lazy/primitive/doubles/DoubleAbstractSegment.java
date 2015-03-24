package com.collection.lazy.primitive.doubles;

import java.util.PrimitiveIterator;


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
