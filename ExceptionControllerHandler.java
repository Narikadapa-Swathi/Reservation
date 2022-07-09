package com.cg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.exception.ReservationNotFoundException;

@ControllerAdvice
public class ExceptionControllerHandler {
	
	@SuppressWarnings({"rawtypes","unchecked"})
	@ExceptionHandler(value =ReservationNotFoundException.class)
	public ResponseEntity<Object>ReservationExceptionHandler(Exception ex){
		return new ResponseEntity("Reservation Not Found",HttpStatus.NOT_FOUND);
	}
	
	
}

