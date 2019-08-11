package com.tanganda.marsrover.exception;

public class ExceededBoundaryException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private String keyMessage = "error.exceeded_boundary";
	
	public ExceededBoundaryException() {
		super();
	}
	
	public String getKeyMessage() {
		return keyMessage;
	}
}
