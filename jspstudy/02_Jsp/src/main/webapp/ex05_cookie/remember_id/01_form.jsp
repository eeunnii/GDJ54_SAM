<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../assets/js/jquery-3.6.1.min.js"></script>
</head>
<body>

	<div>
		<form method="POST" action="02_remember_id.jsp">
			<div>
				<input type="text" name="id" placeholder="아이디">
			</div>
			<div>
				<input type="password" name="pwd" placeholder="비밀번호">
			</div>
			<div>
				<button>로그인</button>
			</div>
			<div>
				<label for="chk_remember_id">
					<input type="checkbox" name="chk_remember_id" id="chk_remember_id">
					아이디 기억하기
				</label>
			</div>
		</form>
	</div>

</body>
</html>