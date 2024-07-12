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
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<style type="text/css">
ul, li {
	margin: 0;
	padding: 0;
}
</style>
<body>
	<!-- 전체 padding 값 하나 넣어야할 듯 ? 디자인 기준 페이지-->
	<%@ include file="../outer-nav.jsp"%>
	<div class="fixed-box">
		<div class="no-scroll" style="overflow-y: scroll; max-height: 85vh;">
			<c:choose>
				<c:when test="${cabin > 0}">
					<div>
						<img src="${campsite.imageUrl }"
							onerror="this.src='../campimg.png'"
							style="width: 100%; height: 450px; border-radius: 15px" />
					</div>
					<div style="text-align: center">
						<div style="color: red">*sample cabin</div>
						<div>오토캠핑</div>
						<div>A구역(강자갈)</div>
						<div>강자갈로 깔려있어요</div>
					</div>
					<div
						style="display: flex; align-items: center; justify-content: space-around;">
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
					<div
						style="display: flex; align-items: center; justify-content: space-between;">
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
					<div
						style="display: flex; align-items: center; justify-content: space-between;">
						<div>사이트선택</div>
						<div>
							<button>06.28~06.29/1박</button>
						</div>
					</div>
					<div
						style="display: flex; align-items: center; justify-content: space-between;">
						<div>총1개 예약 가능</div>
						<div>1박 이상 예약가능</div>
					</div>
					<div
						style="display: flex; align-items: center; justify-content: space-between;">
						<div>캠핑로그</div>
						<div>포토 로그만 보기</div>
					</div>
					<div>캠핑장 운영정책</div>
					<div>행복한 캠핑을 위해서 필독 후 이용 부탁드립니다.</div>
					<div>캠핑장 운영정책에는 환불·양도양수·시설이용시간 등 캠핑장 이용에 고나한 가이드가 포함되어 있습니다.
					</div>
					<div>
						<button style="width: 100%">캠핑장 운영정책 더보기</button>
					</div>
					<div
						style="display: flex; align-items: center; justify-content: space-between;">
						<div>
							<div>A구역(강자갈) 이용요금</div>
							<div>이용 요금표, 인원초과금액, 주차초과금액</div>
						</div>
						<div>></div>
					</div>
					<div
						style="display: flex; align-items: center; justify-content: space-between;">
						<div>
							<div>취소 환불 규정</div>
							<div>환불기준(평일/주말)</div>
						</div>
						<div>></div>
					</div>
					<div
						style="display: flex; align-items: center; justify-content: space-between;">
						<div>
							<div>60,000원 / 1박</div>
							<div>성인2·청소년0·미취학0</div>
						</div>
						<div>

							<form
								action="${pageContext.servletContext.contextPath }/camp-reservation/${campsite.id }">
								<input type="hidden" name="cabin" value="1">
								<button type="submit">사이트 예약하기</button>
							</form>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div>
						<img src="${campsite.imageUrl }"
							onerror="this.src='../campimg.png'"
							style="width: 100%; height: 450px; border-radius: 15px; box-shadow: 0px 4px 5px black; margin-top: 15px" />
					</div>
					<div style="padding: 15px">
						<div style="font-size: 0.9rem; color: #333;">
							<br />
							<c:if test="${campsite.gnrlSite > 0 }">
                                        일반야영장
                                    </c:if>
							<c:if test="${campsite.autoSite > 0 }">
                                        오토캠핑
                                    </c:if>
							<c:if test="${campsite.glampSite > 0 }">
                                        글램핑
                                    </c:if>
							<c:if test="${campsite.caravSite > 0 }">
                                        카라반
                                    </c:if>
						</div>
						<div style="font-size: 1.5rem; font-weight: bold">${campsite.name }</div>
						<hr style="width: 250px; margin: 25px auto">
						<div>조인한 캠핑로그 count*</div>
						<div style="font-size: 0.9rem">
							<i class="fa-solid fa-location-dot"></i> ${campsite.address }
						</div>
						<div style="font-size: 0.9rem">
							<i class="fa-solid fa-phone"></i> ${campsite.tel }
						</div>
						<div style="font-size: 0.9rem">
							<c:if test="${campsite.businessNumber != null }">
								<i class="fa-solid fa-circle-check"></i> 관광사업자로 등록된 인증 캠핑장
		 </c:if>
						</div>
						<c:if test="${campsite.resveCl != null }">
							<div>
								<button class="button-a" style="margin: 10px 0">${campsite.resveCl }</button>
							</div>
						</c:if>
						<ul
							style="display: flex; list-style: none; justify-content: space-between; margin: 15px 0; font-size: 0.9rem">
							<li
								style="font-weight: bold; text-decoration: underline 2px black; text-underline-offset: 10px;">기본정보</li>
							<li>공지사항</li>
							<li>캠핑장 소개</li>
							<li>시설 및 레저</li>
							<li>캠핑로그</li>
						</ul>
						<div style="font-size: 1.1rem; font-weight: bold; margin: 25px 0">
							기본정보</div>
						<table>
							<thead>
								<tr>
									<td style="width: 100px"></td>
									<td></td>
								</tr>
							</thead>
							<tr>
								<td style="vertical-align: top;">환경</td>
								<td style="color: #555; font-size: 0.9rem">${campsite.environment }</td>
							</tr>
							<tr>
								<td style="vertical-align: top;">한줄소개</td>
								<td style="color: #555; font-size: 0.9rem">${campsite.lineIntro }</td>
							</tr>
							<tr>
								<td style="vertical-align: top;">위치소개</td>
								<td style="color: #555; font-size: 0.9rem">${campsite.direction }</td>
							</tr>
						</table>
						<div style="font-size: 1.1rem; font-weight: bold; margin: 25px 0">
							공지사항</div>
						<div style="font-size: 1.1rem; font-weight: bold; margin: 25px 0">
							캠핑장 소개</div>
						<div style="font-size: 0.9rem; font-weight: bold">${campsite.lineIntro }</div>
						<div style="font-size: 0.9rem">${campsite.intro }</div>
						<div
							style="display: flex; align-items: center; justify-content: space-between;">
							<div style="font-size: 1.1rem; font-weight: bold; margin: 25px 0">시설
								및 레저</div>
							<div>전체보기</div>
						</div>
						<div
							style="display: flex; align-items: center; justify-content: space-between;">
							<div style="font-size: 1.1rem; font-weight: bold; margin: 25px 0">캠핑존
								둘러보기</div>
							<div>일정 선택하기</div>
						</div>
						<div
							style="display: flex; align-items: center; justify-content: space-between; border: 1px solid lightgray; padding: 10px; background: white; border-radius: 5px">
							<div>예약 가능</div>
							<div>다음시즌 오픈일</div>
						</div>
						<div>펜션 이미지 몇 개 추가해서 math.random으로 이미지 부여</div>
						<div>div inline block으로 만들어서 정렬하고 사진 옆에 글 사용</div>
						<div>
							<form
								action="${pageContext.servletContext.contextPath }/camp/${campsite.id}">
								<input type="hidden" name="cabin" value="1">
								<button type="submit">cabin 종류(있다고 치고 하나 넣기)</button>
							</form>
						</div>
						<div>cabin 설명</div>
						<div>가격 / 1박</div>
						<div>체크인 시간, 체크아웃 시간</div>
						<div>태그</div>
						<div>조인한 캠핑로그 출력</div>
						<div
							style="display: flex; align-items: center; justify-content: space-between;">
							<div style="font-size: 1.1rem; font-weight: bold; margin: 25px 0">캠핑로그</div>
							<div>
								포토 로그만 보기
								<button></button>
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