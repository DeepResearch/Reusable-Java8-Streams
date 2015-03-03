package com.awesomeml.collection.lazy.exception;

public class LapackException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Construct new LapackException for the given function. */
public LapackException(String function) {
	super("LAPACK " + function);
}

    /** Construct new Lapack Exception for the given function, with message. */
public LapackException(String function, String message) {
	super("LAPACK " + function + ": " + message);
}
}