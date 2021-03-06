package com.collection.lazy.generic.iterators;

import java.util.NoSuchElementException;

import com.collection.lazy.common.State;
import com.collection.lazy.generic.Peekable;

/**
 * 
 * @author kkishore
 *
 * @param <T>
 */
public abstract class StatefulIterator<T> extends ReadOnlyIterator<T> implements Peekable<T> {
	
    private State state = State.Ready;
    private T current;

    protected abstract T getNext() throws Exception;

    protected T finished() {
        state = State.Finished;
        return null;
    }

    public final boolean hasNext() {
        try {
            if (state.equals(State.Ready)) {
                current = getNext();
                if(state.equals(State.Finished)){
                    return false;
                }
                state = State.Loaded;
            }
            return !state.equals(State.Finished);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public final T next() {
        if (hasNext()) {
            return pop();
        }
        throw new NoSuchElementException();
    }

    public final T peek() {
        if (hasNext()) {
            return current;
        }
        throw new NoSuchElementException();
    }

    private T pop() {
        state = State.Ready;
        return current;
    }
}
