<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="util.Util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 자세히 보기 | Campic</title>
</head>
<body>
	<div class="fixed-box">
		<div class="content-box">
			<div>
				<h2
					style="text-align: center; margin-bottom: 8px; border-bottom: 1px solid #ccc; padding: 8px;">${found.category }</h2>
				<span style="color: #777; text-align: left;"></span> <span>${found.category}</span>
				<span style="color: #777; text-align: left;"></span> <span>${found.title}</span>
				<h3
					style="text-align: left; margin-bottom: 8px; border-bottom: 1px solid #ccc; padding: 8px;">${found.writerId }</h3>
				<div style="padding: 2px; text-align: right;">
					<span style="color: #777"></span> <span>${Util.getDaysAgo(found.writedAt)}</span>
				</div>
				<p>${found.body}</p>
				<div>
					<span style="color: #777 text-align: left;">♡</span> <span>${found.favorite }</span>
				</div>

			</div>
			<a href="${pageContext.servletContext.contextPath }/board/list"><button>목록</button></a>
			<c:if test="${r == true}">
				<a
					href="${pageContext.request.contextPath}/board/delete?no=${found.no}">
					<button>삭제</button>
				</a>
				<a
					href="${pageContext.request.contextPath}/board/update?no=${found.no}">
					<button>수정</button>
				</a>
			</c:if>
		</div>
	</div>
	<div class="fixed-footer">
		<%@ include file="../inner-nav.jsp"%>
	</div>
</body>
</html>