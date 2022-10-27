<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/board/list.do';
		});
		
	});
	
</script>
</head>
<body>

	<div>
		<table border="1">
			<thead>
				<tr>
					<td>작성자</td>
				</tr>
			</thead>	
				<tr>	
					<td>제목</td>
				</tr>	
				<tr>
					<td>내용</td>
				</tr>	
				<tr>
				  <td>
					<div>
						<input type="button" value="등록" id="btn_detail">
						<input type="button" value="목록" id="btn_list">
					</div>
				  </td>	
				</tr>
				
		</table>
	</div>
	
</body>
</html>


