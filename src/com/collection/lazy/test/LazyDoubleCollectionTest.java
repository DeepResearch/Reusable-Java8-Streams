package com.collection.lazy.test;
import com.collection.lazy.primitive.doubles.factory.LazyDoubleFactory;
import com.collection.lazy.util.primitives.LazyDoubleCollection;

/**
 * 
 * @author kkishore
 *
 */
public class LazyDoubleCollectionTest {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		final int size = 100000000;
		final double[] array = new double[size];
		for(int i = 0; i < size; i++){
			array[i] = i;
		}
		// TODO Auto-generated method stub
		final LazyDoubleCollection collection = LazyDoubleFactory.doubleSequence(array);		
		long count = collection.doubleStream().map(x -> x + 1).filter(x -> x > 8000).count();
		double sum = collection.doubleStream().filter(x -> x < 10000).reduce((x, y) -> x + y).getAsDouble();
		collection.doubleStream().max();
		collection.doubleStream().min();
		collection.doubleStream().filter(x -> (x % 100) == 0).map(x -> x + 100).count();
		count = collection.doubleStream().map(x -> x + 1).filter(x -> x > 8000).count();
		sum = collection.doubleStream().filter(x -> x < 10000).reduce((x, y) -> x + y).getAsDouble();
		collection.doubleStream().filter(x -> x > 1098347).map(x -> x+ 100).max();
		collection.doubleStream().filter(x -> x > 1098347).map(x -> x+ 100).min();
		collection.doubleStream().filter(x -> x > 10000).map(x->x+1).filter(x -> x > 1000000).count();
		long end = System.currentTimeMillis() - start;
		System.out.println("Count : "+count+"\n Sum : "+sum);
		System.out.println("Time Taken : "+end);
		
	}

}
