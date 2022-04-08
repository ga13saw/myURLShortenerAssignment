package com.code4you.myurlshort.model;

/*
 * This class is used as error response
 */
public class UrlErrorResponseDto {
	
	// Required attributes
	private String status;
	private String error;
	
	// parameterized constructor
	public UrlErrorResponseDto(String status, String error) {
		this.status = status;
		this.error = error;
	}
	// default constructor
	public UrlErrorResponseDto() {
	}
	
	// getters and setters
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	// to string method overridden
	@Override
	public String toString() {
		return "UrlErrorResponseDto{" + "status='" + status + '\'' + ", error='" + error + '\'' + '}';
	}
}
