package com.collection.lazy.util;

import java.util.AbstractCollection;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.collection.lazy.generic.First;
import com.collection.lazy.generic.Segment;
import com.collection.lazy.generic.factory.LazyFactory;

/**
 * 
 * @author kkishore
 *
 * @param <T>
 */
public abstract class LazyCollection<T> extends AbstractCollection<T> implements Iterable<T>, First<T>, Segment<T> {
	
	public T first(){
		return LazyFactory.first(this);
	}
	
	public T head(){
		return LazyFactory.head(this);
	}
	
	public LazyCollection<T> tail(){
		return LazyFactory.tail(this);
	}
	
	public LazyCollection<T> empty(){
		return LazyFactory.empty();
	}
	
	public LazyCollection<T> cons(final T value){
		//TODO
		return null;
	}
	
	@Override
	public int size() {
		return LazyFactory.size(this);
	}
	
	public Stream<T> stream(final int size, final boolean parallel, final int type){
		final Spliterator<T> iterator = Spliterators.spliterator(this.iterator(), size, type);
		return StreamSupport.stream(iterator, parallel);
	}
	
	public Stream<T> stream(){
		return stream(false, Spliterator.IMMUTABLE);
	}
	
	public Stream<T> stream(final boolean parallel, final int type){
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(this.iterator(), Spliterator.IMMUTABLE), parallel);
	}
	
	public Stream<T> stream(final int size){
		return stream(size, false, Spliterator.IMMUTABLE);
	}
	
	public Stream<T> streamAsParallel(){
		return stream(size(), true, Spliterator.CONCURRENT);
	}

}
