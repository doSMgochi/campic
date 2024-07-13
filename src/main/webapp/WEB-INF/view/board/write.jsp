<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/style.css" />
</head>
<body>
	<%@ include file="../outer-nav.jsp"%>
	<div class="fixed-box">
		<div class="form-container">
			<p class="center-text">글쓰기</p>
			<form action="${pageContext.servletContext.contextPath }/board/write-handle">
				<table class="styled-table">
					<tr>
						<td class="table-header"><span class="red-text">*</span>주제선택</td>
						<td><select name="category">
								<option disabled selected>주제선택</option>
								<option>캠핑한컷</option>
								<option>캠핑톡톡</option>
								<option>궁금해요</option>
						</select></td>
					</tr>
					<tr>
						<td class="table-header"><span class="red-text">*</span>작성자</td>
						<td>${authUser.id}</td>
					</tr>
					<tr>
						<td class="table-header"><span class="red-text">*</span>제목</td>
						<td><input name="title" type="text" class="input-text" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea name="body" class="textarea"></textarea>
						</td>
					</tr>
				</table>
				<div class="center-text margin-top-20">
					<button type="submit" class="button-a padding-10-20">저장</button>
					<button type="reset" class="button-a padding-10-20">취소</button>
				</div>
			</form>
		</div>
	</div>
	<div class="fixed-footer">
		<%@ include file="../inner-nav.jsp"%>
	</div>
</body>
</html>