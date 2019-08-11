package com.tanganda.marsrover.controller.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tanganda.marsrover.exception.CommandInvalidException;
import com.tanganda.marsrover.exception.ExceededBoundaryException;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(CommandInvalidException.class)
    public ResponseEntity<?> commandInvalidExceptionHandler(HttpServletRequest req, final CommandInvalidException ex){
		String message = getMessage(ex.getKeyMessage());
		return ResponseEntity.badRequest().body(message);
    }
	
	@ExceptionHandler(ExceededBoundaryException.class)
    public ResponseEntity<?> exceededBoundaryExceptionHandler(HttpServletRequest req, final ExceededBoundaryException ex){
        String message = getMessage(ex.getKeyMessage());
        return ResponseEntity.badRequest().body(message);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(){
        String message = getMessage("error.unexpected");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }
	
	private String getMessage(final String key) {
       return messageSource.getMessage(key, null, null);
    }
}
