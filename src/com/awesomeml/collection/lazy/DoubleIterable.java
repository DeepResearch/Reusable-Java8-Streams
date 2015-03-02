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
public interface DoubleIterable {
    
    public boolean hasNext();
    
    public double next();
    
    public void forEachRemaining(DoubleConsumer action);
}
