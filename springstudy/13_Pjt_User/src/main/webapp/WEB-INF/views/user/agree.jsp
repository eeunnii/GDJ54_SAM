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
<script>
	
	$(function(){
		fn_checkAll();
		fn_checkOne();
	});
	
	// 모두 동의 (모두 동의의 체크 상태 = 개별 선택들의 체크 상태)
	function fn_checkAll(){
		$('#check_all').click(function(){
			// 체크 상태 변경
			$('.check_one').prop('checked', $(this).prop('checked'));			
		});
	}
	
	// 개별 선택 (항상 개별 선택 4개롤 모두 순회하면서 어떤 상태인지 체크해야 함)
	function fn_checkOne(){
		$('.check_one').click(function(){
			// 체크 상태 변경
			let checkCount = 0;
			for(let i = 0; i < $('.check_one').length; i++){
				checkCount += $($('.check_one')[i]).prop('checked');
			}
			// 체크박스개수 vs 체크된박스개수
			$('#check_all').prop('checked', $('.check_one').length == checkCount);
		});
	}
	
	
	
</script>
<style>
	.blind {
		display: none;
	}
	.lbl_all, .lbl_one {
		padding-left: 20px;
		background-image: url(${contextPath}/resources/images/uncheck.png);
		background-size: 18px 18px;
		background-repeat: no-repeat;
	}
</style>
</head>
<body>

	<div>
	
		<h1>약관 동의하기</h1>
		
		<form id="frm_agree" action="${contextPath}/user/join/write">
		
			<div>
				<input type="checkbox" id="check_all" class="blind">
				<label for="check_all" class="lbl_all">모두 동의</label>
			</div>
			
			<hr>
			
			<div>
				<input type="checkbox" id="serivce" class="check_one blind">
				<label for="serivce" class="lbl_one">이용약관 동의(필수)</label>
				<div>
					<textarea>본 약관은 ...</textarea>
				</div>
			</div>
			<div>
				<input type="checkbox" id="privacy" class="check_one blind">
				<label for="privacy" class="lbl_one">개인정보수집 동의(필수)</label>
				<div>
					<textarea>개인정보보호법에 따라 ...</textarea>
				</div>
			</div>
			<div>
				<input type="checkbox" id="location" class="check_one blind">
				<label for="location" class="lbl_one">위치정보수집 동의(선택)</label>
				<div>
					<textarea>위치정보 ...</textarea>
				</div>
			</div>
			<div>
				<input type="checkbox" id="promotion" class="check_one blind">
				<label for="promotion" class="lbl_one">마케팅 동의(선택)</label>
				<div>
					<textarea>이벤트 ...</textarea>
				</div>
			</div>
			
			<hr>
			
			<div>
				<input type="button" value="취소" onclick="history.back();">
				<button>다음</button>
			</div>
		
		</form>
		
	</div>

</body>
</html>