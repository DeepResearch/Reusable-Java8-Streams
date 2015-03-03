/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awesomeml.collection.lazy.util;

import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.DoubleConsumer;

import com.awesomeml.collection.lazy.exception.LapackException;

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
    
    public static void rcopy(int n, double[] dx, int dxIdx, int incx, double[] dy, int dyIdx, int incy) {
        if (dxIdx < 0 || dxIdx + (n - 1) * incx >= dx.length) {
            throw new LapackException("Java.raxpy", "Parameters for x aren't valid! (n = " + n + ", dx.length = " + dx.length + ", dxIdx = " + dxIdx + ", incx = " + incx + ")");
        }
        if (dyIdx < 0 || dyIdx + (n - 1) * incy >= dy.length) {
            throw new LapackException("Java.raxpy", "Parameters for y aren't valid! (n = " + n + ", dy.length = " + dy.length + ", dyIdx = " + dyIdx + ", incy = " + incy + ")");
        }
        if (incx == 1 && incy == 1) {
            System.arraycopy(dx, dxIdx, dy, dyIdx, n);
        } else {
            for (int c = 0, xi = dxIdx, yi = dyIdx; c < n; xi += incx, yi += incy, c++) {
                dy[yi] = dx[xi];
            }
        }
    }

}
