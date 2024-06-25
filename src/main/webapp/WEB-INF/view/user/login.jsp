<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 | Campic</title>
</head>
<body>
	<div style="width: 840px; margin: 0 auto;">
		<div style="text-align: center">
			<h2>로그인</h2>
			<div>
				회원서비스 &gt; <span style="color : hotpink;">로그인</span>
			</div>
		</div>
		<div style="width: 400px; margin: 60px auto; border:2px solid #ddd; padding:30px;">
			<form action="${pageContext.servletContext.contextPath }/user/login-handle">
				<p>
					<input type="text" name="id" placeholder="아이디를 입력해주세요" />
				</p>
				<p>
					<input type="password" name="pwd" placeholder="비밀번호를 입력해주세요"/>
				</p>
				<p>
					<button type="submit">로그인</button>
				</p>
			</form>
			<p style="text-align:center">
				<a href="${pageContext.servletContext.contextPath }/user/signup">신규회원가입 바로가기</a>
			</p>
		
		
		</div>
	</div>
</body>
</html>