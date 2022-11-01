package com.gdu.app05.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.service.MemberService;
import com.gdu.app05.service.MemberServiceImpl;

@Controller
public class MyController1 {

	@GetMapping("/")
	public String index() {
		return "index";  // index.jsp로 forward
	}
	
	@GetMapping("member")
	public String member() {
		return "member";  // member.jsp로 forward
	}
	
	
	
	// field
	private MemberService memberService = new MemberServiceImpl();
	
	
	/*
		@ResponseBody
		안녕. 난 ajax 처리하는 메소드야.
		내가 반환하는 값은 뷰(JSP) 이름이 아니고, 어떤 데이터(text, json, xml 등)야.
	*/
	
	@ResponseBody
	@GetMapping(value="member/detail1"
			  , produces="text/plain; charset=UTF-8")  // produces : 응답 데이터 타입(MIME-TYPE)
	public String detail1(HttpServletRequest request) {
		String str = memberService.execute1(request);
		return str;
	}
	
	
	
	
	
	
	
	
	
}
