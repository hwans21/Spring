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
			<th>작성자</th>
			<th>제목</th>
		</thead>
		<tbody>
			<c:forEach var="art" items="${articles }" varStatus="artNum">
				<tr>
					<td>${artNum.index+1 }</td>
					<td>${art.writer }</td>
					<td>
						<a href="<c:url value='/board/content?bId=${artNum.index+1 }'/>">${art.title }</a>
					</td>
				</tr>

			</c:forEach>

		</tbody>
	</table>
</body>
</html>