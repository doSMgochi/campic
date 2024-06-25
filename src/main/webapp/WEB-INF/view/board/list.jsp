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
</head>
<body>
	<div>
		<c:forEach items="${boards }" var="one">
		<span style="color: #777; text-align: left;"></span> <span>${one.category}</span>
		<span style="color: #777; text-align: left;"></span> <span>${one.title}</span>
		<h3
			style="text-align: left; margin-bottom: 8px; border-bottom: 1px solid #ccc; padding: 8px;">${one.writerId }</h3>
		<div style="padding: 2px; text-align: right;">
			<span style="color: #777"></span> <span>${DateUtil.getDaysAgo(one.writedAt)}</span>
		</div>
		<p><a href="${pageContext.servletContext.contextPath }/board/view?no=${one.no}"></a></p>
			${Util.getFirstThreeLines(one.body)}
		<div>
			<span style="color: #777 text-align: left;">♡</span> <span>${one.favorite }</span>
		</div>
		</c:forEach>
	</div>
</body>
</html>