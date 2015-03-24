package com.collection.lazy.generic.iterators;

import java.util.NoSuchElementException;

/**
 * 
 * @author kkishore
 *
 * @param <T>
 */
public final class EmptyIterator<T> extends ReadOnlyListIterator<T> {
	
    @Override
    public final boolean hasNext() {
        return false;
    }

    @Override
    public final T next() {
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public T previous() {
        throw new NoSuchElementException();
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return -1;
    }
}
