package com.collection.lazy.test;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;


public class DoubleStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		final int size = 100000000;
		final double[] array = new double[size];
		for(int i = 0; i < size; i++){
			array[i] = i;
		}
		// TODO Auto-generated method stub
		Builder<String> builder = Stream.builder();
		DoubleStream collection = DoubleStream.of(array);		
		long count = collection.map(x -> x + 1).filter(x -> x > 8000).count();
		collection = DoubleStream.of(array);
		double sum = collection.filter(x -> x < 10000).reduce((x, y) -> x + y).getAsDouble();
		collection = DoubleStream.of(array);
		collection.max();
		collection = DoubleStream.of(array);
		collection.min();
		collection = DoubleStream.of(array);
		collection.filter(x -> (x % 100) == 0).map(x -> x + 100).count();
		collection = DoubleStream.of(array);
		count = collection.map(x -> x + 1).filter(x -> x > 18000).count();
		collection = DoubleStream.of(array);
		sum = collection.filter(x -> x < 1000000).reduce((x, y) -> x + y).getAsDouble();
		collection = DoubleStream.of(array);
		collection.filter(x -> x > 1098347).map(x -> x+ 100).max();
		collection = DoubleStream.of(array);
		collection.filter(x -> x > 1098347).map(x -> x+ 100).min();
		collection = DoubleStream.of(array);
		collection.filter(x -> x > 10000).map(x->x+1).filter(x -> x > 1000000).count();
		long end = System.currentTimeMillis() - start;
		System.out.println("Count : "+count+"\n Sum : "+sum);
		System.out.println("Time Taken : "+end);
	}

}
