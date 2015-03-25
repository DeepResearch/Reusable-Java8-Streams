package com.collection.lazy.test;

import com.collection.lazy.common.Builder;
import com.collection.lazy.generic.factory.LazyFactory;
import com.collection.lazy.util.LazyCollection;

public class LazyBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		final Builder<Integer> builder = LazyFactory.builder();
		final int size = 19999999;
		for(int i = 0; i < size; i++){
			builder.add(i);
		}
		System.out.println("Builder Completed");
		final LazyCollection<Integer> collection = builder.build();
		long count = collection.stream().count();
		System.out.println(count);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken : "+(end - start));
	}

}
