/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awesomeml.collection.lazy;

import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

/**
 *
 * @author machine
 */
public interface DoubleSeq {
    
    public double head();
    
    public OptionalDouble headOption();
    
    public DoubleLazySeq tail();
    
    public abstract boolean isTailDefined();
    
    public double get(final int index);
    
    public DoubleLazySeq map(final DoubleFunction mapper);
    
    public DoubleLazySeq map(final DoubleUnaryOperator mapper);
    
    public DoubleStream stream();
    
    public default DoubleStream parallelStream(){
        return stream();
    }
    
    public DoubleLazySeq flatMap(final DoubleFunction<? extends DoubleStream> mapper);

    public DoubleLazySeq filter(final DoublePredicate predicate);
    
    public DoubleLazySeq take(final long size);
    
    public default DoubleLazySeq limit(final long size){
        return take(size);
    }
    
    public DoubleLazySeq takeUnsafe(final long size);
    
    public DoubleLazySeq drop(final long startInclusive);
    
    public DoubleLazySeq dropUnsafe(final long startInclusive);
    
    public DoubleLazySeq slice(final long startIndex, final long stopIndex);
    
    public void forEach(final DoubleConsumer consumer);
    
    public OptionalDouble reduce(final DoubleUnaryOperator operator);
    
    public double reduce(final double identity, final DoubleUnaryOperator operator);
    
    public OptionalDouble sum();
    
    public OptionalDouble max();
    
    public OptionalDouble min();
    
    public long size();
    
    public DoubleLazyIterator iterator();
    
    public boolean anyMatch(final DoublePredicate predicate);
    
    public boolean allMatch(final DoublePredicate predicate);
    
    public boolean noneMatch(final DoublePredicate predicate);
    
    public DoubleLazySeq takeWhile(final DoublePredicate predicate);
    
    public DoubleLazySeq dropWhile(final DoublePredicate predicate);
    
    public DoubleLazySeq distinct();
    
    public boolean isEmpty();
}
