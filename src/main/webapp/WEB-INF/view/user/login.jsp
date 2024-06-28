<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 | Campic</title>
<style>
.login-header {
	width: 100%;
	text-align: left;
	margin-bottom: 20px;
}

.login-header h2 {
	margin-bottom: 10px;
}

.highlight {
	color: hotpink;
}

.login-form-container {
	width: 100%;
	max-width: 400px;
	padding: 30px;
	border-radius: 8px;
	background-color: #ecf0f1;
	color: #2c3e50;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	box-sizing: border-box;
	overflow-x: hidden; /* 가로 스크롤 숨기기 */
}

.form-group {
	margin-bottom: 15px;
}

.form-group input {
	width: calc(100% - 20px); /* 내부 패딩에 대한 너비 조정 */
	padding: 10px;
	border: 1px solid #bdc3c7;
	border-radius: 4px;
	background-color: #ecf0f1;
	color: #2c3e50;
	box-sizing: border-box;
}

.btn-submit {
	width: 100%;
	padding: 10px;
	border: none;
	border-radius: 4px;
	background-color: #262441;
	color: #ecf0f1;
	font-size: 16px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.btn-submit:hover {
	background-color: #625779;
}

.signup-link {
	text-align: center;
	margin-top: 10px;
}

.signup-link a {
	color: #2c3e50;
	text-decoration: none;
	transition: color 0.3s ease;
}

.signup-link a:hover {
	color: #e74c3c;
}
</style>
</head>
<body>
	<%@ include file="../outer-nav.jsp"%>
	<div class="fixed-box">
		<div class="login-header"
			style="text-align: center; margin-top: 200px">
			<h2>로그인</h2>
			<div>
				회원서비스 &gt; <span style="color: #e0b10a">로그인</span>
			</div>
		</div>
		<div class="login-form-container" style="text-align: center ; margin-left: 40px">
			<form
				action="${pageContext.servletContext.contextPath }/login-handle"
				method="post">
				<div class="form-group">
					<input type="text" name="id" placeholder="아이디를 입력해주세요"
						class="form-control" />
				</div>
				<div class="form-group">
					<input type="password" name="password" placeholder="비밀번호를 입력해주세요"
						class="form-control" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn-submit">로그인</button>
				</div>
			</form>
			<p class="signup-link">
				<a href="${pageContext.servletContext.contextPath }/signup">신규회원가입
					바로가기</a>
			</p>
		</div>
		<div class="fixed-footer">
			<%@ include file="../inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>