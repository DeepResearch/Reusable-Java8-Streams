package com.collection.lazy.primitive.doubles;

import java.util.NoSuchElementException;

/**
 * 
 * @author kkishore
 *
 */
public interface DoubleSegment {
	
	boolean isEmpty();

    double head() throws NoSuchElementException;
    
    DoubleSegment empty();

    DoubleSegment cons(final double head);

    DoubleSegment tail() throws NoSuchElementException;
    
    final static class doubleConstructors {       

        public static DoubleSegment emptySegment() {
            return new DoubleEmptySegment();
        }

        public static DoubleSegment DoubleSegment(final double head) {
            return DoubleSegment(head, doubleConstructors.emptySegment());
        }

        public static  DoubleSegment DoubleSegment(double head, DoubleSegment tail) {
            return DoubleASegment.DoubleSegment(head, tail);
        }

        public static  DoubleSegment cons(double head, DoubleSegment tail) {
            return DoubleSegment(head, tail);
        }
        
    }
    
    final static class DoubleASegment extends DoubleAbstractSegment {
        private final double head;
        private final DoubleSegment tail;

        private DoubleASegment(double head, DoubleSegment tail) {
            this.head = head;
            this.tail = tail;
        }

        static  DoubleASegment DoubleSegment(double head, DoubleSegment tail) {
            return new DoubleASegment(head, tail);
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public double head() throws NoSuchElementException {
            return head;
        }

        @Override
        public DoubleSegment tail() throws NoSuchElementException {
            return tail;
        }

    }
    
    final static class DoubleEmptySegment extends DoubleAbstractSegment {
        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public double head() throws NoSuchElementException {
            throw new NoSuchElementException();
        }

        @Override
        public DoubleSegment tail() throws NoSuchElementException {
            throw new NoSuchElementException();
        }
    }

}
