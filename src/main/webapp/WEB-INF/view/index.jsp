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
	<div class="fixed-box">
		<!-- 임시 CSS 처리 -->
		<div class="status-bar">
			<div class="status-bar__column">
				<img src="./logo.png" style="width: 130px; height: 70px" />
			</div>
			<div class="status-bar__column status-bar__column:nth-child(2)">
				<a
					href="${pageContext.servletContext.contextPath }/mypage/reservation"><button>예약조회</button></a>
			</div>
			<div class="status-bar__column status-bar__column:last-child">
				<a href="${pageContext.servletContext.contextPath }/mypage/alarms"><button>알림
						버튼(아이콘)</button></a>
			</div>
		</div>
		<div>광고</div>
		<div>
			카테고리
			<div
				style="display: flex; align-items: center; justify-content: space-between;">
				<div>
					<a href="${pageContext.servletContext.contextPath }/exhibition/1"><button
							style="width: 70px; height: 70px">물놀이가자</button></a>
				</div>
				<div>
					<a href="${pageContext.servletContext.contextPath }/exhibition/2"><button
							style="width: 70px; height: 70px">만만한캠핑</button></a>
				</div>
				<div>
					<a href="${pageContext.servletContext.contextPath }/exhibition/3"><button
							style="width: 70px; height: 70px">키즈캠핑</button></a>
				</div>
				<div>
					<a
						href="${pageContext.servletContext.contextPath }/search/result?additionalFacilities=pet"><button
							style="width: 70px; height: 70px">반려견캠핑</button></a>
				</div>
				<div>
					<a href=""><button style="width: 70px; height: 70px">빠른예약</button></a>
				</div>
			</div>
			<div
				style="display: flex; align-items: center; justify-content: space-between;">
				<div>
					<a href=""><button style="width: 70px; height: 70px">오토캠핑</button></a>
				</div>
				<div>
					<a href=""><button style="width: 70px; height: 70px">글램핑</button></a>
				</div>
				<div>
					<a href=""><button style="width: 70px; height: 70px">카라반</button></a>
				</div>
				<div>
					<a href="${pageContext.servletContext.contextPath }/exhibition/4"><button
							style="width: 70px; height: 70px">펜션</button></a>
				</div>
				<div>
					<a href=""><button style="width: 70px; height: 70px">이벤트</button></a>
				</div>
			</div>
		</div>
		<div>예약오픈 일정 한눈에 보기</div>
		<div>
			───────이하 게시판 목록인데 목록 자체가 랜덤으로 뜨는 듯?
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
				<div>MD픽 캠핑장 (화면 넘어가는 부분 js)</div>
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
			<div class="fixed-footer">
				<%@ include file="./inner-nav.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>