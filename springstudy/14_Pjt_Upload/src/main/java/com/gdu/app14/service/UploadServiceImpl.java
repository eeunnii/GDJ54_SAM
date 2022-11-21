package com.gdu.app14.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app14.domain.UploadDTO;
import com.gdu.app14.mapper.UploadMapper;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private UploadMapper uploadMapper;
	
	@Override
	public List<UploadDTO> getUploadList() {
		return uploadMapper.selectUploadList();
	}
	
	@Transactional
	@Override
	public void save(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		
		/*  UPLOAD 테이블에 저장하기 */
		
		// 파라미터
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		
		// DB로 보낼 UploadDTO
		UploadDTO upload = UploadDTO.builder()
				.title(title)
				.content(content)
				.build();
		
		// DB에 UploadDTO 저장
		int uploadResult = uploadMapper.insertUpload(upload);  // <selectKey>에 의해서 인수 upload에 uploadNo값이 저장된다.
		
		/* ATTACH 테이블에 저장하기 */
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
