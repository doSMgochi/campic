<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다함께 캠핑가자, 캠픽</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/style.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<%@ include file="./outer-nav.jsp"%>
	<div class="fixed-box">
		<div class="content-box">
			<div class="flex-between align-center">
				<div>
					<button type="button" class="button-a" onclick="history.back();">
						<i class="fa-solid fa-angle-left"></i>
					</button>
				</div>
				<div>설정</div>
				<div></div>
			</div>
			<div class="margin-top-20">
				<div class="full-width flex-between">
					<div><a href="${pageContext.servletContext.contextPath }/modify">내 정보 관리</a></div>
					<div>
						<i class="fa-solid fa-angle-right"></i>
					</div>
				</div>
				<div class="full-width flex-between">
					<div>게시글 미노출 유저 관리</div>
					<div>
						<i class="fa-solid fa-angle-right"></i>
					</div>
				</div>
				<div class="full-width flex-between">
					<div>서비스 이용약관</div>
					<div>
						<i class="fa-solid fa-angle-right"></i>
					</div>
				</div>
				<div class="full-width flex-between">
					<div>개인정보 처리방침</div>
					<div>
						<i class="fa-solid fa-angle-right"></i>
					</div>
				</div>
				<div class="full-width flex-between">
					<div><a href="${pageContext.servletContext.contextPath }/drop">회원탈퇴</a></div>
					<div>
						<i class="fa-solid fa-angle-right"></i>
					</div>
				</div>
				<div class="full-width flex-between">
					<div><a href="${pageContext.servletContext.contextPath }/logout">로그아웃</a></div>
					<div>
						<i class="fa-solid fa-angle-right"></i>
					</div>
				</div>
			</div>
		</div>
		<div class="fixed-footer">
			<%@ include file="./inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>