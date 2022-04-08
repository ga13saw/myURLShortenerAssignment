package com.code4you.myurlshort.service;

import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.code4you.myurlshort.model.Url;
import com.code4you.myurlshort.model.UrlDto;
import com.code4you.myurlshort.repository.UrlRepository;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

import java.time.LocalDateTime;

/*
 * Implementation class of UrlService interface
 */
@Component
public class UrlServiceImpl implements UrlService {

    private static final Logger logger = LoggerFactory.getLogger(UrlServiceImpl.class);
    @Autowired
    private UrlRepository urlRepository;
    
    /*
     * 1. This method first checks entered url is empty or not. If empty return null
     * 2. Convert long url to short url
     * 3. Set other metadata of url into url object
     * 4. Save url details into DB
     * 5. If some issue occurred and it didn't save then return null
     */
    @Override
    public Url generateShortLink(UrlDto urlDto) {

        if(StringUtils.isNotEmpty(urlDto.getUrl()))
        {
            String encodedUrl = encodeUrl(urlDto.getUrl());
            Url urlToSave = new Url();
            urlToSave.setCreationDate(LocalDateTime.now());
            urlToSave.setOriginalUrl(urlDto.getUrl());
            urlToSave.setShortLink(encodedUrl);
            urlToSave.setExpirationDate(getExpirationDate(urlDto.getExpirationDate(),urlToSave.getCreationDate()));
            Url urlToRet = saveShortLink(urlToSave);

			if (urlToRet != null)
                return urlToRet;

            return null;
        }
        return null;
    }
    
    /*
     * 1. Helper method to get expiry time
     * 2. If user provides expiry time then return otherwise add 2 mins in current time and return
     */
    private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate)
    {
        if(StringUtils.isBlank(expirationDate))
        {
            return creationDate.plusSeconds(120);
        }
        LocalDateTime expirationDateToRet = LocalDateTime.parse(expirationDate);
        return expirationDateToRet;
    }
    
    /*
     * 1. Encode long url into short using google guava plugin's adler32 hasing method
     * 2. For uniqueness of every url, we are concatenating long url with current time and then hashing it to get short url
     */
    private String encodeUrl(String url)
    {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.adler32()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
                .toString();
        return  encodedUrl;
    }
    
    //This method will save the url details into Database
    @Override
    public Url saveShortLink(Url url) {
        Url urlToRet = urlRepository.save(url);
        return urlToRet;
    }
    
    //This method will fetch url details from db based on short link
    @Override
    public Url getEncodedUrl(String url) {
        Url urlToRet = urlRepository.findByShortLink(url);
        return urlToRet;
    }
    
    //This method deletes the url record from db 
    @Override
    public void deleteShortLink(Url url) {

        urlRepository.delete(url);
    }
}
