<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다함께 캠핑가자, 캠픽</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/style.css" />
</head>
<body>
	<%@ include file="./outer-nav.jsp"%>
	<div class="fixed-box">
		<div class="flex-between">
			<div>
				<img src="./logo.png" class="logo-img" />
			</div>
			<div>
				<a href="${pageContext.servletContext.contextPath }/mypage/reservation"><button class="button-a">예약조회</button></a>
				<a href="${pageContext.servletContext.contextPath }/mypage/alarms"><button class="button-a">
					<i class="fa-regular fa-bell"></i>
				</button></a>
			</div>
		</div>
		<div class="ad-section">
			<img src="./ad.jpg" class="ad-img" />
		</div>
		<div class="section-margin">
			<div class="flex-between">
				<div class="icon-container">
					<a href="${pageContext.servletContext.contextPath }/exhibition/1"><button class="button-b button-icon">
						<i class="fa-solid fa-person-swimming icon-size"></i>
					</button></a>
					<br /><span class="icon-text">물놀이가자</span>
				</div>
				<div class="icon-container">
					<a href="${pageContext.servletContext.contextPath }/exhibition/2"><button class="button-b button-icon">
						<i class="fa-solid fa-mountain-sun icon-size"></i>
					</button></a>
					<br /><span class="icon-text">만만한캠핑</span>
				</div>
				<div class="icon-container">
					<a href="${pageContext.servletContext.contextPath }/exhibition/3"><button class="button-b button-icon">
						<i class="fa-solid fa-children icon-size"></i>
					</button></a>
					<br /><span class="icon-text">키즈캠핑</span>
				</div>
				<div class="icon-container">
					<a href="${pageContext.servletContext.contextPath }/search/result?additionalFacilities=pet"><button class="button-b button-icon">
						<i class="fa-solid fa-dog icon-size"></i>
					</button></a>
					<br /><span class="icon-text">반려견캠핑</span>
				</div>
				<div class="icon-container">
					<a href=""><button class="button-b button-icon">
						<i class="fa-solid fa-clock icon-size"></i>
					</button></a>
					<br /><span class="icon-text">빠른예약</span>
				</div>
			</div>
			<div class="flex-between section-margin">
				<div class="icon-container">
					<a href=""><button class="button-c button-icon">
						<i class="fa-solid fa-fire icon-size"></i>
					</button></a>
					<br /><span class="icon-text">오토캠핑</span>
				</div>
				<div class="icon-container">
					<a href=""><button class="button-c button-icon">
						<i class="fa-solid fa-campground icon-size"></i>
					</button></a>
					<br /><span class="icon-text">글램핑</span>
				</div>
				<div class="icon-container">
					<a href=""><button class="button-c button-icon">
						<i class="fa-solid fa-caravan icon-size"></i>
					</button></a>
					<br /><span class="icon-text">카라반</span>
				</div>
				<div class="icon-container">
					<a href="${pageContext.servletContext.contextPath }/exhibition/4"><button class="button-c button-icon">
						<i class="fa-solid fa-house-chimney icon-size"></i>
					</button></a>
					<br /><span class="icon-text">펜션</span>
				</div>
				<div class="icon-container">
					<a href=""><button class="button-c button-icon">
						<i class="fa-solid fa-gift icon-size"></i>
					</button></a>
					<br /><span class="icon-text">이벤트</span>
				</div>
			</div>
		</div>
		<div class="info-section">
			<div>
				<i class="fa-solid fa-tents info-icon"></i>
			</div>
			<div class="info-text">
				예약오픈 일정 한눈에 보기<br /> <small>오픈 일정이 궁금하신가요?</small>
			</div>
		</div>
		<div>
			<div class="flex-between margin-10">
				<div class="bold-text">실시간 캠핑 로그</div>
				<div class="darkslateblue-text">전체보기</div>
			</div>
			<div class="fixed-footer">
				<%@ include file="./inner-nav.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>