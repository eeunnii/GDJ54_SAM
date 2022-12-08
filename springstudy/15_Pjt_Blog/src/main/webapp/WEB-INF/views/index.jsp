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

	<c:if test="${loginUser == null}">
		<form action="${contextPath}/user/login" method="post">
			<input type="text" name="id" placeholder="ID"><br>
			<input type="password" name="pw" placeholder="Password"><br>
			<button>로그인</button>
		</form>
	</c:if>
	
	<c:if test="${loginUser != null}">
		${loginUser.name} 님 반갑습니다
		<input type="button" value="로그아웃" onclick="location.href='${contextPath}/user/logout'">
	</c:if>

	<hr>

	<a href="${contextPath}/blog/list">블로그</a>

</body>
</html>