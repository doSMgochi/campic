<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다함께 캠핑가자, 캠픽</title>
</head>
<body>
	<%@ include file="./outer-nav.jsp"%>
	<div
		style="width: 500px; height: 860px; margin-left: 900px; margin-top: 20px; background: rgba(255, 255, 255, 0.9); border-radius: 25px; padding: 10px;">
		<!-- 임시 CSS 처리 -->
		<div
			style="display: flex; align-items: center; justify-content: space-between;">
			<div>어디로 떠나볼까요?</div>
			<div>
				<span>
					<button>지도</button>
				</span> <span>
					<button>찜 목록(*js)</button>
				</span>
			</div>

		</div>
		<div>
			<form
				action="${pageContext.servletContext.contextPath }/search/result">
				<input type="text" name="" placeholder="캠핑장명을 검색해 보세요"
					style="width: 100%" />
				<div
					style="display: flex; align-items: center; justify-content: space-between;">
					<input type="date" name="" placeholder="날짜" style="width: 48%" />
					<select style="width: 48%">
						<option disabled selected>지역</option>
					</select>
				</div>
				<button type="submit" style="width: 100%">검색하기</button>
			</form>
		</div>
		<div
			style="display: flex; align-items: center; justify-content: space-between;">
			<div>최근 본 캠핑장</div>
			<div>
				자동 저장
				<button>버튼</button>
			</div>
		</div>
		<div style="text-align: center;">
			<div>if문 돌려서 자동 저장 기능 켜져있으면 아래 출력</div>
			<div>자동 저장 기능이 꺼져있어요</div>
			<div>else 일 때, if 문 돌려서 최근 본 캠핑장이 없으면 아래 출력</div>
			<div>최근 본 캠핑장이 없어요</div>
			<div>있으면, 이름과 지역만 찍어주기</div>
		</div>
		<div>광고</div>
		<div style="position: absolute; bottom: 5%;">
			<%@ include file="./inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>