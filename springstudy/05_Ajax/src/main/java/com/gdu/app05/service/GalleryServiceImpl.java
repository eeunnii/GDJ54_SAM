package com.gdu.app05.service;

import java.io.File;
import java.nio.file.Files;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;

public class GalleryServiceImpl implements GalleryService {

	@Override
	public ResponseEntity<byte[]> imageDisplay(String path, String filename) {
		
		File file = new File(path, filename);
		
		ResponseEntity<byte[]> entity = null;
		
		try {
			
			String contentType = Files.probeContentType(file.toPath());  // 전달 받은 파일의 Content-Type 알아내기
			
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", contentType);  // header.add("Content-Type", "image/jpeg");
			
			// FileCopyUtils.copyToByteArray(file)
			// File 객체로 전달된 파일을 바이트 배열(byte[])로 변경해 줌
			// 이미지나 동영상을 바이트 배열로 바꿔서 뷰로 보내면 뷰에서는 이미지나 동영상이 실제로 표시됨
			
			entity = new ResponseEntity<byte[]>( FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return entity;
		
	}

}
