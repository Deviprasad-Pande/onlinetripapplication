package com.cg.webapp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerNotFoundException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getLocalizedMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
		
   @ExceptionHandler(value = MerchantNotFoundException.class)
		public ResponseEntity<Object> exception(MerchantNotFoundException exception, WebRequest request) {
			ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getLocalizedMessage(),
					request.getDescription(false));
			return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
   @ExceptionHandler(value = PackageNotAvailableException.class)
			public ResponseEntity<Object> exception(PackageNotAvailableException exception, WebRequest request) {
				ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getLocalizedMessage(),
						request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
  @ExceptionHandler(value = PackageNotFoundException.class)
				public ResponseEntity<Object> exception(PackageNotFoundException exception, WebRequest request) {
					ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getLocalizedMessage(),
							request.getDescription(false));
					return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
}
