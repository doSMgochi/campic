<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다함께 캠핑가자, 캠픽</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/style.css" />
</head>
<body>
	<%@ include file="../outer-nav.jsp"%>
	<div class="fixed-box">
		<div class="flex-between align-center">
			<div>
				<button type="button" class="button-a" onclick="history.back();"><i class="fa-solid fa-angle-left"></i></button>
			</div>
			<div>알림</div>
			<div></div>
		</div>
		<div class="center-text">
			<div>if문 처리하고 알림 출력</div>
			<div>없으면 아래 내용 출력</div>
			알림이 없습니다.
		</div>
		<div class="fixed-footer">
			<%@ include file="../inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>