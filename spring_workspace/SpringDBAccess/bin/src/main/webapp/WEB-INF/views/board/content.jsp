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
    <h2>${content.boardNo }번 게시물 내용</h2>

    <p>
        # 작성자 : ${content.writer }<br>
        # 제목 : ${content.title } <br>
        # 내용 : <textarea rows="3" name="content"readonly>${content.content }</textarea> <br>
    </p>
    <a href="<c:url value='/board/list' />">글 목록으로</a>
    <a href="<c:url value='/board/modify?bId=${content.boardNo}' />">글 수정하기</a>
    <!-- 글 수정하기 화면으로 이동 요청 -->
</body>

</html>