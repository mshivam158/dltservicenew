package com.dlt.exception;

public class RestException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int status;
	private boolean isError;

	public int getStatus() {
		return this.status;
	}

	public RestException(String msg) {
		super(msg);
	}

	public RestException(String msg, int status) {
		super(msg);
		this.status = status;
		this.isError = true;
	}

	public RestException(String msg, int status, boolean isError) {
		super(msg);
		this.status = status;
		this.isError = isError;
	}

	public boolean isError() {
		return this.isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
