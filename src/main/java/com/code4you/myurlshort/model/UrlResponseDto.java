package com.code4you.myurlshort.model;

import java.time.LocalDateTime;

/*
 * This class will carry correct response data
 */
public class UrlResponseDto {

	// Required attributes
	private String originalUrl;
	private String shortLink;
	private LocalDateTime expirationDate;

	// parameterized constructor
	public UrlResponseDto(String originalUrl, String shortLink, LocalDateTime expirationDate) {
		this.originalUrl = originalUrl;
		this.shortLink = shortLink;
		this.expirationDate = expirationDate;
	}

	// default constructor
	public UrlResponseDto() {
	}

	// getters and setters
	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getShortLink() {
		return shortLink;
	}

	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	// to string method overridden
	@Override
	public String toString() {
		return "UrlResponseDto{" + "originalUrl='" + originalUrl + '\'' + ", shortLink='" + shortLink + '\''
				+ ", expirationDate=" + expirationDate + '}';
	}
}
