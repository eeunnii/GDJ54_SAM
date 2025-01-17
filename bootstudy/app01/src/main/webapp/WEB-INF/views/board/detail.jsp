<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<script>
	
	$(document).ready(function(){
		
		var frm = $('#frm_btn');
		
		// 편집화면으로 이동
		$('#btn_edit').click(function(){
			frm.attr('action', '/brd/edit');
			frm.submit();
		})
		
		// 삭제
		$('#btn_remove').click(function(){
			if(confirm('삭제할까요?')){
				frm.attr('action', '/brd/remove');
				frm.submit();
				return;
			}
		});
		
		// 목록
		$('#btn_list').click(function(){
			location.href = '/brd/list';
		});
		
	});
	
</script>
</head>
<body>

	<ul>
		<li>글번호 : ${board.boardNo}</li>
		<li>제목 : ${board.title}</li>
		<li>작성자 : ${board.writer}</li>
		<li>작성일 : ${board.createDate}</li>
		<li>수정일 : ${board.modifyDate}</li>
	</ul>
	<div>
		${board.content}
	</div>

	<hr>
	
	<div>
		<form id="frm_btn" method="post">
			<input type="hidden" name="boardNo" value="${board.boardNo}">
			<input type="button" value="편집" id="btn_edit">
			<input type="button" value="삭제" id="btn_remove">
			<input type="button" value="목록" id="btn_list">
		</form>
	</div>

</body>
</html>