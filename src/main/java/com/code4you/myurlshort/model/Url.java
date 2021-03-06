package com.code4you.myurlshort.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDateTime;

/*
 * Entity class to store details of url in db
 */
@Entity
public class Url {
	// Required attributes
	@Id
	@GeneratedValue
	private long id;
	@Lob
	private String originalUrl;
	private String shortLink;
	private LocalDateTime creationDate;
	private LocalDateTime expirationDate;

	// parameterized constructor
	public Url(long id, String originalUrl, String shortLink, LocalDateTime creationDate,
			LocalDateTime expirationDate) {
		this.id = id;
		this.originalUrl = originalUrl;
		this.shortLink = shortLink;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
	}

	// default constructor
	public Url() {
	}

	// getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
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
		return "Url{" + "id=" + id + ", originalUrl='" + originalUrl + '\'' + ", shortLink='" + shortLink + '\''
				+ ", creationDate=" + creationDate + ", expirationDate=" + expirationDate + '}';
	}
}
