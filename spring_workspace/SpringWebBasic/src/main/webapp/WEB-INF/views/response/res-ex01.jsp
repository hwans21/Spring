<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Model 객체에 대해서 알아보기</h2>
	<a href="/basic/response/test?age=30">테스트1 페이지로~</a>
	
	<a href="/basic/response/test3">테스트3 페이지로~</a>
	
	<hr>
	
	<form action="/basic/response/test2" >
		아이디: <input type="text" name="userId"><br>
		이름: <input type="text" name="userName"><br>
		<input type="submit" value="확인">
	</form>
	
</body>
</html>