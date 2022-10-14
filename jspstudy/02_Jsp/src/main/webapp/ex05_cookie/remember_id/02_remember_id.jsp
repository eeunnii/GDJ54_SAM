<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 요청 파라미터
	request.setCharacterEncoding("UTF-8");

	// 아이디를 입력 안하면 빈 문자열("")
	String id = request.getParameter("id");
	
	// 체크박스를 체크 안하면 null
	String chkRememberId = request.getParameter("chk_remember_id");
	
	// 아이디 기억하기
	// 1. 아이디 기억하기를 체크했다면 아이디를 쿠키에 저장한다.(30일간 아이디 보관)
	// 2. 아이디 기억하기를 체크하지 않았다면 아이디를 쿠키에서 제거한다.
	
%>