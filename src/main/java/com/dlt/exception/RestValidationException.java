package com.dlt.exception;

import com.dlt.enumconstant.ApiErrorCode;

public class RestValidationException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private ApiErrorCode apiErrorCode;
	
	
	public ApiErrorCode getApiErrorCode() {
		return apiErrorCode;
	}


	public void setApiErrorCode(ApiErrorCode apiErrorCode) {
		this.apiErrorCode = apiErrorCode;
	}


	public RestValidationException(ApiErrorCode apiErrorCode) {
		super();
		this.apiErrorCode = apiErrorCode;
	}
}
