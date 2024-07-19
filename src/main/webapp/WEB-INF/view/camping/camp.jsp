tr<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다함께 캠핑가자, 캠픽</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/style.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
<style type="text/css">
ul, li {
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<%@ include file="../outer-nav.jsp"%>
	<div class="fixed-box">
		<div class="no-scroll" style="overflow-y: scroll; max-height: 85vh;">
			<c:choose>
				<c:when test="${cabin > 0}">
					<div>
						<img src="${campsite.imageUrl }" onerror="this.src='../campimg.png'" class="large-img">
					</div>
					<div class="center-text">
						<div class="red-text">*sample cabin</div>
						<div>오토캠핑</div>
						<div>A구역(강자갈)</div>
						<div>강자갈로 깔려있어요</div>
					</div>
					<div class="flex-around align-center">
						<div>
							<div>유형</div>
							<div>오토캠핑</div>
						</div>
						<div>
							<div>기본 크기</div>
							<div>8m X 10m</div>
						</div>
						<div>
							<div>바닥</div>
							<div>데크</div>
						</div>
						<div>
							<div>주차</div>
							<div>텐트 옆 주차</div>
						</div>
					</div>
					<div>캠핑존 소개</div>
					<div>세척실화장실이 가까워요</div>
					<div>밤하늘별도 잘보이고요</div>
					<div>캠핑존 세부정보</div>
					<div class="flex-between align-center">
						<div>
							<div>체크인·체크아웃</div>
							<div>오후 02:00 ~ 오후 12:00</div>
						</div>
						<div>
							<div>장박</div>
							<div>장박 불가</div>
						</div>
						<div>
							<div>기본인원</div>
							<div>성인 2명·미성년 2명</div>
						</div>
						<div>
							<div>기본주차</div>
							<div>1대</div>
						</div>
					</div>
					<div class="flex-between align-center">
						<div>사이트선택</div>
						<div>
							<button class="button-a">06.28~06.29/1박</button>
						</div>
					</div>
					<div class="flex-between align-center">
						<div>총1개 예약 가능</div>
						<div>1박 이상 예약가능</div>
					</div>
					<div class="flex-between align-center">
						<div>캠핑로그</div>
						<div>포토 로그만 보기</div>
					</div>
					<div>캠핑장 운영정책</div>
					<div>행복한 캠핑을 위해서 필독 후 이용 부탁드립니다.</div>
					<div>캠핑장 운영정책에는 환불·양도양수·시설이용시간 등 캠핑장 이용에 관한 가이드가 포함되어 있습니다.</div>
					<div>
						<button class="full-width">캠핑장 운영정책 더보기</button>
					</div>
					<div class="flex-between align-center">
						<div>
							<div>A구역(강자갈) 이용요금</div>
							<div>이용 요금표, 인원초과금액, 주차초과금액</div>
						</div>
						<div>></div>
					</div>
					<div class="flex-between align-center">
						<div>
							<div>취소 환불 규정</div>
							<div>환불기준(평일/주말)</div>
						</div>
						<div>></div>
					</div>
					<div class="flex-between align-center">
						<div>
							<div>60,000원 / 1박</div>
							<div>성인2·청소년0·미취학0</div>
						</div>
						<div>
							<form action="${pageContext.servletContext.contextPath }/camp-reservation/${campsite.id }">
								<input type="hidden" name="cabin" value="1">
								<button type="submit" class="button-b">사이트 예약하기</button>
							</form>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div>
						<img src="${campsite.imageUrl }" onerror="this.src='../campimg.png'" class="large-img margin-top-15">
					</div>
					<div class="padding-15">
						<div class="small-text dark-text">
							<br />
							<c:if test="${campsite.gnrlSite > 0 }">일반야영장</c:if>
							<c:if test="${campsite.autoSite > 0 }">오토캠핑</c:if>
							<c:if test="${campsite.glampSite > 0 }">글램핑</c:if>
							<c:if test="${campsite.caravSite > 0 }">카라반</c:if>
						</div>
						<div class="large-text bold-text">${campsite.name }</div>
						<hr class="width-250 margin-25-auto">
						<div>조인한 캠핑로그 count*</div>
						<div class="small-text">
							<i class="fa-solid fa-location-dot"></i> ${campsite.address }
						</div>
						<div class="small-text">
							<i class="fa-solid fa-phone"></i> ${campsite.tel }
						</div>
						<div class="small-text">
							<c:if test="${campsite.businessNumber != null }">
								<i class="fa-solid fa-circle-check"></i> 관광사업자로 등록된 인증 캠핑장
							</c:if>
						</div>
						<c:if test="${campsite.resveCl != null }">
							<div>
								<button class="button-a margin-10-0">${campsite.resveCl }</button>
							</div>
						</c:if>
						<ul class="flex-between list-none margin-15-0 small-text">
							<li class="bold-text underline">기본정보</li>
							<li>공지사항</li>
							<li>캠핑장 소개</li>
							<li>시설 및 레저</li>
							<li>캠핑로그</li>
						</ul>
						<div class="bold-text large-text margin-25-0">기본정보</div>
						<table>
							<thead>
								<tr>
									<td class="width-100"></td>
									<td></td>
								</tr>
							</thead>
							<tr>
								<td class="vertical-align-top">환경</td>
								<td class="dark-text small-text">${campsite.environment }</td>
							</tr>
							<tr>
								<td class="vertical-align-top">한줄소개</td>
								<td class="dark-text small-text">${campsite.lineIntro }</td>
							</tr>
							<tr>
								<td class="vertical-align-top">위치소개</td>
								<td class="dark-text small-text">${campsite.direction }</td>
							</tr>
						</table>
						<div class="bold-text large-text margin-25-0">공지사항</div>
						<div class="bold-text large-text margin-25-0">캠핑장 소개</div>
						<div class="small-text bold-text">${campsite.lineIntro }</div>
						<div class="small-text">${campsite.intro }</div>
						<div class="flex-between align-center">
							<div class="bold-text large-text margin-25-0">시설 및 레저</div>
							<div>전체보기</div>
						</div>
						<div class="flex-between align-center">
							<div class="bold-text large-text margin-25-0">캠핑존 둘러보기</div>
							<div>일정 선택하기</div>
						</div>
						<div class="flex-between align-center bordered padding-10 white-bg border-radius-5">
							<div>예약 가능</div>
							<div>다음시즌 오픈일</div>
						</div>
						<div>펜션 이미지 몇 개 추가해서 math.random으로 이미지 부여</div>
						<div>div inline block으로 만들어서 정렬하고 사진 옆에 글 사용</div>
						<div>
							<form action="${pageContext.servletContext.contextPath }/camp/${campsite.id}">
								<input type="hidden" name="cabin" value="1">
								<button type="submit" class="button-b">cabin 종류(있다고 치고 하나 넣기)</button>
							</form>
						</div>
						<div>cabin 설명</div>
						<div>가격 / 1박</div>
						<div>체크인 시간, 체크아웃 시간</div>
						<div>태그</div>
						<div>조인한 캠핑로그 출력</div>
						<div class="flex-between align-center">
							<div class="bold-text large-text margin-25-0">캠핑로그</div>
							<div>
								포토 로그만 보기
								<button class="button-a"></button>
							</div>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="fixed-footer">
			<%@ include file="../inner-nav.jsp"%>
		</div>
	</div>
</body>
</html>