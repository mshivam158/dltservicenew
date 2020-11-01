package com.dlt.exception;

import java.io.Serializable;

import com.dlt.enumconstant.ApiErrorCode;

public class ApiResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private int status;
	private String msg;
	private boolean isError;
	private String errorCode;

	private Object data;

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ApiResponse() {
		super();
	}

	public ApiResponse(ApiErrorCode errorCode) {
		super();
		this.isError = true;
		this.msg = errorCode.getMsg();
		this.errorCode = errorCode.getId();
	}

	public ApiResponse(ApiErrorCode errorCode, boolean isError) {
		super();
		this.isError = isError;
		this.msg = errorCode.getMsg();
		this.errorCode = errorCode.getId();
	}

	public ApiResponse(int status, String msg, boolean isError) {
		super();
		this.status = status;
		this.msg = msg;
		this.isError = isError;
	}

	public ApiResponse(int status, String msg, boolean isError, ApiErrorCode errorCode) {
		super();
		this.status = status;
		this.msg = msg;
		this.isError = isError;
		this.errorCode = errorCode.getId();
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isError() {
		return this.isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public ApiResponse buildSuccess(Object data) {
		this.data = data;
		this.isError = false;
		this.status = 200;
		return this;
	}

	public ApiResponse buildSuccess(Object data, ApiErrorCode apiErrorCode) {
		this.data = data;
		this.isError = false;
		this.status = 200;
		this.msg = apiErrorCode.getMsg();
		return this;
	}
}
