<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>

</head>
<body>
	
	<div style="width: 840px; margin: 0 auto;">
		<p style="text-align: center">
			글쓰기
		</p>
		<form action="${pageContext.servletContext.contextPath }/board/write-handle">
			<table style="border-collapse: collapse; width: 100%">
				<tr>
					<td
						style="border: 1px solid #ccc; padding: 12px; text-align: center; background-color: #eee"><span
						style="color: red">*</span>주제선택</td>
						<td style="border: 1px solid #ccc; padding: 12px;">
						<select name="category">
						<option disabled selected>주제선택</option>
							<option>캠핑한컷</option>
							<option>캠핑톡톡</option>
							<option>궁금해요</option>
						</select>
					</td>
				</tr>			
				<!-- 궁금해요 category 분야 선택 있어야 함 -->					
				<tr>
					<td
						style="border: 1px solid #ccc; padding: 12px; text-align: center; background-color: #eee"><span
						style="color: red">*</span>작성자</td>
					<td style="border: 1px solid #ccc; padding: 12px;">${authUser.id}</td>
				</tr>
				
				<tr>
					<td
						style="border: 1px solid #ccc; padding: 12px; text-align: center; background-color: #eee"><span
						style="color: red">*</span>제목</td>
					<td style="border: 1px solid #ccc; padding: 12px;"><input
						name="title" type="text"
						style="padding: 6px 10px; width: 500px; border: 1px solid #ccc" /></td>
				</tr>
				<tr>
					<td style="border: 1px solid #ccc; padding: 12px;" colspan="2">
						<textarea name="body"
							style="height: 200px; resize : none; 
							width: 100%; box-sizing: border-box; padding: 6px 10px; border: 1px solid #ccc"></textarea>

					</td>
				</tr>
			</table>
			<div style="text-align: center; margin-top: 20px;">
				<button type="submit" style="padding: 10px 20px;">저장</button>
				<button type="reset" style="padding: 10px 20px;">취소</button>
			</div>
		</form>
	</div>
	
</body>
</html>