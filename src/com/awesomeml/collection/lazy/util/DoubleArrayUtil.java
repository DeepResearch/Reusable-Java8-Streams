/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awesomeml.collection.lazy.util;

import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.DoubleConsumer;

/**
 *
 * @author machine
 */
public class DoubleArrayUtil {

    public static PrimitiveIterator.OfDouble iterator(final double... values) {

        return new PrimitiveIterator.OfDouble() {
            final int size = values.length;
            int index = 0;

            @Override
            public double nextDouble() {
                final int temp = index;
                index++;
                return values[temp];
            }

            @Override
            public void forEachRemaining(DoubleConsumer action) {
                Objects.requireNonNull(action);
                while (hasNext()) {
                    action.accept(nextDouble());
                }
            }

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Double next() {
                final int temp = index;
                index++;
                return values[temp];
            }
        };
    }

}
