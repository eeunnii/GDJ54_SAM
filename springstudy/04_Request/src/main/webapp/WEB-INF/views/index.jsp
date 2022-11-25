<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>

	<!-- 이미지 표시 복습 -->
	<img src="${contextPath}/resources/images/hooray.jpg" width="200px">

	<hr>
	
	<h3>Member(MyController1에서 처리함)</h3>

	<div>
		<a href="${contextPath}/member/detail1?id=admin&pw=1234">전송1</a>
	</div>

	<div>
		<a href="${contextPath}/member/detail2?id=admin&pw=1234">전송2-1</a>
		<a href="${contextPath}/member/detail2?id=admin">전송2-2</a>
		<a href="${contextPath}/member/detail2?pw=1234">전송2-3</a>
		<a href="${contextPath}/member/detail2">전송2-4</a>
	</div>
	
	<div>
		<!-- location.href는 a.href하고 똑같이 동작함 -->
		<input type="button" value="전송3-1" onclick="location.href='${contextPath}/member/detail3?id=admin&pw=1234'">
		<input type="button" value="전송3-2" onclick="location.href='${contextPath}/member/detail3?id=admin'">
		<input type="button" value="전송3-3" onclick="location.href='${contextPath}/member/detail3?pw=1234'">
		<input type="button" value="전송3-4" onclick="location.href='${contextPath}/member/detail3'">
	</div>
	
	<div>
		<form action="${contextPath}/member/detail4" method="post">
			<div>
				<input type="text" name="id" placeholder="아이디">
			</div>
			<div>
				<input type="password" name="pw" placeholder="패스워드">
			</div>
			<button>전송4</button>
		</form>
	</div>
	
	<div>
		<form action="${contextPath}/member/detail5" method="post">
			<div>
				<input type="text" name="id" placeholder="아이디">
			</div>
			<div>
				<input type="password" name="pw" placeholder="패스워드">
			</div>
			<button>전송5</button>
		</form>
	</div>
	
	<hr>
	
	<h3>Board(MyController2에서 처리함)</h3>
	
	<div>
		<a href="${contextPath}/board/detail1?title=SPRING&hit=10">전송1</a>
	</div>
	<div>
		<a href="${contextPath}/board/detail2?title=SPRING&hit=10">전송2</a>
	</div>
	<div>
		<a href="${contextPath}/board/detail3?title=SPRING&hit=10">전송3</a>
	</div>
	<div>
		<a href="${contextPath}/board/detail4?title=SPRING&hit=10">전송4</a>
	</div>
	<div>
		<a href="${contextPath}/board/detail5?title=SPRING&hit=10">전송5</a>
	</div>
	
</body>
</html>