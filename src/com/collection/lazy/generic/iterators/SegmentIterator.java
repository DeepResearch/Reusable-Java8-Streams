package com.collection.lazy.generic.iterators;

import com.collection.lazy.generic.Segment;

/**
 * 
 * @author kkishore
 *
 * @param <T>
 */
public final class SegmentIterator<T> extends ReadOnlyIterator<T> {
	
	private Segment<T> segment;

    private SegmentIterator(Segment<T> segment) {
        this.segment = segment;
    }

    public static <T> SegmentIterator<T> iterator(Segment<T> segment) {
        return new SegmentIterator<T>(segment);
    }

    @Override
    public boolean hasNext() {
        return !segment.isEmpty();
    }

    @Override
    public T next() {
        final T head = segment.head();
        segment = segment.tail();
        return head;
    }

}
