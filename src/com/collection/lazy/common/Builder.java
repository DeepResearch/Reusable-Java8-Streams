package com.collection.lazy.common;

import java.util.function.Consumer;

import com.collection.lazy.util.LazyCollection;

/**
 * 
 * @author kkishore
 *
 * Builder class for LazyCollection
 *
 * @param <T>
 */
public interface Builder<T> extends Consumer<T> {

    
    @Override
    void accept(T t);

   
    default Builder<T> add(T t) {
        accept(t);
        return this;
    }
    
    LazyCollection<T> build();

}