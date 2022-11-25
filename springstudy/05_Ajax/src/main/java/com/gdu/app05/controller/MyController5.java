package com.gdu.app05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.service.GalleryService;

@Controller
public class MyController5 {
	
	
	@Autowired
	private GalleryService galleryService;

	
	@GetMapping("/gallery")  // 반환이 void인 경우 mapping을 뷰(JSP)이름으로 인식합니다. 그러니까 gallery.jsp로 이동됩니다.
	public void gallery() {
		
	}
	
	@ResponseBody
	@GetMapping("/image/display")
	public ResponseEntity<byte[]> display(@RequestParam String path, @RequestParam String filename) {
		return galleryService.imageDisplay(path, filename);
	}
	
	
}
