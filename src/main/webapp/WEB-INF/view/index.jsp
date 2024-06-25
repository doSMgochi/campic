<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다함께 캠핑가자, 캠픽</title>
</head>
<body>
	NAVVAR1
	<div style="width: 500px; margin-left: 900px; margin-top: 20px">
		<!-- 임시 CSS 처리 -->
		<div
			style="display: flex; align-items: center; justify-content: space-between;">

			<div>로고(CAMPIC)(이미지)</div>
			<div>
				<a
					href="${pageContext.servletContext.contextPath }/mypage/reservation"><button>예약조회</button></a>
			</div>
			<div>
				<a href="${pageContext.servletContext.contextPath }/mypage/alarms"><button>알림
						버튼(아이콘)</button></a>
			</div>
		</div>
		<div>광고</div>
		<div>카테고리</div>
		<div>예약오픈 일정 한눈에 보기</div>
		<div
			style="display: flex; align-items: center; justify-content: space-between;">
			<div>실시간 캠핑 로그</div>
			<div>전체보기</div>
		</div>
		<div
			style="display: flex; align-items: center; justify-content: space-between;">
			<div>캠핑장 기획전</div>
			<div>전체보기</div>
		</div>
		<div
			style="display: flex; align-items: center; justify-content: space-between;">
			<div>MD픽 캠핑장</div>
			<div>전체보기</div>
		</div>
		<div
			style="display: flex; align-items: center; justify-content: space-between;">
			<div>캠핑 Magazine</div>
			<div>전체보기</div>
		</div>
		<div
			style="display: flex; align-items: center; justify-content: space-between;">
			<div>캠핑 기획전</div>
			<div>전체보기</div>
		</div>
		<footer> FOOTER </footer>
		<div style="position: absolute; bottom: 1%;">
			<%@ include file="./inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>