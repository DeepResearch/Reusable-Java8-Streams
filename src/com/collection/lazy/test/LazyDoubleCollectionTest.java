package com.collection.lazy.test;
import com.collection.lazy.primitive.doubles.factory.LazyDoubleFactory;
import com.collection.lazy.util.primitives.LazyDoubleCollection;


public class LazyDoubleCollectionTest {

	public static void main(String[] args) {
		final int size = 100000000;
		final double[] array = new double[size];
		for(int i = 0; i < size; i++){
			array[i] = i;
		}
		// TODO Auto-generated method stub
		final LazyDoubleCollection collection = LazyDoubleFactory.doubleSequence(array);		
		final long count = collection.doubleStream().parallel().map(x -> x + 1).filter(x -> x > 800).count();
		final double sum = collection.doubleStream().parallel().filter(x -> x < 10000).reduce((x, y) -> x + y).getAsDouble();
		System.out.println("Count : "+count+" Sum : "+sum);
		
	}

}
