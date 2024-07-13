<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다함께 캠핑가자, 캠픽</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/style.css" />
</head>
<body>
	<%@ include file="../outer-nav.jsp"%>
	<div class="fixed-box no-scroll">
		<c:forEach items="${campsites }" var="one">
			<img src="${one.imageUrl }" class="campsite-img">
			<br />
			${one.address }<br />
			<c:if test="${one.gnrlSite > 0 }">
				일반야영장
			</c:if>
			<c:if test="${one.autoSite > 0 }">
				오토캠핑
			</c:if>
			<c:if test="${one.glampSite > 0 }">
				글램핑
			</c:if>
			<c:if test="${one.caravSite > 0 }">
				카라반
			</c:if>
			<br />
			<div class="flex-between align-center">
				<span>${one.name}</span><span>가격</span>
			</div>
			<br />
			조인한 캠핑로그 카운트*
			<br />
			환경 ${one.environment }
			<br />
			태그 ...
			<br />
		</c:forEach>
		<div class="fixed-footer">
			<%@ include file="../inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>