package com.gdu.app05.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.domain.Member;
import com.gdu.app05.service.MemberService;

@Controller
public class MyController1 {
	
	
	// field
	@Autowired  // Container(root-context.xml)에서 타입(class)이 일치하는 bean을 가져오세요.
	private MemberService memberService;

	
	@GetMapping("/")
	public String index() {
		return "index";  // index.jsp로 forward
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";  // member.jsp로 forward
	}
	
	/*
		@ResponseBody
		안녕. 난 값을 반환하는 메소드에 붙는 애너테이션이야.
		내가 붙어 있는 메소드가 반환하는 건 뷰(JSP) 이름이 아니니까, 뷰 리졸버가 처리하지 말고
		어떤 값으로(text, json, xml 등) 해석해줘.
		반환 값은 요청이 들어온 곳으로 그대로 보내면 되. (요청한 곳과 응답할 곳이 같으니까 페이지 이동 없이 처리되는 ajax에서 쓰면 되겠네!!)
	*/
	
	@ResponseBody
	@GetMapping(value="/member/detail1"
			  , produces="text/plain; charset=UTF-8")  // produces : 응답 데이터 타입(MIME-TYPE), 메소드가 반환하는 데이터의 타입을 작성.
	public String detail1(HttpServletRequest request, HttpServletResponse response) {
		String str = memberService.execute1(request, response);
		return str;
	}
	
	
	
	@ResponseBody
	@GetMapping(value="/member/detail2"
	          , produces="application/json; charset=UTF-8")  // 응답 데이터는 JSON이다.
	public Member detail2(@RequestParam(value="id") String id
			            , @RequestParam(value="pw") String pw) {
		Member member = memberService.execute2(id, pw);
		return member;  // jackson이 member 객체를 {"id":아이디, "pw":패스워드} 형식의 JSON으로 바꿔서 전달합니다.
		/* 
			예전에는 이렇게 개발자가 직접 JSON으로 바꿔서 넘겼다. jackson은 스스로 변환하기 때문에 개발자가 변환 코드를 넣을 필요가 없다.
			JSONObject obj = new JSONObject(member);
			return obj.toString();
		*/
	}
	
	
	
	@ResponseBody
	@GetMapping(value="/member/detail3"
	          , produces="application/json; charset=UTF-8")
	public Map<String, Object> detail3(Member member) {
		Map<String, Object> map = memberService.execute3(member);
		return map;
		// return memberService.execute3(member);
	}
	
}
