<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<link rel="stylesheet" href="/resources/summernote-0.8.18-dist/summernote-lite.min.css">
<script src="/resources/summernote-0.8.18-dist/summernote-lite.min.js"></script>
<script src="/resources/summernote-0.8.18-dist/lang/summernote-ko-KR.min.js"></script>
<script>
	
	$(document).ready(function(){
		
		// summernote
		$('#content').summernote({
			width: 800,
			height: 400,
			lang: 'ko-KR',
			toolbar: [
			    // [groupName, [list of button]]
			    ['style', ['bold', 'italic', 'underline', 'clear']],
			    ['font', ['strikethrough', 'superscript', 'subscript']],
			    ['fontsize', ['fontsize']],
			    ['color', ['color']],
			    ['para', ['ul', 'ol', 'paragraph']],
			    ['height', ['height']]
			]
		});
		
		// 목록
		$('#btn_list').click(function(){
			location.href = '/brd/list';
		});
		
		// 서브밋
		$('#frm_board').submit(function(event){
			if($('#title').val() == '' || $('#writer').val() == ''){
				alert('제목과 작성자는 필수입니다.');
				event.preventDefault();  // 서브밋 취소
				return;  // 더 이상 코드 실행할 필요 없음
			}
		});
		
	});
	
</script>
</head>
<body>

	<div>
		<h1>작성 화면</h1>
		<form id="frm_board" action="/brd/add" method="post">
			<div>
				<label for="title">제목</label>
				<input type="text" name="title" id="title">
			</div>
			<div>
				<label for="writer">작성자</label>
				<input type="text" name="writer" id="writer">
			</div>
			<div>
				<label for="content">내용</label>
				<textarea name="content" id="content"></textarea>				
			</div>
			<div>
				<button>작성완료</button>
				<input type="reset" value="입력초기화">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>

</body>
</html>