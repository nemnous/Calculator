package com.nemnous.calculator.exceptions;

@SuppressWarnings("serial")
public class InvalidArgumentsException extends RuntimeException{
	private final String message;

    /**
     * Constructor with message as parameter.
     * @param message
     */
    public InvalidArgumentsException(final String message) {
        this.message = message;
    }


    /**
     * Overloaded constructor with a Throwable cause passed to
     * the super constructor and message.
     * @param cause
     * @param message
     */
    public InvalidArgumentsException(final Throwable cause, final String message) {
        super(cause);
        this.message = message;
    }

    /**
     * getter function for the private variable message.
     * @return message
     */
    @Override
    public String getMessage() {
        return message;
    }
}
