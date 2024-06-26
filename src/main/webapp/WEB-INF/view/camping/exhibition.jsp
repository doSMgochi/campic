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

			<div>
				<input type="button" value="&lt;(아이콘 변경)" onclick="history.back();" />
			</div>
			<div>미리 떠나는 휴가(파라미터로 받은 카테고리명 조회)</div>
			<div></div>
		</div>
		<div>배너</div>
		<div> <!-- 한 40%? 씩 -->
		foreach 로 이미지, 종류, 이름, 낮은 price~ 지역 찍어주기
		</div>
		<div>
		스크롤 내려가면 위로 올리는 버튼? js 필요할 듯
		</div>
		<div style="position: absolute; bottom: 1%;">
			<%@ include file="../inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>