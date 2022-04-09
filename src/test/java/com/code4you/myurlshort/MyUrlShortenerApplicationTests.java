package com.code4you.myurlshort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.code4you.myurlshort.model.Url;
import com.code4you.myurlshort.model.UrlDto;
import com.code4you.myurlshort.repository.UrlRepository;
import com.code4you.myurlshort.service.UrlService;
import com.code4you.myurlshort.service.UrlServiceImpl;

@SpringBootTest
class MyUrlShortenerApplicationTests {

	@Autowired
	UrlService service;

	@Autowired
	UrlRepository repository;

	@Test
	public void testUrl() {
		Url generateShortLink = service
				.generateShortLink(new UrlDto("https://www.youtube.com/watch?v=KkYVnj0k6Sw", null));
		System.out.println(generateShortLink.getShortLink());
		assertNotNull(repository.findByShortLink(generateShortLink.getShortLink()));
		
	}

	@Test
	public void testNullValues() {
		Url generateShortLink = service.generateShortLink(null);
		assertNull(generateShortLink);
	}
	
	@Test
	public void testEncodedUrl() {
		String generateShortLink = new UrlServiceImpl().encodeUrl("https://www.youtube.com/watch?v=KkYVnj0k6Sw");
		assertNotNull(generateShortLink);
	}
	
	@Test
	public void testEncodedSameUrl() {
		String firstShortLink = new UrlServiceImpl().encodeUrl("https://www.youtube.com/watch?v=KkYVnj0k6Sw");
		String secondShortLink = new UrlServiceImpl().encodeUrl("https://www.youtube.com/watch?v=KkYVnj0k6Sw");
		
		assertEquals(firstShortLink,secondShortLink);
	}
	
	@Test
	public void testEncodedNotSameUrl() {
		String firstShortLink = new UrlServiceImpl().encodeUrl("https://www.youtube.com/watch?v=KkYVnj0k6Sw");
		String secondShortLink = new UrlServiceImpl().encodeUrl("https://www.youtube.com/watch?v=dfdfdssy6Sw");
		
		assertNotEquals(firstShortLink,secondShortLink);
	}
	
	@Test
	public void testgetEncodedUrl() {
		Url actual = service.getEncodedUrl("d715ce8b");
		String expected = "https://www.youtube.com/watch?v=KkYVnj0k6Sw";
		
		assertNotEquals(expected,actual);
	}
	
	
	
	
	
}
