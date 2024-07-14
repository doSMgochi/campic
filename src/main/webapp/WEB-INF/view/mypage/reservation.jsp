<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다함께 캠핑가자, 캠픽</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/style.css" />
<script>
	function togglePopup() {
		var popup = document.getElementById('popup');
		if (popup.classList.contains('show')) {
			popup.classList.remove('show');
			setTimeout(function() {
				popup.style.display = 'none';
			}, 500); // Match this duration with the CSS transition duration
		} else {
			popup.style.display = 'block';
			setTimeout(function() {
				popup.classList.add('show');
			}, 10); // Slight delay to allow the popup to be displayed before adding the class
		}
	}
</script>
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
			<div>예약 내역</div>
			<div>
				<button type="button" class="button-a" onclick="togglePopup();">
					<i class="fa-solid fa-headset"></i>
				</button>
			</div>
		</div>
		<div class="flex-between align-center">
			<div>전체 |</div>
			<div>결제대기 |</div>
			<div>예약완료 |</div>
			<div>이용완료 |</div>
			<div>취소/환불</div>
		</div>
		<div>if문 처리하고 예약 내역 출력</div>
		<div>없으면 아래 내용 출력</div>
		<c:choose>
			<c:when test="${own == true }">
				<div class="center-text">${reservationCampsite.name }</div>
			</c:when>
			<c:otherwise>
				<div class="center-text">
					예약 된 캠핑장이 없어요.<br />비어있는 캠핑장을 확인해보세요<br /> <a href=""><button
							class="button-c">빠른 빈자리 찾기</button></a>
				</div>
			</c:otherwise>
		</c:choose>
		<div class="fixed-footer">
			<%@ include file="../inner-nav.jsp"%>
		</div>
	</div>

	<!-- Popup Window -->
	<div id="popup" class="popup">
		<div class="popup-header">
			<span class="close-btn" onclick="togglePopup();">&times;</span>
		</div>
		<div class="popup-content">
			<p>캠픽 문의 만들기</p>
		</div>
	</div>
</body>
</html>