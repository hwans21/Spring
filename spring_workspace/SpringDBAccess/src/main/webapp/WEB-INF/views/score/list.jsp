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
	
	<h2>학생들의 전체 성적 조회</h2>
	
	<!-- forEach태그에서 varStatus를 사용하면 반복문의 목록수나 목록의 현재 index,
	count 등의 위치값을 사용할 수 있습니다.
	 -->
	<c:forEach var="stu" items="${sList }" varStatus="stuNum">
		<p>
			학번: ${stu.stuId}, 이름:${stu.stuName }, 국어: ${stu.kor },영어: ${stu.eng }, 
			수학: ${stu.math }, 총점: ${stu.total}, 평균: ${stu.average }
			<a href="<c:url value='/score/delete?stuNum=${stu.stuId }' />">[삭제]</a>
		</p>
	
	</c:forEach>
	
	<a href="<c:url value= '/score/register' />">다른 점수 등록하기</a>
<%-- 	<p style="color: red">
		${param.msg }
		${msg }
	</p> --%>
	<script type="text/javascript">
		const msg = "${msg}"
		if(msg=== "delSuccess"){
			alert("삭제가 완료되었습니다.");
		}
	</script>
</body>
</html>