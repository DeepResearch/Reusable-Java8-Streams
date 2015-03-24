package com.collection.lazy.test;
import com.collection.lazy.generic.factory.LazyFactory;
import com.collection.lazy.util.LazyCollection;


public class LazyCollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final LazyCollection<Double> collection = LazyFactory.sequence(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0);		
		collection.stream().forEach(x -> System.out.println(x));
	}

}
