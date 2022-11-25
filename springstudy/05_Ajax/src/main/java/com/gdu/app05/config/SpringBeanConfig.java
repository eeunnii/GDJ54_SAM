package com.gdu.app05.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app05.service.BoardService;
import com.gdu.app05.service.BoardServiceImpl;
import com.gdu.app05.service.ContactService;
import com.gdu.app05.service.ContactServiceImpl;
import com.gdu.app05.service.GalleryService;
import com.gdu.app05.service.GalleryServiceImpl;

@Configuration
public class SpringBeanConfig {

	// 여기에 없는 Bean은 root-context.xml에 있으니 확인해 볼 것. (어디에 만들든 상관 없는 거 OK?)
	
	@Bean
	public BoardService boardService() {
		return new BoardServiceImpl();
	}
	
	@Bean
	public ContactService contactService() {
		return new ContactServiceImpl();
	}
	
	@Bean
	public GalleryService galleryService() {
		return new GalleryServiceImpl();
	}
	
}
