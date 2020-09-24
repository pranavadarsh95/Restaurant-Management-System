package com.pranavadarsh.RestaurantManagementSystem.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReservationGlobalException {
 
/*	@ExceptionHandler
	public ResponseEntity<Object> handleException(TableUnAvailableException ire){
		ReservationResponseException error=new ReservationResponseException();
		
		System.out.println("inside exception");
		error.setMessage(ire.getMessage());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	*/
	@ExceptionHandler
	public ResponseEntity<Object> handleException(Exception ire){
		ReservationResponseException error=new ReservationResponseException();
		
		error.setMessage(ire.getMessage());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	
}
