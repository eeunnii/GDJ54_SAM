<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		box-sizing: border-box;
	}
	a {
		text-decoration: none;
		color: gray;
	}
	.paging {
		width: 210px;
		margin: 0 auto;
		color: gray;
	}
	.paging a, .paging span {
		display: inline-block;
		width: 30px;
		height: 30px;
		line-height: 30px;
		text-align: center;
	}
	.hidden {
		visibility: hidden;
	}
	.now_page {
		border: 1px solid gray;
		color: teal;
		font-weight: 900;
	}
	.lnk:hover {
		border: 1px solid gray;
		color: skyblue;
	}
</style>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>

	$(document).ready(function(){
		
		// area1, area2 표시
		// 초기 상태 : area1, area2 둘 다 숨김
		$('#area1, #area2').hide();
		// column 선택에 따른 area1, area2 표시
		$('#column').change(function(){
			let combo = $(this);
			if(combo.val() == ''){
				$('#area1, #area2').hide();
			} else if(combo.val() == 'HIRE_DATE' || combo.val() == 'SALARY'){
				$('#area1').hide();
				$('#area2').show();
			} else {
				$('#area1').show();
				$('#area2').hide();
			}
		});
	
		// 자동 완성
		$('#param').keyup(function(){
			$('#auto_complete').empty();
			if($(this).val() == ''){
				return;
			}
			$.ajax({
				/* 요청 */
				type: 'get',
				url: '${contextPath}/emp/autoComplete',
				data: 'target=' + $('#target').val() + '&param=' + $(this).val(),
				/* 응답 */
				dataType: 'json',
				success: function(resData){
					if(resData.status == 200){
						$.each(resData.list, function(i, emp){
							$('#auto_complete')
							.append($('<option>').val(emp[resData.target]));
						});
					}
				}
			});
		});
		
		// 필드 제목으로 정렬
		$('.field').click(function(){
			location.href = '${contextPath}/emp/list?field=' + $(this).data('field') + '&order=' + $(this).data('order');				
		});
		
	});
	
</script>
</head>
<body>

	<div>
		<h1>검색조건주고 검색하기</h1>
		<form id="frm_search" action="${contextPath}/emp/search">
			<select id="column" name="column">
				<option value="">:::선택:::</option>
				<option value="EMPLOYEE_ID">사원번호</option>
				<option value="DEPARTMENT_ID">부서번호</option>				
				<option value="LAST_NAME">성</option>
				<option value="FIRST_NAME">이름</option>
				<option value="PHONE_NUMBER">연락처</option>
				<option value="HIRE_DATE">입사일</option>
				<option value="SALARY">연봉</option>
			</select>
			<span id="area1">
				<input type="text" id="query" name="query">
			</span>
			<span id="area2">
				<input type="text" id="start" name="start">
				~
				<input type="text" id="stop" name="stop">
			</span>
			<span>
				<input type="submit" value="검색">
				<input type="button" value="전체사원조회" onclick="location.href='${contextPath}/emp/list'">
			</span>
		</form>
	</div>
	
	<div>
		<h1>조회 가능한 목록을 자동완성으로 확인하기</h1>
		<select id="target">
			<option value="FIRST_NAME">이름</option>
			<option value="LAST_NAME">성</option>
			<option value="EMAIL">이메일</option>
		</select>
		<input type="text" id="param" list="auto_complete">
		<datalist id="auto_complete"></datalist>
	</div>
	
	<div>
		<h1>페이지에 표시할 목록의 개수 변경하기</h1>
		<select id="recordPerPage">
			<option value="10">10개</option>
			<option value="20">20개</option>
			<option value="30">30개</option>
		</select>
	</div>
	
	<hr>

	<div>
		<table>
			<thead>
				<tr>
					<td>순번</td>
					<td><span class="field" data-field="EMPLOYEE_ID" data-order="${order}">사원번호</span></td>
					<td><span class="field" data-field="FIRST_NAME" data-order="${order}">사원명</span></td>
					<td><span class="field" data-field="EMAIL" data-order="${order}">이메일</span></td>
					<td><span class="field" data-field="PHONE_NUMBER" data-order="${order}">전화번호</span></td>
					<td><span class="field" data-field="HIRE_DATE" data-order="${order}">입사일자</span></td>
					<td><span class="field" data-field="SALARY" data-order="${order}">연봉</span></td>
					<td><span class="field" data-field="COMMISSION_PCT" data-order="${order}">커미션</span></td>
					<td><span class="field" data-field="DEPARTMENT_ID" data-order="${order}">부서번호</span></td>
					<td><span class="field" data-field="DEPARTMENT_NAME" data-order="${order}">부서명</span></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="emp" varStatus="vs">
					<tr>
						<td>${beginNo - vs.index}</td>
						<td>${emp.employeeId}</td>
						<td>${emp.firstName} ${emp.lastName}</td>
						<td>${emp.email}</td>
						<td>${emp.phoneNumber}</td>
						<td>${emp.hireDate}</td>
						<td>${emp.salary}</td>
						<td>${emp.commissionPct}</td>
						<td>${emp.deptDTO.departmentId}</td>
						<td>${emp.deptDTO.departmentName}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="10">
					    ${paging}
					</td>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>