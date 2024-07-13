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
		<div class="flex-between margin-top-5">
			<div class="bold-text">어디로 떠나볼까요?</div>
			<div>
				<span>
					<button class="button-a"><i class="fa-regular fa-map"></i></button>
				</span> 
				<span>
					<button class="button-a"><i class="fa-regular fa-bookmark"></i></button>
				</span>
			</div>
		</div>
		<div>
			<form action="${pageContext.servletContext.contextPath }/search/result">
				<input class="button-a full-width" type="text" name="camp" placeholder="캠핑장명을 검색해 보세요" />
				<div class="flex-between">
					<input class="button-a half-width" type="date" name="" placeholder="날짜" /> 
					<select class="button-a half-width">
						<option disabled selected>지역</option>
					</select>
				</div>
				<button class="button-b full-width margin-top-10" type="submit">검색하기</button>
			</form>
		</div>
		<div class="flex-between margin-top-10">
			<div class="bold-text">최근 본 캠핑장</div>
			<div class="darkslateblue-text">
				자동 저장 <button>버튼</button>
			</div>
		</div>
		<div class="center-text">
			<div>if문 돌려서 자동 저장 기능 켜져있으면 아래 출력</div>
			<div>자동 저장 기능이 꺼져있어요</div>
			<div>else 일 때, if 문 돌려서 최근 본 캠핑장이 없으면 아래 출력</div>
			<div>최근 본 캠핑장이 없어요</div>
			<div>있으면, 이름과 지역만 찍어주기</div>
		</div>
		<div class="ad-section">
			<img src="./ad.jpg" class="ad-img" />
		</div>
		<div class="flex-between margin-10">
			<div class="bold-text">테마 기획전</div>
			<div class="darkslateblue-text">전체보기</div>
		</div>
		<div class="fixed-footer">
			<%@ include file="./inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>