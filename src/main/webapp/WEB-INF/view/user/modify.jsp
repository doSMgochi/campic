<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정 | Campic</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/style.css" />
</head>
<body>
	<%@ include file="../outer-nav.jsp"%>
	<div class="fixed-box">
		<form
			action="${pageContext.servletContext.contextPath }/modify-handle"
			method="post" class="form-container">
			<div class="form-group">
				<label>아이디<span></span></label>
				<div>${authUser.id }</div>
			</div>
			<div class="form-group">
				<label>비밀번호<span>(*)</span></label>
				<div>
					<input type="password" name="password" />
				</div>
			</div>
			<div class="form-group">
				<label>닉네임<span>(*)</span></label>
				<div>
					<input type="text" name="nickname" value="${authUser.nickname }" />
				</div>
			</div>
			<div class="form-group">
				<label>성별</label>
				<div>${authUser.gender }</div>
			</div>
			<div class="form-group">
				<label>이메일<span></span></label>
				<div>${authUser.email }</div>
			</div>
			<div class="form-group">
				<label>생년월일<span></span></label>
				<div>${authUser.birth}</div>
			</div>
			<div class="form-group center-text margin-top-20">
				<button type="submit" class="btn-submit">저장</button>
				<a href="${pageContext.servletContext.contextPath }/drop"><button
						type="button" class="btn-secondary">회원탈퇴</button></a>
			</div>
		</form>
		<div class="fixed-footer">
			<%@ include file="../inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>