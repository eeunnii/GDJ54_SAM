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

	<h1>예쁜 동물들 보고 가세요</h1>
	
	<!--
	
	    img 태그의 src 속성에 이미지의 절대 경로를 표시하면 이미지가 안 나옵니다. 아시죠?
	
		절대 경로의 이미지를 img 태그로 표시하기
		1. 요청
			경로 + 이미지를 파라미터로 전송
		2. 응답
			이미지의 byte[]을 받아서 표시
	-->
	<div id="galleries"></div>
	<script>
		// D:\\GDJ54\\images 디렉터리에 저장된 animal1~animal10까지 모두 표시하기
		for(let n = 1; n <= 10; n++) {
			$('<div>')
			.append($('<img>')
					.attr('src', '${contextPath}/image/display?path=' + encodeURIComponent('D:\\GDJ54\\images') + '&filename=animal' + n + '.jpg')
					.attr('width', '200px'))
			.appendTo('#galleries');
		}
	</script>

</body>
</html>