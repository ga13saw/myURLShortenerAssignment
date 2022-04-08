package com.code4you.myurlshort.service;

import org.springframework.stereotype.Service;

import com.code4you.myurlshort.model.Url;
import com.code4you.myurlshort.model.UrlDto;

/*
 * This service class contains all methods related to our functionality
 */
@Service
public interface UrlService
{
    //It'll generate short url based on input url
	public Url generateShortLink(UrlDto urlDto);
	
	//It'll save the short url
    public Url saveShortLink(Url url);
    
    //It'll create the encoded tiny url using google guava plugin
    public Url getEncodedUrl(String url);
    
    //It'll delete the url record
    public  void  deleteShortLink(Url url);
}
