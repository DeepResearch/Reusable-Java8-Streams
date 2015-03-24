package com.collection.lazy.util.primitives;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.DoubleStream;
import java.util.stream.StreamSupport;

import com.collection.lazy.primitive.doubles.DoubleAbstractCollection;
import com.collection.lazy.primitive.doubles.DoubleIterable;
import com.collection.lazy.primitive.doubles.DoubleSegment;
import com.collection.lazy.primitive.doubles.FirstDouble;
import com.collection.lazy.primitive.doubles.factory.LazyDoubleFactory;

/**
 * 
 * @author kkishore
 *
 */
public abstract class LazyDoubleCollection extends DoubleAbstractCollection implements DoubleIterable, FirstDouble, DoubleSegment{
	
	public LazyDoubleCollection(){
		
	}
	
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
	
	
}
