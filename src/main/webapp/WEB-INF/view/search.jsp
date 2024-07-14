<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다함께 캠핑가자, 캠픽</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/style.css" />
<script>
		function getCookie(name) {
			let matches = document.cookie.match(new RegExp(
				"(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
			));
			return matches ? decodeURIComponent(matches[1]) : undefined;
		}

		function setCookie(name, value, options = {}) {
			options = {
				path: '/',
				...options
			};

			if (options.expires instanceof Date) {
				options.expires = options.expires.toUTCString();
			}

			let updatedCookie = encodeURIComponent(name) + "=" + encodeURIComponent(value);

			for (let optionKey in options) {
				updatedCookie += "; " + optionKey;
				let optionValue = options[optionKey];
				if (optionValue !== true) {
					updatedCookie += "=" + optionValue;
				}
			}

			document.cookie = updatedCookie;
		}

		function toggleRecentCamps() {
			const isEnabled = document.getElementById('toggle').checked;
			setCookie('autoSaveEnabled', isEnabled, { 'max-age': 3600 * 24 * 365 });
			document.getElementById('toggleStatus').innerText = isEnabled ? '' : '자동 저장 기능이 꺼져있습니다.';
			document.getElementById('recentCampsList').style.display = isEnabled ? 'block' : 'none';
		}

		document.addEventListener('DOMContentLoaded', function() {
			const autoSaveEnabled = getCookie('autoSaveEnabled') === 'true';
			document.getElementById('toggle').checked = autoSaveEnabled;
			toggleRecentCamps(); // 초기 상태 설정
		});
	</script>
</head>
<body>
	<%@ include file="./outer-nav.jsp"%>
	<div class="fixed-box">
		<div class="content-box">
			<div class="flex-between margin-top-5">
				<div class="bold-text">어디로 떠나볼까요?</div>
				<div>
					<span>
						<button class="button-a">
							<i class="fa-regular fa-map"></i>
						</button>
					</span> <span>
						<button class="button-a">
							<i class="fa-regular fa-bookmark"></i>
						</button>
					</span>
				</div>
			</div>
			<div>
				<form
					action="${pageContext.servletContext.contextPath }/search/result">
					<input class="button-a full-width" type="text" name="camp"
						placeholder="캠핑장명을 검색해 보세요" />
					<div class="flex-between">
						<input class="button-a half-width" type="date" name=""
							placeholder="날짜" /> <select class="button-a half-width">
							<option disabled selected>지역</option>
							<option>서울</option>
							<option>부산</option>
							<option>대구</option>
							<option>인천</option>
							<option>광주</option>
							<option>대전</option>
							<option>울산</option>
							<option>세종</option>
							<option>경기</option>
							<option>강원</option>
							<option>충청</option>
							<option>전라</option>
							<option>경상</option>
							<!-- select box 꾸미기 -->
						</select>
					</div>
					<button class="button-b full-width margin-top-10" type="submit">검색하기</button>
				</form>
			</div>
			<div class="flex-between margin-top-10">
				<div class="bold-text">최근 본 캠핑장</div>
				<div class="darkslateblue-text flex">
					자동 저장
					<div class="toggle-switch">
						<input type="checkbox" id="toggle" class="toggle-input"
							onclick="toggleRecentCamps()"> <label for="toggle"
							class="toggle-label"></label>
					</div>
				</div>
			</div>
			<div class="center-text">
				<div id="toggleStatus"></div>
				<div id="recentCampsList">
					<c:if test="${empty recentCamps}">
						<div>최근 본 캠핑장이 없어요</div>
					</c:if>
					<c:forEach var="camp" items="${recentCamps}">
						<div class="margin-top-20">
							<a
								href="${pageContext.servletContext.contextPath }/camp/${camp.id}"><button
									class="button-a">${camp.name}- ${camp.address}</button></a>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="ad-section margin-top-20">
				<img src="./ad.jpg" class="ad-img" />
			</div>
			<div class="flex-between margin-10">
				<div class="bold-text">테마 기획전</div>
				<div class="darkslateblue-text">전체보기</div>
			</div>
		</div>
		<div class="fixed-footer">
			<%@ include file="./inner-nav.jsp"%>
		</div>
	</div>

	<script src="search.js"></script>
</body>
</html>
