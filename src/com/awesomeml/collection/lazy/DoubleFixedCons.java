/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awesomeml.collection.lazy;

import java.util.Objects;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

/**
 *
 * @author machine
 */
public class DoubleFixedCons extends DoubleLazySeq {

    private final double head;
    private final DoubleLazySeq tail;

    public DoubleFixedCons(final double head, final DoubleLazySeq tail) {
        this.head = Objects.requireNonNull(head);
        this.tail = Objects.requireNonNull(tail);
    }

    @Override
    public double head() {
        return head;
    }

    @Override
    public DoubleLazySeq tail() {
        return tail;
    }

    @Override
    public boolean isTailDefined() {
        return true;
    }

    @Override
    public DoubleLazySeq map(final DoubleFunction mapper) {
        //TODO
        return cons((double) mapper.apply(head), tail.map(mapper));
    }

    @Override
    public DoubleLazySeq map(final DoubleUnaryOperator mapper) {
        return cons(mapper.applyAsDouble(head), tail.map(mapper));
    }

    @Override
    public DoubleLazySeq filter(final DoublePredicate predicate) {
        if (predicate.test(head)) {
            return cons(head, tail.filter(predicate));
        } else {
            return tail.filter(predicate);
        }
    }

    @Override
    public DoubleLazySeq flatMap(final DoubleFunction<? extends DoubleStream> mapper) {
        //TODO
        return tail;
    }

    @Override
    public DoubleLazySeq takeUnsafe(final long maxSize) {
        if (maxSize > 1) {
            return cons(head, tail.takeUnsafe(maxSize - 1));
        } else {
            return DoubleLazySeq.of(head);
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
