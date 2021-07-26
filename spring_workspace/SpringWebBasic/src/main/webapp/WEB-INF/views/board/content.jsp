<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <h2>콘텐츠 페이지 입니다.</h2>

    <p>
        # 작성자 : <input type="text" name="writer" readonly value="${content.writer }"><br>
        # 제목 : <input type="text" name="title" readonly value="${content.title }"> <br>
        # 내용 : <textarea rows="3" name="content"readonly>${content.content }</textarea> <br>
    </p>
</body>

</html>