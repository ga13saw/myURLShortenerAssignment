package com.code4you.myurlshort.model;

/*
 * This class get maps to input fields
 */
public class UrlDto {
	
	// Required attributes
	private String url;
	private String expirationDate; // optional
	
	// parameterized constructor
	public UrlDto(String url, String expirationDate) {
		this.url = url;
		this.expirationDate = expirationDate;
	}
	
	// default constructor
	public UrlDto() {
	}
	
	// getters and setters
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	// to string method overridden
	@Override
	public String toString() {
		return "UrlDto{" + "url='" + url + '\'' + ", expirationDate='" + expirationDate + '\'' + '}';
	}
}
