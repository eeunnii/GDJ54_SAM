package com.gdu.app04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("member")  // URL Mapping이 member로 시작하는 모든 요청을 처리하는 컨트롤러
@Controller
public class MyController1 {

	
	// <a href="${contextPath}/member/detail">
	@GetMapping("detail")        // member/detail 요청을 처리하시오.
	public String detail() {
		return "member/detail";  // member 폴더 아래 detail.jsp로 forward 하시오.
	}
	
	
	
}
