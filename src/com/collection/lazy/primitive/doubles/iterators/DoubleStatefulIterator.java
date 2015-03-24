package com.collection.lazy.primitive.doubles.iterators;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;

import com.collection.lazy.common.State;
import com.collection.lazy.primitive.doubles.DoublePeekable;

/**
 * 
 * @author kkishore
 *
 */
public abstract class DoubleStatefulIterator implements PrimitiveIterator.OfDouble, DoublePeekable{
	
	private State state = State.Ready;
	private double current;
	
	protected abstract double getNext() throws Exception;
	
	protected double finished(){
		state = State.Finished;
		return 0;
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

    public final Double next() {
        if (hasNext()) {
            return pop();
        }
        throw new NoSuchElementException();
    }
    
    public final double nextDouble() {
        if (hasNext()) {
            return pop();
        }
        throw new NoSuchElementException();
    }

    public final double peek() {
        if (hasNext()) {
            return current;
        }
        throw new NoSuchElementException();
    }

    private double pop() {
        state = State.Ready;
        return current;
    }


}
