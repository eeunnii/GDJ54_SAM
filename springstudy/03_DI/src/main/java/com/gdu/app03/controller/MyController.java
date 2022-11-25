package com.gdu.app03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.app03.domain.Board;
import com.gdu.app03.domain.Notice;

@Controller
public class MyController {
	
	/*
		@RequestMapping(value="/", method=RequestMethod.GET)
		@RequestMapping(value="/", method=RequestMethod.POST)
		
		Spring4부터 새로운 애너테이션으로 바꿀 수 있다.
		
		@GetMapping("/")
		@PostMapping("/")
	*/
	
	@GetMapping("/")  // http://localhost:9090/app03/으로 접속하면 처리되는 메소드
	public String welcome() {
		return "default";
		// ViewResolver에 의해서
		// return "/WEB-INF/views/default.jsp"로 해석된다.
	}
	
	
	/*
		Container에 등록된 Bean을 가져오는 방법
		
		1. @Inject
			1) 타입(class)이 일치하는 Bean을 가져오는 애너테이션
			2) 동일 타입이 여러 개 있는 경우 @Qualifier를 이용해서 Bean을 식별
		2. @Resource
			1) 이름(id)이 일치하는 Bean을 가져오는 애너테이션
			2) 이름(id)이 일치하는 Bean이 없으면 에러 뿜음
		3. @Autowired
			1) 타입(class)이 일치하는 Bean을 가져오는 애너테이션
			2) 동일 타입이 여러 개 있는 경우 자동으로 Bean의 이름(id)이 일치하는 Bean을 식별
			3) 대부분 이걸 사용
	*/
	
	/*
		@Autowired 사용 방법
		
		1. 필드로 생성된 Bean 가져오기
			1) 필드마다 @Autowired를 추가한다. (필드가 10개이면 @Autowired도 10번 작성)
			2) 필드가 많으면 사용하지 않는다.
		2. 생성자를 이용해 Bean 가져오기
			1) 생성자에 선언된 매개변수에 Bean을 자동으로 넣어준다(자동 주입).
			2) @Autowired를 작성할 필요가 없다.
		3. 메소드를 이용해 Bean 가져오기
			1) 메소드에 선언된 매개변수에 Bean을 자동으로 넣어준다(자동 주입).
			2) @Autowired를 꼭 작성해야 한다.
			3) 일반적으로 setter를 사용하지만 setter가 아니어도 상관 없다.
	*/
	 
	/*
 		@Autowired를 사용하는 이유 : @Inject + @Qualifier
 		
		@Inject
		@Qualifier(value="board1")
		private Board board1;
		
		@Inject
		@Qualifier(value="board2")
		private Board board2;
	*/
	
	
	// 1. 필드로 생성된 Bean 가져오기
	/*
		@Autowired는 우선 타입(class)이 일치하는 Bean을 Container에서 가져온다.
		동일 타입이 여러 개이면 이름(id)이 일치하는 Bean을 Container에서 가져온다.
		
		@Autowird
		private Board board1;  // 타입(class)이 Board인 Bean을 Container에서 가져오거라.
		                       // 타입이 똑같은 게 2개 이상 있으면 이름(id)이 board1인 Bean을 가져오거라.
		
		@Autowired
		private Board board2;  // @Autowired는 필드마다 붙여야 한다.
		
		---- Container(root-context.xml) ---------
		   <bean id="board1" class="Board">
		   <bean id="board2" class="Board">
		------------------------------------------
	*/
	
	
	
	// 2. 생성자를 이용해 Bean 가져오기
	/*
	// 생성자에는 @Autowired를 생략할 수 있다. 
	public MyController(Board board1, Board board2) {  // 매개변수 Board board1과 Board board2에 @Autowired된다.
		
	}
	*/
	
	
	
	// 3. 메소드를 이용해 Bean 가져오기
	/*
	@Autowired  // 일반 메소드는 @Autowired를 반드시 작성해야 한다.
	            // 메소드 이름은 아무 거나 써도 된다.
	public void setBoard(Board board1, Board board2) {  // 매개변수 Board board1과 Board board2에 @Autowired된다.
		
	}
	*/
	

	
	/* 필드에 @Autowired하기 - 최종 정리 */

	
	// 4-1. 필드마다 직접 @Autowired 하기
	/*
		@Autowired
		private Board board1;
		
		@Autowired
		private Board board2;
	*/
	
	
	// 4-2. @Autowired 없이 생성자 선언하기
	/*
		private Board board1;
		private Board board2;
		public MyController(Board board1, Board board2) {
			this.board1 = board1;
			this.board2 = board2;
		}
	*/

	
	// 4-3. 메소드를 이용해 @Autowired 하기
	private Board board1;
	private Board board2;
	
	@Autowired
	public MyController(Board board1, Board board2) {
		this.board1 = board1;
		this.board2 = board2;
	}


	@GetMapping("/board")  // http://localhost:9090/app03/board/
	public void boardDetail() {
		System.out.println(board1.getBoardNo());
		System.out.println(board1.getTitle());
		System.out.println(board1.getCreateDate());
		System.out.println(board2.getBoardNo());
		System.out.println(board2.getTitle());
		System.out.println(board2.getCreateDate());
	}
	
	
	////////////////////////////////////////////////////////////////////
	// 연습 : SpringBeanConfig.java에 notice1, notice2 2개 Bean을 만들어
	// @Autowired 연습해 보기
	////////////////////////////////////////////////////////////////////
	
	@Autowired
	private Notice notice1;
	
	@Autowired
	private Notice notice2;
	
	
	@GetMapping("/notice")  // http://localhost:9090/app03/notice/
	public void noticeDetail() {
		System.out.println(notice1.getNoticeNo());
		System.out.println(notice1.getTitle());
		System.out.println(notice2.getNoticeNo());
		System.out.println(notice2.getTitle());
	}
	
	
}
