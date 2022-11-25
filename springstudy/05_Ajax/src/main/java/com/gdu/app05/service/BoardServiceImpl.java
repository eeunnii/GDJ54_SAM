package com.gdu.app05.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.gdu.app05.domain.Board;

public class BoardServiceImpl implements BoardService {

	
	/*
		ResponseEntity<T> 클래스
		안녕. 난 값을 반환하기 위해서 사용하는 클래스야.
		@ResponseBody와 찰떡궁합이지. 스프링 3 이상에서 사용할 수 있어.
		
		
		ResponseEntity<T>의 생성자 중 하나 해석해 보기
		
		  new ResponseEntity<T>(T body, HttpHeaders header, HttpStatus status)
		
		    1) T body             : 실제 응답할 값
		    2) HttpHeaders header : 응답 헤더
		    3) HttpStatus status  : 응답 코드(200, 404, 500 등)
	*/	
	
	
	@Override
	public ResponseEntity<Board> execute1(HttpServletRequest request) {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Board board = null;
		
		ResponseEntity<Board> entity = null;
		if(title.isEmpty()) {  // 제목이 비어 있으면 오류 처리, 아니면 정상 처리
			entity = new ResponseEntity<Board>(board, HttpStatus.INTERNAL_SERVER_ERROR);  // status가 오류(INTERNAL_SERVER_ERROR)이므로 $.ajax()의 error에서 처리됨
		} else {
			board = new Board(title, content);
			entity = new ResponseEntity<Board>(board, HttpStatus.OK);  // status가 정상(OK)이므로 $.ajax()의 success에서 처리됨
		}
		
		return entity;
		
	}

	@Override
	public ResponseEntity<Board> execute2(String title, String content) {
		
		ResponseEntity<Board> entity = null;
		
		if(title.isEmpty()) {
			entity = new ResponseEntity<Board>(HttpStatus.INTERNAL_SERVER_ERROR);  // 어차피 오류니까 값을 보낼 필요가 없지요
		} else {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);  // @GetMapping의 produces 대신 사용
			entity = new ResponseEntity<Board>(new Board(title, content), header, HttpStatus.OK);  // 응답할 값과 응답 헤더 정보를 함께 보냄
		}
		
		return entity;
		
	}

	@Override
	public ResponseEntity<Board> execute3(Board board) {
		
		ResponseEntity<Board> entity = null;
		
		if(board.getTitle().isEmpty()) {
			entity = new ResponseEntity<Board>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);  // @GetMapping의 produces 대신 사용
			entity = new ResponseEntity<Board>(board, header, HttpStatus.OK);
		}
		
		return entity;
		
	}

}
