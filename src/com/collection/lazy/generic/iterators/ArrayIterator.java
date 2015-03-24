package com.collection.lazy.generic.iterators;

import java.util.NoSuchElementException;

/**
 * 
 * @author kkishore
 *
 * @param <T>
 */
public final class ArrayIterator<T> extends ReadOnlyIterator<T> {
	
    private final T[] array;
    private int index = 0;

    public ArrayIterator(final T[] array) {
        this.array = array;
    }

    public final boolean hasNext() {
        return index < array.length;
    }

    public final T next() {
        if(hasNext()){
            return array[index++];
        }
        throw new NoSuchElementException();
    }
}
