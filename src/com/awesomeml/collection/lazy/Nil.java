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
public class Nil extends DoubleLazySeq{
    
    private static final Nil INSTANCE = new Nil();
    
    public static Nil instance(){
        return INSTANCE;
    }
    
    @Override
    public double head(){
        throw new UnsupportedOperationException("Empty Stream");
    }
    
    @Override
    public OptionalDouble headOption(){
        return OptionalDouble.empty();
    }
    
    @Override
    public boolean isTailDefined(){
        return false;
    }

    @Override
    public DoubleLazySeq tail() {
        throw new UnsupportedOperationException("Empty Stream"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double get(int index) {
        throw new IndexOutOfBoundsException(Integer.toString(index));
    }

    @Override
    public DoubleLazySeq map(DoubleFunction mapper) {
        return INSTANCE;
    }

    @Override
    public DoubleStream stream() {
        return DoubleStream.empty();
    }

    @Override
    public DoubleLazySeq flatMap(DoubleFunction<? extends DoubleStream> mapper) {
        return INSTANCE;
    }

    @Override
    public DoubleLazySeq filter(DoublePredicate predicate) {
        return INSTANCE;
    }

    @Override
    public DoubleLazySeq take(long size) {
        return INSTANCE;
    }

    @Override
    public DoubleLazySeq takeUnsafe(long size) {
        return INSTANCE;
    }

    @Override
    public DoubleLazySeq drop(long startInclusive) {
        return INSTANCE;
    }

    @Override
    public DoubleLazySeq dropUnsafe(long startInclusive) {
        return INSTANCE;
    }

    @Override
    public void forEach(DoubleConsumer consumer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OptionalDouble reduce(DoubleUnaryOperator operator) {
        return OptionalDouble.empty();
    }

    @Override
    public double reduce(double identity, DoubleUnaryOperator operator) {
        return Double.NaN;
    }

    @Override
    public OptionalDouble sum() {
        return OptionalDouble.empty();
    }

    @Override
    public OptionalDouble max() {
        return OptionalDouble.empty();
    }

    @Override
    public OptionalDouble min() {
        return OptionalDouble.empty();
    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public DoubleLazyIterator iterator() {
        throw new UnsupportedOperationException("Empty Stream, Operation Not possible"); 
    }

    @Override
    public boolean anyMatch(DoublePredicate predicate) {
        return false;
    }

    @Override
    public boolean allMatch(DoublePredicate predicate) {
        return false;
    }

    @Override
    public boolean noneMatch(DoublePredicate predicate) {
        return false;
    }

    @Override
    public DoubleLazySeq takeWhile(DoublePredicate predicate) {
        return INSTANCE;
    }

    @Override
    public DoubleLazySeq dropWhile(DoublePredicate predicate) {
        return INSTANCE;
    }

    @Override
    public DoubleLazySeq distinct() {
        return INSTANCE;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }    

    @Override
    public DoubleLazySeq map(DoubleUnaryOperator mapper) {
        return INSTANCE;
    }
}
