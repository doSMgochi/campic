<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 | Campic</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/style.css" />
</head>
<body>
	<%@ include file="../outer-nav.jsp"%>
	<div class="fixed-box">
		<div class="login-header margin-top-200">
			<h2>로그인</h2>
			<div>
				회원서비스 &gt; <span class="highlight">로그인</span>
			</div>
		</div>
		<div class="login-form-container center-text margin-left-40">
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