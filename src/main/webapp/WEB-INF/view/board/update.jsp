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
			<form action="${pageContext.servletContext.contextPath }/board/update-handle">
				<input type="hidden" name="no" value="${board.no }" />
				<table class="styled-table">
					<tr>
						<td class="table-header"><span class="red-text">*</span>주제선택</td>
						<td>${board.category }</td>
					</tr>
					<!-- 궁금해요 category 분야 선택 있어야 함 -->
					<tr>
						<td class="table-header"><span class="red-text">*</span>작성자</td>
						<td>${board.writerId}</td>
					</tr>
					<tr>
						<td class="table-header"><span class="red-text">*</span>제목</td>
						<td><input name="title" type="text" value="${board.title }" class="input-text" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea name="body" class="textarea">${board.body }</textarea>
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