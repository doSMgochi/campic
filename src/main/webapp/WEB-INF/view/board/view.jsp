<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="util.Util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 자세히 보기 | Campic</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/style.css" />
</head>
<body>
	<%@ include file="../outer-nav.jsp"%>
	<div class="fixed-box">
		<div class="board no-scroll" style="overflow-y: scroll; max-height: 80vh;">
			<div class="board-cates">
				<div>
					<h2 class="center-text margin-bottom-8 border-bottom padding-8">${found.category }</h2>
					<span class="gray-text">${found.category}</span>
					<span class="gray-text">${found.title}</span>
					<h3 class="left-text margin-bottom-8 border-bottom padding-8">${found.writerId }</h3>
					<div class="padding-2 right-text">
						<span class="gray-text">${Util.getDaysAgo(found.writedAt)}</span>
					</div>
					<p>${found.body}</p>
					<div>
						<span class="gray-text">♡</span> <span>${found.favorite }</span>
					</div>
				</div>
				<a href="${pageContext.servletContext.contextPath }/board"><button class="button-a">목록</button></a>
				<c:if test="${r == true}">
					<a href="${pageContext.request.contextPath}/board/delete?no=${found.no}">
						<button class="button-a">삭제</button>
					</a>
					<a href="${pageContext.request.contextPath}/board/update?no=${found.no}">
						<button class="button-a">수정</button>
					</a>
				</c:if>
				<!-- 답글 리스트 표시 -->
				<div>
					<h3>답글</h3>
					<c:forEach var="reply" items="${replies}">
						<div>
							<p>
								<strong>${reply.writerId}</strong> (${reply.writedAt}):
								${reply.body}
							</p>
						</div>
					</c:forEach>
				</div>
				<!-- 답글 추가 폼 -->
				<div>
					<h3>답글 달기</h3>
					<form action="${pageContext.request.contextPath}/board/reply" method="post">
						<input type="hidden" name="boardId" value="${found.no}">
						<textarea name="body" rows="4" cols="50" class="textarea"></textarea>
						<br>
						<button type="submit" class="button-a">답글 추가</button>
					</form>
				</div>
			</div>
			<a href="${pageContext.servletContext.contextPath }/board/list"><button class="button-a">목록</button></a>
			<c:if test="${r == true}">
				<a href="${pageContext.request.contextPath}/board/delete?no=${found.no}">
					<button class="button-a">삭제</button>
				</a>
				<a href="${pageContext.request.contextPath}/board/update?no=${found.no}">
					<button class="button-a">수정</button>
				</a>
			</c:if>
		</div>
		<div class="fixed-footer">
			<%@ include file="../inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>