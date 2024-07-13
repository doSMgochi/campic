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
	<div class="fixed-box">
		<div class="flex-between align-center">
			<div>
				<button type="button" class="button-a" onclick="history.back();">
					<i class="fa-solid fa-angle-left"></i>
				</button>
			</div>
			<div>미리 떠나는 휴가(파라미터로 받은 카테고리명 조회)</div>
			<div></div>
		</div>
		<div class="no-scroll margin-top-30" style="text-align: left; overflow-y: scroll; max-height: 78vh;">
			<img src="../ad.jpg" class="ad-img-large margin-bottom-30" />
			<c:choose>
				<c:when test="${vacances != null }">
					<div class="flex-container">
						<c:forEach items="${vacances }" var="one">
							<div class="flex-item">
								<a href="${pageContext.servletContext.contextPath }/camp/${one.id }" class="no-deco">
									<img src="${one.imageUrl }" onerror="this.src='../campimg.png'" class="camp-img">
									<div>
										<div class="gray-text small-text">
											<c:if test="${one.gnrlSite > 0 }">일반야영장</c:if>
											<c:if test="${one.autoSite > 0 }">오토캠핑</c:if>
											<c:if test="${one.glampSite > 0 }">글램핑</c:if>
											<c:if test="${one.caravSite > 0 }">카라반</c:if>
											<c:set var="random"><%=java.lang.Math.round(5 + java.lang.Math.random() * 44) %></c:set>
										</div>
										<div class="bold-text small-text">${one.name}</div>
										<div class="bold-text large-text">${random * 10000}<span class="small-text"> 원 부터</span></div>
										<div class="gray-text small-text">${one.addressPart1}<span></span>${one.addressPart2}</div>
									</div>
								</a>
							</div>
						</c:forEach>
					</div>
				</c:when>
				<c:when test="${kidsZone != null }">
					<div class="flex-container">
						<c:forEach items="${kidsZone }" var="one">
							<div class="flex-item">
								<a href="${pageContext.servletContext.contextPath }/camp/${one.id }" class="no-deco">
									<img src="${one.imageUrl }" onerror="this.src='../campimg.png'" class="camp-img">
									<div>
										<div class="gray-text small-text">
											<c:if test="${one.gnrlSite > 0 }">일반야영장</c:if>
											<c:if test="${one.autoSite > 0 }">오토캠핑</c:if>
											<c:if test="${one.glampSite > 0 }">글램핑</c:if>
											<c:if test="${one.caravSite > 0 }">카라반</c:if>
											<c:set var="random"><%=java.lang.Math.round(5 + java.lang.Math.random() * 44) %></c:set>
										</div>
										<div class="bold-text small-text">${one.name}</div>
										<div class="bold-text large-text">${random * 10000}<span class="small-text"> 원 부터</span></div>
										<div class="gray-text small-text">${one.addressPart1}<span></span>${one.addressPart2}</div>
									</div>
								</a>
							</div>
						</c:forEach>
					</div>
				</c:when>
				<c:when test="${pension != null }">
					<div class="flex-container">
						<c:forEach items="${pension }" var="one">
							<div class="flex-item">
								<a href="${pageContext.servletContext.contextPath }/camp/${one.id }" class="no-deco">
									<img src="${one.imageUrl }" onerror="this.src='../campimg.png'" class="camp-img">
									<div>
										<div class="gray-text small-text">
											펜션
											<c:if test="${one.gnrlSite > 0 }">일반야영장</c:if>
											<c:if test="${one.autoSite > 0 }">오토캠핑</c:if>
											<c:if test="${one.glampSite > 0 }">글램핑</c:if>
											<c:if test="${one.caravSite > 0 }">카라반</c:if>
											<c:set var="random"><%=java.lang.Math.round(5 + java.lang.Math.random() * 44) %></c:set>
										</div>
										<div class="bold-text small-text">${one.name}</div>
										<div class="bold-text large-text">${random * 10000}<span class="small-text"> 원 부터</span></div>
										<div class="gray-text small-text">${one.addressPart1}<span></span>${one.addressPart2}</div>
									</div>
								</a>
							</div>
						</c:forEach>
					</div>
				</c:when>
			</c:choose>
			<!-- 구분 -->
			<div class="center-text">
				<c:if test="${startPage > 1}">
					<a class="no-deco" href="${currentPath}?p=${startPage - 10}"><button class="button-b small-padding">&lt;</button></a>
				</c:if>
				<c:forEach begin="${startPage}" end="${endPage}" var="i">
					<c:choose>
						<c:when test="${i == currentPage }">
							<button class="button-d small-padding red-text">${i}</button>
						</c:when>
						<c:otherwise>
							<a class="no-deco" href="${currentPath}?p=${i}"><button class="button-b small-padding">${i}</button></a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${endPage < totalPages}">
					<a class="no-deco" href="${currentPath}?p=${startPage + 10}"><button class="button-b small-padding">&gt;</button></a>
				</c:if>
			</div>
		</div>
		<div class="fixed-footer">
			<%@ include file="../inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>