<%@ page import="oracle.jdbc.proxy.annotation.OnError"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="util.Util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트 | Campic</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/style.css?<%=System.currentTimeMillis() %>" />
</head>
<body>
	<%@ include file="../outer-nav.jsp"%>
	<div class="fixed-box">
		<div class="board no-scroll" style="overflow-y: scroll; max-height: 83vh;">
			<div class="board-cates">
				<a href="${pageContext.servletContext.contextPath }/board?home" class="${category == '홈' ? 'active' : '' }"> 홈 </a>
				<a href="${pageContext.servletContext.contextPath }/board?campingLog" class="${category == '캠핑로그' ? 'active' : '' }"> 캠핑로그 </a>
				<a href="${pageContext.servletContext.contextPath }/board?campingPhoto" class="${category == '캠핑한컷' ? 'active' : '' }"> 캠핑한컷 </a>
				<a href="${pageContext.servletContext.contextPath }/board?campingTalk" class="${category == '캠핑톡톡' ? 'active' : '' }"> 캠핑톡톡 </a>
				<a href="${pageContext.servletContext.contextPath }/board?questions" class="${category == '궁금해요' ? 'active' : '' }"> 궁금해요 </a>
				<a href="${pageContext.servletContext.contextPath }/board?articles" class="${category == '아티클' ? 'active' : '' }"> 아티클 </a>
			</div>
			<c:choose>
				<c:when test="${category == '홈'}">
					<c:forEach var="cat" items="${categories}">
						<h3>${cat}</h3>
						<c:forEach var="one" items="${topPostsByCategory[cat]}">
							<div class="post">
								<span>${one.category}</span> <span>${one.title}</span>
								<h3>${one.writerId}</h3>
								<div>
									<span>${Util.getDaysAgo(one.writedAt)}</span>
								</div>
								<p>
									<a href="${pageContext.servletContext.contextPath }/board/view?no=${one.no}">${Util.getFirstThreeLines(one.body)}</a>
								</p>
								<div>
									<span>♡</span> <span>${one.favorite}</span>
								</div>
							</div>
						</c:forEach>
					</c:forEach>
					<div>
						<a href="${pageContext.servletContext.contextPath }/board/write"><button class="button-a">글쓰기</button></a>
					</div>
				</c:when>
				<c:when test="${category == '캠핑로그'}">
					<h2>로그</h2>
				</c:when>
				<c:when test="${category == '캠핑한컷'}">
					<c:forEach items="${boards }" var="one">
						<div class="post">
							<span>${one.category}</span> <span>${one.title}</span>
							<h3 class="left-text margin-bottom-8 border-bottom padding-8">${one.writerId}</h3>
							<div class="padding-2 right-text">
								<span class="gray-text">${Util.getDaysAgo(one.writedAt)}</span>
							</div>
							<p>
								<a href="${pageContext.servletContext.contextPath }/board/view?no=${one.no}">${Util.getFirstThreeLines(one.body)}</a>
							</p>
							<div>
								<span class="gray-text">♡</span> <span>${one.favorite}</span>
							</div>
						</div>
					</c:forEach>
					<div>
						<a href="${pageContext.servletContext.contextPath }/board/write"><button class="button-a">글쓰기</button></a>
					</div>
				</c:when>
				<c:when test="${category == '캠핑톡톡'}">
					<c:forEach items="${boards }" var="one">
						<div class="post">
							<span>${one.category}</span> <span>${one.title}</span>
							<h3 class="left-text margin-bottom-8 border-bottom padding-8">${one.writerId}</h3>
							<div class="padding-2 right-text">
								<span class="gray-text">${Util.getDaysAgo(one.writedAt)}</span>
							</div>
							<p>
								<a href="${pageContext.servletContext.contextPath }/board/view?no=${one.no}">${Util.getFirstThreeLines(one.body)}</a>
							</p>
							<div>
								<span class="gray-text">♡</span> <span>${one.favorite}</span>
							</div>
						</div>
					</c:forEach>
					<div>
						<a href="${pageContext.servletContext.contextPath }/board/write"><button class="button-a">글쓰기</button></a>
					</div>
				</c:when>
				<c:when test="${category == '궁금해요'}">
					<c:forEach items="${boards }" var="one">
						<div class="post">
							<span>${one.category}</span> <span>${one.title}</span>
							<h3 class="left-text margin-bottom-8 border-bottom padding-8">${one.writerId}</h3>
							<div class="padding-2 right-text">
								<span class="gray-text">${Util.getDaysAgo(one.writedAt)}</span>
							</div>
							<p>
								<a href="${pageContext.servletContext.contextPath }/board/view?no=${one.no}">${Util.getFirstThreeLines(one.body)}</a>
							</p>
							<div>
								<span class="gray-text">♡</span> <span>${one.favorite}</span>
							</div>
						</div>
					</c:forEach>
					<div>
						<a href="${pageContext.servletContext.contextPath }/board/write"><button class="button-a">글쓰기</button></a>
					</div>
				</c:when>
				<c:when test="${category == '아티클'}">
					<c:forEach items="${boards }" var="one">
						<div class="post">
							<span>${one.category}</span> <span>${one.title}</span>
							<h3 class="left-text margin-bottom-8 border-bottom padding-8">${one.writerId}</h3>
							<div class="padding-2 right-text">
								<span class="gray-text">${Util.getDaysAgo(one.writedAt)}</span>
							</div>
							<p>
								<a href="${pageContext.servletContext.contextPath }/board/view?no=${one.no}">${Util.getFirstThreeLines(one.body)}</a>
							</p>
							<div>
								<span class="gray-text">♡</span> <span>${one.favorite}</span>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h2>알 수 없는 카테고리</h2>
					<p>유효하지 않은 카테고리입니다.</p>
				</c:otherwise>
			</c:choose>
			<!-- 페이지 링크 -->
			<div class="center-text margin-top-30">
				<c:forEach begin="1" end="${totalPages }" var="i">
					<c:choose>
						<c:when test="${i == currentPage }">
							<b class="red-text">${i }</b>
						</c:when>
						<c:otherwise>
							<a href="${pageContext.servletContext.contextPath }/boards?p=${i}">${i }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</div>
		<div class="fixed-footer">
			<%@ include file="../inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>