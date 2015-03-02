/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awesomeml.collection.lazy;

import com.awesomeml.collection.lazy.util.DoubleArrayUtil;
import java.util.OptionalDouble;
import java.util.PrimitiveIterator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;

/**
 *
 * @author machine
 */
public abstract class DoubleLazySeq implements DoubleSeq {

    public static DoubleLazySeq empty() {
        return Nil.instance();
    }

    @Override
    public abstract double head();

    @Override
    public OptionalDouble headOption() {
        return OptionalDouble.of(head());
    }

    @Override
    public abstract DoubleLazySeq tail();

    public static DoubleLazySeq cons(final double head, final DoubleLazySeq tail) {
        return null;
    }

    public static DoubleLazySeq cons(final double head, final Supplier<DoubleLazySeq> tailFun) {
        return null;
    }

    public static DoubleLazySeq of(final double value) {
        return cons(value, empty());
    }

    public static DoubleLazySeq of(final double... values) {
        return of(DoubleArrayUtil.iterator(values));
    }

    public static DoubleLazySeq of(final PrimitiveIterator.OfDouble iterator) {
        if (iterator.hasNext()) {
            return cons(iterator.nextDouble(), () -> of(iterator));
        } else {
            return empty();
        }
    }

    @Override
    public abstract boolean isTailDefined();

    @Override
    public double get(final int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        DoubleLazySeq cur = this;
        for (int curIdx = index; curIdx > 0; --curIdx) {
            if (cur.tail().isEmpty()) {
                throw new IndexOutOfBoundsException(Integer.toString(index));
            }
            cur = cur.tail();
        }
        return cur.head();
    }

    @Override
    public abstract DoubleLazySeq map(final DoubleFunction mapper);
    
    @Override
    public abstract DoubleLazySeq map(final DoubleUnaryOperator mapper);

    @Override
    public DoubleStream stream() {
        return null;
    }

    @Override
    public DoubleStream parallelStream() {
        return stream();
    }

    @Override
    public abstract DoubleLazySeq filter(final DoublePredicate predicate);

    @Override
    public abstract DoubleLazySeq flatMap(final DoubleFunction<? extends DoubleStream> mapper);

    @Override
    public DoubleLazySeq take(long maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException(Long.toString(maxSize));
        }
        if (maxSize == 0) {
            return empty();
        }
        return takeUnsafe(maxSize);
    }

    @Override
    public abstract DoubleLazySeq takeUnsafe(final long maxSize);

    @Override
    public DoubleLazySeq drop(long startInclusive) {
        if (startInclusive < 0) {
            throw new IllegalArgumentException(Long.toString(startInclusive));
        }
        return dropUnsafe(startInclusive);
    }

    @Override
    public DoubleLazySeq dropUnsafe(long startInclusive) {
        if (startInclusive > 0) {
            return tail().drop(startInclusive - 1);
        } else {
            return this;
        }
    }

    @Override
    public DoubleLazySeq slice(long startInclusive, long endExclusive) {
        if (startInclusive < 0 || startInclusive > endExclusive) {
            throw new IllegalArgumentException("slice(" + startInclusive + ", " + endExclusive + ")");
        }
        return dropUnsafe(startInclusive).takeUnsafe(endExclusive - startInclusive);
    }

    @Override
    public void forEach(final DoubleConsumer consumer) {
        consumer.accept(head());
        tail().forEach(consumer);
    }

    @Override
    public OptionalDouble reduce(final DoubleUnaryOperator operator) {
        if (isEmpty() || tail().isEmpty()) {
            return OptionalDouble.empty();
        }
        return OptionalDouble.of(tail().reduce(head(), operator));
    }

    @Override
    public double reduce(final double identity, final DoubleUnaryOperator operator) {
        //TODO
        double result = identity;
        DoubleLazySeq cur = this;
        while (!cur.isEmpty()) {
            //result = operator.apply(result, cur.head());
            cur = cur.tail();
        }
        return result;
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
        return 1 + tail().size();
    }

    @Override
    public DoubleLazyIterator iterator() {
        return new DoubleLazyIterator(this);
    }

    @Override
    public boolean anyMatch(final DoublePredicate predicate) {
        return predicate.test(head()) || tail().anyMatch(predicate);
    }

    @Override
    public boolean allMatch(final DoublePredicate predicate) {
        return predicate.test(head()) && tail().allMatch(predicate);
    }

    @Override
    public boolean noneMatch(final DoublePredicate predicate) {
        return allMatch(predicate.negate());
    }

    @Override
    public DoubleLazySeq takeWhile(final DoublePredicate predicate) {
        if (predicate.test(head())) {
            return cons(head(), () -> tail().takeWhile(predicate));
        } else {
            return empty();
        }
    }

    @Override
    public DoubleLazySeq dropWhile(final DoublePredicate predicate) {
        if (predicate.test(head())) {
            return tail().dropWhile(predicate);
        } else {
            return this;
        }
    }
    
    @Override
    public DoubleLazySeq distinct(){
        //TODO
        return empty();
    }
    
    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

}
