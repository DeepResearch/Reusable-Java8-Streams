package com.collection.lazy.generic;

import java.util.Iterator;

import com.collection.lazy.generic.iterators.SegmentIterator;

/**
 * 
 * @author kkishore
 *
 * @param <T>
 */
public abstract class AbstractSegment<T> implements Segment<T>, Iterable<T> {
	  
	@Override
    public Segment<T> empty() {
        return Segment.constructors.emptySegment();
    }

    @Override
    public Segment<T> cons(T head) {
        return Segment.constructors.segment(head, this);
    }

    @Override
    public Iterator<T> iterator() {
        return SegmentIterator.iterator(this);
    }
    
}