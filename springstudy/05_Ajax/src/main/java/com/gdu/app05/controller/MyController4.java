package com.gdu.app05.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.domain.Contact;
import com.gdu.app05.service.ContactService;

@Controller
public class MyController4 {

	
	// field
	@Autowired  // Container(SpringBeanConfig 클래스)에 등록된 bean 가져오기
	private ContactService contactService;

	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
		
	/*
		@RequestBody
		안녕. 난 요청 데이터가 body에 포함되어 있다고 알려주는 일을 해.
		요청 데이터를 꺼낼 때 요청 파라미터에서는 사용할 수 없어.(HttpServletRequest, @RequestParam, 커맨드 객체 모두 사용 불가)
		왜냐면 파라미터 이름 없이 값만 보내는 방식이거든.
		post 방식으로 파라미터 없이 값이 전달될 때 사용할 수 있어.
	*/
		
	@ResponseBody
	@PostMapping(value="/contact/detail1"
	           , produces=MediaType.APPLICATION_JSON_VALUE)
	public Contact detail1(@RequestBody Contact contact) {  // post 방식으로 넘어온 데이터를 Contact contact에 저장하시오.
		                                                    // 이 때 post 방식으로 넘어온 데이터는 JSON 데이터인데 어떻게 Contact contact 객체에 저장이 될까?
		                                                    // 그건 jackson이 자동으로 변환해 주기 때문이지.
		return contactService.execute1(contact);
	}
	
	
	@ResponseBody
	@PostMapping(value="/contact/detail2"
	           , produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> detail2(@RequestBody Map<String, Object> map) {  // jackson은 JSON 데이터를 Map으로도 잘 바꿔줘.
		return contactService.execute2(map);
	}
	
	
}
