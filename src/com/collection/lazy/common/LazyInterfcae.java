package com.collection.lazy.common;

/**
 * 
 * @author kkishore
 *
 */
public interface LazyInterfcae {
	
	public abstract long size();
	
	default boolean isEmpty(){
		return size() == 0;
	}

}
