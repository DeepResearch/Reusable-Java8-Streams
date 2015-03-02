/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awesomeml.collection.lazy;

import java.util.function.DoubleConsumer;

/**
 *
 * @author machine
 */
public class DoubleLazyIterator implements DoubleIterable{
    
    private DoubleLazySeq sequence;
    
    public DoubleLazyIterator(final DoubleLazySeq sequence){
        this.sequence = sequence;
    }

    @Override
    public boolean hasNext() {
        return !sequence.isEmpty();
    }

    @Override
    public double next() {
       final double value = sequence.head();
       sequence = sequence.tail();
       return value;
    }

    @Override
    public void forEachRemaining(DoubleConsumer action) {
        sequence.forEach(action);
    }
    
}
