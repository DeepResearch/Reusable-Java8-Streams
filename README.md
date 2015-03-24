# Reusable-Java8-Streams
A lazy data structure for Reusable Java8 Streams. 

Functional library for Java with following features

	* Tries to be as lazy as possible.
	* Seamless support for Java8 stream
	* Works with Iterable, Iterator, Arrays, etc.
	* Primitive lazy collections(Support for Int is in progress...)

## Quick Start

```java
		final int size = 100000000;
		final double[] array = new double[size];
		for(int i = 0; i < size; i++){
			array[i] = i;
		}
		final LazyDoubleCollection collection = LazyDoubleFactory.doubleSequence(array);		
		final long count = collection.doubleStream().parallel().map(x -> x + 1).filter(x -> x > 800).count();
		final double sum = collection.doubleStream().parallel().filter(x -> x < 10000).reduce((x, y) -> x + y).getAsDouble();
		System.out.println("Count : "+count+" \n Sum : "+sum);
```	


TODO 

	* Support for Integer primitives.
	* Builder Support(i.e. Like Stream.Builder).
	* Performance Benchmarks.
	* More Examples.	
	* JavaDoc.

	
	![Material Witness](resources/DoubleStream.png)

