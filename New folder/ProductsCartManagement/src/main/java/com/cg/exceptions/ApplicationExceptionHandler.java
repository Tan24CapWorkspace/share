package com.cg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler({ApplicationException.class})
	public ResponseEntity<String> handleError(ApplicationException exception){
		System.out.println("Exception Handeled");
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
