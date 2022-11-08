package com.gdu.app11.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class EmpServiceImpl implements EmpService {

	@Override
	public void findAllEmployees(HttpServletRequest request, Model model) {
		
		// request에서 page 파라미터 꺼내기
		// page 파라미터가 전달되지 않는 경우 page = 1로 처리한다.
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		
		
		

	}

}
