package com.code4you.myurlshort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code4you.myurlshort.model.Url;

/*
 * 1. This interface extends JPARepo to basic DB operations and others
 * 2. findByShortLink() is custom method to find url details from db based on short url
 */
@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
	
	//Get URL details from DB based on short link
	 public Url findByShortLink(String shortLink);
}
