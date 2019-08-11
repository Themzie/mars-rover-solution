package com.tanganda.marsrover.exception;

public class CommandInvalidException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	private String keyMessage = "error.command_invalid";
	
	public CommandInvalidException() {
		super();
	}
	
	public String getKeyMessage() {
		return keyMessage;
	}
}
