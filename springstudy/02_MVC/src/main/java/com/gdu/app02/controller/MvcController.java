package com.gdu.app02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
	@Controller
	
	안녕. 난 컨트롤러야.
	@Component에 의해서 자동으로 Bean으로 만들어 지고 스프링에 의해서 사용되지.
*/

@Controller
public class MvcController {


	// 메소드 1개 : 요청 1개와 응답 1개를 처리하는 단위
	
	
	/*
		@RequestMapping
		
		안녕. 난 요청을 인식하는 애너테이션이야.
		URL매핑과 요청메소드(GET/POST)를 인식하지.
		
		속성
			1) value  : URLMapping
			2) method : RequestMethod
	*/
	
	
	// welcome 파일 작업하기
	// URLMapping으로 "/"를 요청하면 "/WEB-INF/views/index.jsp"를 열어준다.
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	
	
	// 메소드 작성 방법
	// 1. 반환타입 : String (응답할 뷰(JSP)의 이름을 반환)
	// 2. 메소드명 : 아무 일도 안함. 맘대로 작성.
	// 3. 매개변수 : 선택 (요청이 있으면 request, 응답을 만들면 response 등)
	
	public String welcome() {
		return "index";  // DispatcherServlet의 ViewResolver에 의해서 해석된다.
		                 // prefix="/WEB-INF/views/"
		                 // suffix=".jsp"
		                 // prefix와 suffix에 의해서 "/WEB-INF/views/index.jsp"와 같이 해석되고 처리된다.
		
		// index.jsp로 forward했을까? redirect했을까?
		// 정답 : forward했다.
		// redirect할때는 return "redirect:경로"; 처럼 반환한다.
	}
	
	
	
	// <a href="${contextPath}/animal">
	@RequestMapping(value="/animal", method=RequestMethod.GET)
	
	public String 동물보러가기() {
		// /WEB-INF/views/ + gallery/animal + .jsp
		return "gallery/animal";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
