package com.collection.lazy.generic;

import java.util.Iterator;

public abstract class GenericAbstractCollection<T> implements Collection<T> {
	
	public abstract Iterator<T> iterator();
	
	public abstract int size();
	
	public boolean isEmpty(){
		return size() == 0;
	}	

}
