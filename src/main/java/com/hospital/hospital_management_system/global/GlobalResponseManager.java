package com.hospital.hospital_management_system.global;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestControllerAdvice
public class GlobalResponseManager extends ResponseEntityExceptionHandler  {

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<Object> handleException(Exception ex) {
//		Error error = new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error", ex.getMessage());
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
//	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	
		String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
	    Error error = new Error(status.value(), "Error", errorMessage);
	    return ResponseEntity.status(status).body(error);
		
	}
	
	public ResponseEntity<Object> successResponse(HttpStatusCode status, String message, Object data) {
		
		Success success = new Success(status.value(), "SUCCESS", message, data);
		
		return ResponseEntity.status(status).body(success);
		
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	class Error {
		
		private int code;
		
		private String status;
		
		private String message;
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class Success {
		
		private int code;
		
		private String status;
		
		private String message;
		
		private Object data;
	}

}
