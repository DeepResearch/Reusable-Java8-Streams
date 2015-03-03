package com.awesomeml.collection.lazy.impl;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.DoubleStream;
import java.util.stream.StreamSupport;

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
		return LazyDoubleFactory.size(this);
	}
	
	public DoubleStream doubleStream(final int size, final boolean parallel, final int type){
		final Spliterator.OfDouble splitter = Spliterators.spliterator(this.iterator(), size, type);
		return StreamSupport.doubleStream(splitter, parallel);
	}
	
	public DoubleStream doubleStream(){
		return doubleStream(false, Spliterator.IMMUTABLE);
	}
	
	public DoubleStream doubleStream(final int size){
		return doubleStream(size, false, Spliterator.IMMUTABLE);
	}
	
	public DoubleStream doubleStreamAsParallel(){
		return doubleStream(size(), false, Spliterator.CONCURRENT);
	}
	
	public DoubleStream doubleStream(final boolean parallel, final int type){
		return StreamSupport.doubleStream(Spliterators.spliteratorUnknownSize(this.iterator(), Spliterator.IMMUTABLE), parallel);
	}
	
	public LazyDoubleCollection empty(final int size){
		return LazyDoubleFactory.doubleSequence(new double[size]);
	}
	
	public void update(final int index, final double value){
		this.iterator();
	}
}
