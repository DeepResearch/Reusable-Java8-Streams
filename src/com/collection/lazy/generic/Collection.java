package com.collection.lazy.generic;

import java.util.Iterator;

public interface Collection<T> extends Iterable<T> {
	
	public Iterator<T> iterator();
	
	public int size();
	
	boolean isEmpty();

}
