package com.cg.webapp.exception;

import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.Path.ReturnValueNode;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(CustomerNotFoundException.class)
     public ResponseEntity<ErrorDetails> handleCNFE(CustomerNotFoundException cnfe,WebRequest req) {
     ErrorDetails err=new ErrorDetails(LocalDateTime.now(), cnfe.getMessage(), req.getDescription(false));
	 ResponseEntity<ErrorDetails> re=new ResponseEntity<ErrorDetails>(err,HttpStatus.NOT_FOUND);
	 return re;
	 }
	 
	 @ExceptionHandler(MerchantNotFoundException.class)
	 public ResponseEntity<ErrorDetails> handleMNFE(MerchantNotFoundException mnfe,WebRequest req)  {
	 ErrorDetails err=new ErrorDetails(LocalDateTime.now(), mnfe.getMessage(), req.getDescription(false));
	 ResponseEntity<ErrorDetails> re = new ResponseEntity<ErrorDetails>(err,HttpStatus.NOT_FOUND);
     return re;				
	 }
   
     @ExceptionHandler(PackageNotAvailableException.class)
   	 public ResponseEntity<ErrorDetails> handlePNAE(PackageNotAvailableException pnae,WebRequest req)  {
     ErrorDetails err=new ErrorDetails(LocalDateTime.now(), pnae.getMessage(), req.getDescription(false));
     ResponseEntity<ErrorDetails> re = new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
   	 return re;				
   	}
   
    @ExceptionHandler(PackageNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlePNFE(PackageNotFoundException pnfe,WebRequest req)  {
    ErrorDetails err=new ErrorDetails(LocalDateTime.now(), pnfe.getMessage(), req.getDescription(false));
    ResponseEntity<ErrorDetails> re = new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	return re;
	}
   
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> notFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {
    ErrorDetails err=new ErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
    ResponseEntity<ErrorDetails> re = new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	return re;		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> myExceptionHandler(Exception e,WebRequest req)  {
	ErrorDetails err=new ErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
	ResponseEntity<ErrorDetails> re=new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	return re;
	}	
	
}
