package com.awesomeml.collection.lazy.impl;

import java.util.stream.DoubleStream;

import com.awesomeml.collection.lazy.DoubleIterable;
import com.awesomeml.collection.lazy.DoubleSegment;
import com.awesomeml.collection.lazy.FirstDouble;
import com.awesomeml.collection.lazy.factory.LazyDoubleFactory;



public abstract class LazyDoubleCollection extends DoubleAbstractCollection implements DoubleIterable, FirstDouble, DoubleSegment{
	
	public double first(){
		return LazyDoubleFactory.first(this);
	}
	
	public double head(){
		return LazyDoubleFactory.head(this);
	}
	
	public LazyDoubleCollection tail(){
		return LazyDoubleFactory.tail(this);
	}
	
	public LazyDoubleCollection empty(){
		return LazyDoubleFactory.empty();
	}
	
	public LazyDoubleCollection cons(final double value){
		return null;
	}
	
	public int size(){
		return 0;
	}
	
	public DoubleStream doubleStream(){		
		return new LazyDoubleStream(this);
	}
	
	public DoubleStream parallel(){
		return doubleStream().parallel();
	}

}
