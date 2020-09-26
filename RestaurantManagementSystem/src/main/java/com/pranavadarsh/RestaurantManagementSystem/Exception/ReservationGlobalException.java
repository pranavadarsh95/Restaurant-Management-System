package com.pranavadarsh.RestaurantManagementSystem.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReservationGlobalException {
 
	@ExceptionHandler
	public ResponseEntity<Object> handleException(TableUnAvailableException ire){
		ReservationResponseException error=new ReservationResponseException();
		
		System.out.println("inside exception");
		error.setMessage(ire.getMessage());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	
	//This exception handler method is for variable validation and will be handled in  the post method of Controller API.
	
	 @ExceptionHandler
	public ResponseEntity<Object> CustomValidationErrorhandleingException(MethodArgumentNotValidException pakroError) {
		ReservationResponseException error = new ReservationResponseException();

		System.out.println("Inside MethodArgumentNotValidException " + pakroError.getMessage());
		error.setMessage(pakroError.getMessage());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler
	public ResponseEntity<Object> GlobalhandleException(Exception ire){
		ReservationResponseException error=new ReservationResponseException();
		
		System.out.println("Inside GlobalhandleException "+ire.getMessage());
		error.setMessage(ire.getMessage());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	
}
