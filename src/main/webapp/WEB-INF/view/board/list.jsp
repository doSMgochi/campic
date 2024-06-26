<%@page import="oracle.jdbc.proxy.annotation.OnError"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="util.Util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트 | Campic</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/style.css?<%=System.currentTimeMillis() %>" />
</head>
<body>
	<div class="board">
		<div class="board-cates">
			<a href="${pageContext.servletContext.contextPath }/board?home" class="${category =='홈'? 'active' : '' }">
				홈 </a> <a
				href="${pageContext.servletContext.contextPath }/board?campingLog" class="${category =='캠핑로그'? 'active' : '' }">
				캠핑로그 </a> <a
				href="${pageContext.servletContext.contextPath }/board?campingPhoto" class="${category =='캠핑한컷'? 'active' : '' }">
				캠핑한컷 </a> <a
				href="${pageContext.servletContext.contextPath }/board?campingTalk" class="${category =='캠핑톡톡'? 'active' : '' }">
				캠핑톡톡 </a> <a
				href="${pageContext.servletContext.contextPath }/board?questions" class="${category =='궁금해요'? 'active' : '' }">
				궁금해요 </a> <a
				href="${pageContext.servletContext.contextPath }/board?articles" class="${category =='아티클'? 'active' : '' }">
				아티클 </a>
		</div>


		<c:choose>
			<c:when test="${category == '홈'}">
				<h2>홈</h2>
				<p>홈 카테고리의 내용을 표시합니다.</p>
			</c:when>

			<c:when test="${category == '캠핑로그'}">
				<h2>로그</h2>
			</c:when>

			<c:when test="${category == '캠핑한컷'}">
				<c:forEach items="${boards }" var="one">
					<span style="color: #777; text-align: left;"></span>
					<span>${one.category}</span>
					<span style="color: #777; text-align: left;"></span>
					<span>${one.title}</span>
					<h3
						style="text-align: left; margin-bottom: 8px; border-bottom: 1px solid #ccc; padding: 8px;">${one.writerId }</h3>

					<div style="padding: 2px; text-align: right;">
						<span style="color: #777"></span> <span>${Util.getDaysAgo(one.writedAt)}</span>
					</div>
					<p>
						<a
							href="${pageContext.servletContext.contextPath }/board/view?no=${one.no}">
							${Util.getFirstThreeLines(one.body)}</a>
					</p>
					<div>
						<span style="color: #777 text-align: left;">♡</span> <span>${one.favorite }</span>
					</div>
				</c:forEach>
			</c:when>

			<c:when test="${category == '캠핑톡톡'}">
				<c:forEach items="${boards }" var="one">
					<span style="color: #777; text-align: left;"></span>
					<span>${one.category}</span>
					<span style="color: #777; text-align: left;"></span>
					<span>${one.title}</span>
					<h3
						style="text-align: left; margin-bottom: 8px; border-bottom: 1px solid #ccc; padding: 8px;">${one.writerId }</h3>

					<div style="padding: 2px; text-align: right;">
						<span style="color: #777"></span> <span>${Util.getDaysAgo(one.writedAt)}</span>
					</div>
					<p>
						<a
							href="${pageContext.servletContext.contextPath }/board/view?no=${one.no}">
							${Util.getFirstThreeLines(one.body)}</a>
					</p>
					<div>
						<span style="color: #777 text-align: left;">♡</span> <span>${one.favorite }</span>
					</div>
				</c:forEach>
			</c:when>

			<c:when test="${category == '궁금해요'}">
				<c:forEach items="${boards }" var="one">
					<span style="color: #777; text-align: left;"></span>
					<span>${one.category}</span>
					<span style="color: #777; text-align: left;"></span>
					<span>${one.title}</span>
					<h3
						style="text-align: left; margin-bottom: 8px; border-bottom: 1px solid #ccc; padding: 8px;">${one.writerId }</h3>

					<div style="padding: 2px; text-align: right;">
						<span style="color: #777"></span> <span>${Util.getDaysAgo(one.writedAt)}</span>
					</div>
					<p>
						<a
							href="${pageContext.servletContext.contextPath }/board/view?no=${one.no}">
							${Util.getFirstThreeLines(one.body)}</a>
					</p>
					<div>
						<span style="color: #777 text-align: left;">♡</span> <span>${one.favorite }</span>
					</div>
				</c:forEach>
			</c:when>

			<c:when test="${category == '아티클'}">
				<c:forEach items="${boards }" var="one">
					<span style="color: #777; text-align: left;"></span>
					<span>${one.category}</span>
					<span style="color: #777; text-align: left;"></span>
					<span>${one.title}</span>
					<h3
						style="text-align: left; margin-bottom: 8px; border-bottom: 1px solid #ccc; padding: 8px;">${one.writerId }</h3>

					<div style="padding: 2px; text-align: right;">
						<span style="color: #777"></span> <span>${Util.getDaysAgo(one.writedAt)}</span>
					</div>
					<p>
						<a
							href="${pageContext.servletContext.contextPath }/board/view?no=${one.no}">
							${Util.getFirstThreeLines(one.body)}</a>
					</p>
					<div>
						<span style="color: #777 text-align: left;">♡</span> <span>${one.favorite }</span>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h2>알 수 없는 카테고리</h2>
				<p>유효하지 않은 카테고리입니다.</p>
			</c:otherwise>
		</c:choose>




		<!-- 페이지 링크 -->
		<div style="text-align: center; margin-top: 30px;">

			<c:forEach begin="1" end="${totalPages }" var="i">
				<c:choose>
					<c:when test="${i == currentPage }">
						<b style="color: red">${i }</b>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.servletContext.contextPath }/boards?p=${i}">${i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</div>
</body>
</html>