<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 | Campic</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/style.css" />
</head>
<body>
	<%@ include file="../outer-nav.jsp"%>
	<div class="fixed-box padding-top-20">
		<form action="${pageContext.servletContext.contextPath }/signup-handle" method="post" class="margin-left-15">
			<div class="form-group margin-top-60">
				<label>아이디<span>(*)</span></label>
				<div>
					<input type="text" placeholder="아이디.." name="id" />
				</div>
			</div>
			<div class="form-group">
				<label>비밀번호<span>(*)</span></label>
				<div>
					<input type="password" placeholder="비밀번호.." name="password" />
				</div>
			</div>
			<div class="form-group">
				<label>닉네임<span>(*)</span></label>
				<div>
					<input type="text" placeholder="닉네임.." name="nickname" />
				</div>
			</div>
			<div class="form-group">
				<label>성별(*)</label>
				<div>
					<select name="gender" class="form-control">
						<option disabled selected>성별..</option>
						<option>남</option>
						<option>여</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label>이메일<span>(*)</span></label>
				<div>
					<input type="text" placeholder="이메일.." name="email" />
				</div>
			</div>
			<div class="form-group">
				<label>생년월일(*)<span></span></label>
				<div>
					<select name="birth" class="form-control">
						<option disabled selected>탄생년도</option>
						<c:forEach var="i" begin="0" end="80">
							<option>${2024-i }</option>
						</c:forEach>
					</select>
					<select name="birth" class="form-control">
						<option disabled selected>월</option>
						<c:forEach var="i" begin="1" end="12">
							<option>${i}</option>
						</c:forEach>
					</select>
					<select name="birth" class="form-control">
						<option disabled selected>일</option>
						<c:forEach var="i" begin="1" end="31">
							<option>${i}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="center-text">
				<button type="submit" class="btn-submit margin-top-15">회원가입신청</button>
			</div>
		</form>
		<div class="fixed-footer new-fixed-footer">
			<%@ include file="../inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>