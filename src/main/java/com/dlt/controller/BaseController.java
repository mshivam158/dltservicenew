package com.dlt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

<<<<<<< HEAD
import com.dlt.enumconstant.ApiErrorCode;
=======
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
import com.dlt.exception.ApiResponse;
import com.dlt.exception.RestException;
import com.dlt.model.EOObject;

public class BaseController {

	protected ResponseEntity<Object> deleteSuccess() {
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(HttpStatus.OK.value(), "Record Deleted Successfully!", false));
	}

	protected void handlePKValidation(long id) {
		if (id < 1) {
			throw new RestException("Supplied PK cann't be Zero or negative", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}
<<<<<<< HEAD
	protected ResponseEntity<Object> successResponseForObj(EOObject eoObject) {
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse().buildSuccess(eoObject));
	}
	protected ResponseEntity<Object> successResponseForObj(EOObject eoObject,ApiErrorCode apiErrorCode) {
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse().buildSuccess(eoObject,apiErrorCode));
	}
=======

	protected ResponseEntity<Object> successResponseForObj(EOObject eoObject) {
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse().buildSuccess(eoObject));
	}
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52

	protected ResponseEntity<Object> successResponseForList(List<? extends EOObject> eoObjectList) {
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse().buildSuccess(eoObjectList));
	}

	protected ResponseEntity<Object> successForDto(Object object) {
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse().buildSuccess(object));
	}
}
