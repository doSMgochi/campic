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
				<button type="button" class="button-a" onclick="history.back();">&lt;(아이콘 변경)</button>
			</div>
			<div>캠핑장 예약하기</div>
			<div></div>
		</div>
		<div>
			<div>div 인라인블록 처리</div>
			<div>땡땡캠핑장</div>
			<div>A구역(강자갈)·A강자갈-01</div>
			<div>기준인원: 성인 2명, 미성년 2명</div>
			<div>기준차량: 1대</div>
		</div>
		<div class="flex-around align-center">
			<div>
				<div>체크인</div>
				<div>06.28(금)</div>
				<div>오후 02:00</div>
			</div>
			<div>
				<div>1박</div>
			</div>
			<div>
				<div>체크아웃</div>
				<div>06.29(토)</div>
				<div>오후 12:00</div>
			</div>
		</div>
		<div>전체 인원 정보</div>
		<div class="flex-between align-center">
			<div>성인</div>
			<div>-2+</div>
		</div>
		<div class="flex-between align-center">
			<div>청소년</div>
			<div>-2+</div>
		</div>
		<div class="flex-between align-center">
			<div>미취학 아동</div>
			<div>-2+</div>
		</div>
		<div>
			<div class="flex-around align-center">
				<div>기준인원</div>
				<div>성인 2명, 미성년 2명</div>
			</div>
			<div class="flex-around align-center">
				<div>추가 가능 인원</div>
				<div>성인 0명, 미성년 2명</div>
			</div>
			<div class="flex-around align-center">
				<div>총 인원 제한</div>
				<div>6명</div>
			</div>
		</div>
		<div>*잠시 방문하는 게스트도 인원 정보에 포함해야 합니다.</div>
		<div>*사회적 거리두기 조치에 따라 예약내용에 없는 게스트는 캠핑장 입장이 불허할 수 있으니 예약시 주의 바랍니다.</div>
		<div>전체 차량 정보</div>
		<div>
			<form action="${pageContext.servletContext.contextPath }/camp-reservation-handle">
				<input type="hidden" name="campsiteId" value="${campsite.id }">
				<button type="submit" class="full-width">예약하기</button>
			</form>
		</div>
		<div class="fixed-footer">
			<%@ include file="../inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>