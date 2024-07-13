<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/style.css" />
</head>
<body>

    <div class="button-container">
        <a href="${pageContext.servletContext.contextPath }"><button class="button-d button-large">
                <span class="material-symbols-rounded"> home </span><br /><small>홈</small>
            </button></a> 
            
            <a href="${pageContext.servletContext.contextPath }/search"><button class="button-d button-large">
                <span class="material-symbols-rounded"> search </span><br /><small>캠핑장 검색</small>
            </button></a>
            
            <a href="${pageContext.servletContext.contextPath }/product"><button class="button-d button-large">
                <span class="material-symbols-rounded"> storefront </span><br /><small>스토어</small>
            </button></a>
            <a href="${pageContext.servletContext.contextPath }/board"><button class="button-d button-large">
                <span class="material-symbols-rounded"> edit_square </span><br /><small>캠핑생활</small>
            </button></a>
            <a href="${pageContext.servletContext.contextPath }/mypage"><button class="button-d button-large">
                <span class="material-symbols-rounded"> person </span><br /><small>마이</small>
            </button></a>
    </div>

</body>
</html>