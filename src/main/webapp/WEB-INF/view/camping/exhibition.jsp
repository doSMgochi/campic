<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다함께 캠핑가자, 캠픽</title>
</head>
<body>
	<%@ include file="../outer-nav.jsp"%>
	<div class="fixed-box">
		<div class="content-box">
			<!-- 임시 CSS 처리 -->
			<div
				style="display: flex; align-items: center; justify-content: space-between;">

				<div>
					<input type="button" value="&lt;(아이콘 변경)" onclick="history.back();" />
				</div>
				<div>미리 떠나는 휴가(파라미터로 받은 카테고리명 조회)</div>
				<div></div>
			</div>
			<div>배너</div>
			<div>
				<!-- 한 40%? 씩 -->
				foreach 로 이미지, 종류, 이름, 낮은 price~ 지역 찍어주기
			</div>
			<div>스크롤 내려가면 위로 올리는 버튼? js 필요할 듯</div>
			<div style="text-align: center; margin-top: 30px">
				<!-- 엑박 이미지 대체 이미지 넣기 -->
				<c:choose>
					<c:when test="${vacances != null }">
						<c:forEach items="${vacances }" var="one">
							<img src="${one.imageUrl }" style="width: 40px; height: 40px">
							<br />
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
						${one.name }
						<br />
						가격(조인)
						<br />
						address 띄어쓰기로 split
						<br />
						</c:forEach>
					</c:when>
					<c:when test="${kidsZone != null }">
						<c:forEach items="${kidsZone }" var="one">
							<img src="${one.imageUrl }" style="width: 40px; height: 40px">
							<br />
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
						${one.name }
						<br />
						가격(조인)
						<br />
						address 띄어쓰기로 split
						<br />
						</c:forEach>
					</c:when>
					<c:when test="${pension != null }">
						<c:forEach items="${pension }" var="one">
							<img src="${one.imageUrl }" style="width: 40px; height: 40px">
							<br />
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
						${one.name }
						<br />
						가격(조인)
						<br />
						address 띄어쓰기로 split
						<br />
						</c:forEach>
					</c:when>
				</c:choose>
				<!-- 구분 -->
				<c:if test="${startPage > 1}">
					<a href="${currentPath}?p=${startPage - 10}">&lt; 이전</a>
				</c:if>
				<c:forEach begin="${startPage}" end="${endPage}" var="i">
					<c:choose>
						<c:when test="${i == currentPage }">
							<b style="color: red">${i }</b>
						</c:when>
						<c:otherwise>
							<a href="${currentPath}?p=${i}">${i }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${endPage < totalPages}">
					<a href="${currentPath}?p=${startPage + 10}">다음 &gt;</a>
				</c:if>
			</div>
			<div class="fixed-footer">
				<%@ include file="../inner-nav.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>