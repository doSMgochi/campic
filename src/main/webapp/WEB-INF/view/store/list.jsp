<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다함께 캠핑가자, 캠픽</title>
</head>
<body>
	<%@ include file="../outer-nav.jsp"%>
	<div
		style="width: 500px; height: 860px; margin-left: 900px; margin-top: 20px; background: rgba(255, 255, 255, 0.9); border-radius: 25px; padding: 10px;">
		<!-- 임시 CSS 처리 -->
		<div
			style="display: flex; align-items: center; justify-content: space-between;">

			<div>스토어</div>
			<div>검색(아이콘)</div>
		</div>
		<div>광고</div>
		<div>카테고리</div>
		<div>
			───────이하 게시판 목록인데 목록 자체가 랜덤으로 뜨는 듯?
			<div
				style="display: flex; align-items: center; justify-content: space-between;">
				<div>놓치면 끝! 타임 특가</div>
				<div>전체보기</div>
			</div>
			<div
				style="display: flex; align-items: center; justify-content: space-between;">
				<div>캠핑 입문 아이템</div>
				<div>전체보기</div>
			</div>
			<div
				style="display: flex; align-items: center; justify-content: space-between;">
				<div>우중 낭만 캠핑!</div>
				<div>전체보기</div>
			</div>
			<div
				style="display: flex; align-items: center; justify-content: space-between;">
				<div>베스트 리뷰</div>
				<div>전체보기</div>
			</div>
			<div
				style="display: flex; align-items: center; justify-content: space-between;">
				<div>모아보기 (모아보기부터는 z-index 처리된 카테고리 있음)</div>
				<div>전체보기</div>
			</div>
			<footer> FOOTER </footer>
		</div>
		<div style="position: absolute; bottom: 5%;">
			<%@ include file="../inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>