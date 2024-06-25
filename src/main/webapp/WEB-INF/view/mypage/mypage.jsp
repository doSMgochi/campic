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
			<div>마이</div>
			<div>
				<span> 알람 </span> <span> 상담(아이콘 변경)(*JS) </span> <span> 설정 </span>
			</div>

		</div>
		<div>
			<a href="${pageContext.servletContext.contextPath }/mypage/info/edit">(인장)
				내 정보 관리 ></a>
		</div>
		<div
			style="display: flex; align-items: center; justify-content: space-between;">
			<div>공지</div>
			<div>></div>
		</div>
		<div
			style="display: flex; align-items: center; justify-content: space-around;">
			<div>나의 캠핑</div>
			<div>나의 쇼핑</div>
		</div>
		<div
			style="display: flex; align-items: center; justify-content: space-around;">
			<div>예약내역</div>
			<div>빈자리 구독</div>
			<div>캠핑로그</div>
			<div>찜 목록</div>
		</div>
		<div
			style="display: flex; align-items: center; justify-content: space-between;">
			<div>캠핑장 쿠폰</div>
			<div>></div>
		</div>
		<div>내 장비</div>
		<div>박스들~</div>
		<br/>
		<div>캠핑</div>
		<div>내 사용 리뷰</div>
		<div>나의 활동</div>
		<div>캠핑 기획전</div>
		<div>진행중인 이벤트</div>
		<br/>
		<div>고객센터</div>
		<div>공지사항</div>

		<div style="position: absolute; bottom: 1%;">
			<%@ include file="../inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>