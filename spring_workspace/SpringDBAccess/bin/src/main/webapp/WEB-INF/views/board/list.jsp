<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h2>게시판입니다.</h2>
	<table border="1">
		<thead>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>비고</th>
		</thead>
		<tbody>
			<c:forEach var="art" items="${articles }" varStatus="artNum">
				<tr>
					<td>${art.boardNo }</td>
					<td>
						<a href="<c:url value='/board/content?bId=${art.boardNo }'/>">${art.title }</a>
					</td>
					<td>${art.writer }</td>
					<td><a href="<c:url value='/board/delete?bId=${art.boardNo  }' />">[삭제]</a></td>
				</tr>

			</c:forEach>

		</tbody>
	</table>

	<br>

	<form action="<c:url value='/board/searchList' />">

		<input type="text" name="keyword" placeholder="작성자 이름을 입력하세요.">
		<input type="submit" value="검색">
	</form>

	<a href="<c:url value='/board/write'/>">게시물 작성하기</a>
</body>

</html>