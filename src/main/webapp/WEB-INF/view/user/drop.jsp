<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴 | Campic</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/style.css" />
</head>
<body>
	<div class="main-container">
		<div class="center-text">
			<h2>회원탈퇴</h2>
			<div>
				회원서비스 &gt; <span class="highlight">회원탈퇴</span>
			</div>
		</div>
		<div class="withdrawal-box">
			<h3>유의사항</h3>
			<p>
				비밀번호가 일치하여야만 회원탈퇴가 진행됩니다.
			</p>
			<form action="${pageContext.servletContext.contextPath }/drop-handle">
				<p>
					<input type="password" name="password" placeholder="비밀번호를 입력해주세요"/>
				</p>
				<p>
					<button type="submit">회원탈퇴</button>
				</p>
			</form>
		</div>
	</div>
</body>
</html>