# Reusable-Java8-Streams
A lazy data structure for Reusable Java8 Stream.

Functional library for Java with following features

	* Tries to be as lazy as possible.
	* Seamless support for Java8 stream
	* Works with Iterable, Iterator, Arrays, etc.
	* Primitive lazy collections(Support for Int is in progress...)

## Quick Start
### Array Example
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

### Builder Example
```java
		final Builder<Integer> builder = LazyFactory.builder();
		final LazyCollection<Integer> collection = builder.add(1).add(2).add(3).add(4).add(5).build();
		collection.stream().map(input -> input * input).forEach(product -> System.out.println(product));
		collection.stream().filter(input -> input > 3).count();
```
##TODO 

	* Support for Integer primitives.
	* Builder Support(i.e. Like Stream.Builder).
	* Performance Benchmarks.
	* More Examples.	
	* JavaDoc

##Checkout the benchmark
	* Array Size = 100000000
	* Operation = map, filter, reduce, count, max, min, sum, iterator, etc.

![DoubleStream](https://github.com/kishorenayar/Reusable-Java8-Streams/blob/master/resources/DoubleStream.PNG)
![LazyDoubleCollection](https://github.com/kishorenayar/Reusable-Java8-Streams/blob/master/resources/LazyCollection.PNG)

