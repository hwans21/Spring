<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${bId }번 게시글 수정</h2>
	
	<form action="<c:url value='/board/modify' />" method="post">
		<input type="hidden" name="bId" value="${bId }">
		<p>
			# 작성자  : <input type="text" name="writer" value="${content.writer }"> <br>
			# 제목  : <input type="text" name="title" value="${content.title }"> <br>
			# 내용  : <textarea rows="3" name="content">${content.content }</textarea> <br>
			<input type="submit" value="수정">
		</p>
	</form>
</body>
</html>