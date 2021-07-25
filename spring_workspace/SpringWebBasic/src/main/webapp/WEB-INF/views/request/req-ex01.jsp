<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Request컨트롤러를 이용한 요청 처리 작업</h2>
	<p>컨트롤러 테스트 중입니다~</p>
	<form action="/basic/request/basic01">
		<input type="submit" value="GET요청!">
	</form>
	
	<form action="/basic/request/basic01" method="post">
		<input type="submit" value="POST요청!">
	</form>
</body>
</html>