<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		form태그의 action을 작성하지 않으면
		마지막 요청 url(현재 화면을 보기위해 요청한 url주소)
		과 동일하게 서버로 요청이 들어갑니다.
		
	 -->
	<form method="post">
		<p>
			# ID : <input type="text" name="userId" size="10"> <br>
			# 비밀번호 : <input type="password" name="userPw" size="10"> <br>
			# 비밀번호확인 : <input type="password" name="userPwChk" size="10"> <br>
			<input type="submit" value="로그인"> <br>
		</p>
	</form>
	
	<p style="color: red">
		<%-- ${param.msg } --%>
		${msg }
	</p>
</body>
</html>