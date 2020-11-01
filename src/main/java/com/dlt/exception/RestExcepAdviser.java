package com.dlt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dlt.enumconstant.ApiErrorCode;

@ControllerAdvice
public class RestExcepAdviser {
	private ResponseEntity<Object> buildResponse(int status, Exception e, boolean isError) {
		return ResponseEntity.status(status).body(new ApiResponse(status, e.getMessage(), isError));
	}

	@ExceptionHandler({ RestException.class })
	public ResponseEntity<Object> handle(RestException e) {
		return this.buildResponse(e.getStatus(), e, e.isError());
	}
	
	private ResponseEntity<Object> buildResponseValidation(ApiErrorCode e) {
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(e,false));
	}
	@ExceptionHandler({ RestValidationException.class })
	public ResponseEntity<Object> handle(RestValidationException e) {
		return this.buildResponseValidation(e.getApiErrorCode());
	}
}
