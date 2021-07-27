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
	
	<!-- 
		- /selectOne요청을 통해 해당 학번을 가진 학생의 성적정보를 조회하여
		search-result.jsp에 모든 학생의 정보를 적절하게 출력하세요(디자인 안해도 됨)
	 -->
	
	<form action="<c:url value='/score/selectOne' />" >
		<p>
			# 조회할 학번: <input type="text" name="stuNum" size="5">
			<input type="submit" value="학번">
		</p>
	</form>
	<p style="color: red">
		${msg }
	</p>
	<!-- 
		사용자가 입력한 학번의 학생이 없다면 "학번 정보가 없습니다." 메세지를 띄워보세요
	 -->
	
</body>
</html>