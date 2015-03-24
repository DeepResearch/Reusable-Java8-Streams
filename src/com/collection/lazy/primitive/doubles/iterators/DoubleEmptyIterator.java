package com.collection.lazy.primitive.doubles.iterators;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.function.DoubleConsumer;

public class DoubleEmptyIterator implements PrimitiveIterator.OfDouble{

	@Override
	public void forEachRemaining(DoubleConsumer action) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasNext() {		
		return false;
	}

	@Override
	public Double next() {
		throw new NoSuchElementException();
	}

	@Override
	public double nextDouble() {
		throw new NoSuchElementException();
	}

}
