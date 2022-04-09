package com.code4you.myurlshort.service;

import org.springframework.stereotype.Service;

import com.code4you.myurlshort.model.Url;
import com.code4you.myurlshort.model.UrlDto;

@Service
public interface UrlService {

	public Url generateShortLink(UrlDto urlDto);

	public Url saveShortLink(Url url);

	public Url getEncodedUrl(String url);

	public void deleteShortLink(Url url);
}
