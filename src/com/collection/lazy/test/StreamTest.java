package com.collection.lazy.test;

import java.util.stream.Stream;
import java.util.stream.Stream.Builder;




public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();		
		final Builder<Integer> builder = Stream.builder();
		final int size = 10000000;
		for(int i = 0; i < size; i++){
			builder.add(i);
		}
		final Stream<Integer> collection = builder.build();
		long count = collection.parallel().map(x -> x + 1).filter(x -> x > 9000).count();
		System.out.println(count);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken : "+(end - start));
	}

}
