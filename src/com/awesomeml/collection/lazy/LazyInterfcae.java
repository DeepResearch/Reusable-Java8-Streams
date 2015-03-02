package com.awesomeml.collection.lazy;

public interface LazyInterfcae {
	
	public abstract long size();
	
	default boolean isEmpty(){
		return size() == 0;
	}

}
