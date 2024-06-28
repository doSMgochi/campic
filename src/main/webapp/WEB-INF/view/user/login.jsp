<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 | Campic</title>
<style>
body {
    margin: 0;
    padding: 0;
    background-color: #2c3e50; /* 남색 계열 배경 */
    color: #ecf0f1; /* 글씨는 밝은 색으로 */
}

.new-fixed-box {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    
}

.new-content-box {
    background-color: #34495e; /* 조금 더 밝은 남색 계열 */
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    width: 400px;
    max-width: 90%;
}

.new-board {
    margin-top: 20px;
}

.new-board-cates {
    text-align: center;
}

.login-header {
    margin-bottom: 20px;
    margin-left: 0px;
}

.login-header h2 {
    margin-bottom: 10px;
}

.highlight {
    color: hotpink;
}

.login-form-container {
    width: 40%;
    margin: 0 auto;
    border: 2px solid #ddd;
    padding: 30px;
    border-radius: 8px;
    background-color: #fff;
    color: #2c3e50;
    margin-left: 0px;
}

.form-group {
    margin-bottom: 15px;
}

.form-group input {
    width: calc(100% - 20px);
    padding: 10px;
    border: 1px solid #ecf0f1;
    border-radius: 4px;
    background-color: #ecf0f1;
    color: #2c3e50;
}

.btn-submit {
    padding: 10px;
    border: none;
    border-radius: 4px;
    background-color: #e74c3c;
    color: #ecf0f1;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.btn-submit:hover {
    background-color: #c0392b;
}

.signup-link {
    text-align: center;
    margin-top: 10px;
}

.signup-link a {
    color: #ecf0f1;
    text-decoration: none;
    transition: color 0.3s ease;
}

.signup-link a:hover {
    color: #e74c3c;
}

.new-fixed-footer {
    margin-top: 20px;
    text-align: center;
    color: #bdc3c7;
}

.new-fixed-footer a {
    color: #ecf0f1;
    text-decoration: none;
    margin: 0 10px;
    transition: color 0.3s ease;
}

.new-fixed-footer a:hover {
    color: #e74c3c;
}
</style>
</head>
<body>
	<div class="fixed-box new-fixed-box">
		<div class="content-box new-content-box">
			<div class="board new-board">
				<div class="board-cates new-board-cates">
				<div class="login-header">
					<div style="width: 840px;">
						<div style="text-align: left; ">
							<h2>로그인</h2>
                        <div>
                            회원서비스 &gt; <span class="highlight">로그인</span>
                        </div>
                    </div>
                    <div class="login-form-container">
                        <form action="${pageContext.servletContext.contextPath }/login-handle" method="post">
                            <div class="form-group">
                                <input type="text" name="id" placeholder="아이디를 입력해주세요" class="form-control" />
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" placeholder="비밀번호를 입력해주세요" class="form-control" />
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn-submit">로그인</button>
                            </div>
                        </form>
                        <p class="signup-link">
                            <a href="${pageContext.servletContext.contextPath }/signup">신규회원가입 바로가기</a>
                        </p>
                    </div>
							<div class="fixed-footer new-fixed-footer">
								<%@ include file="../inner-nav.jsp"%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
	</div>
</body>
</html>