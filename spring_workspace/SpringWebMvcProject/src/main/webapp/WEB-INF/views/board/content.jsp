<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp" />
<style>
header.masthead {
	display: none;
}
</style>
<br />
<br />
<div class="container">

	<div class="row">
		<div class="col-lg-12">
			<div class="card">
				<div class="card-header text-white"
					style="background-color: #643691;">${article.boardNum }번게시물
					내용</div>
				<div class="card-body">


					<div class="form-group">
						<label>작성자</label> <input type="text" class="form-control"
							name='writer' value="${article.writer }" readonly>
					</div>

					<div class="form-group">
						<label>제목</label> <input type="text" class="form-control"
							name='title' value="${article.title }" readonly>
					</div>

					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="5" name='content' readonly>${article.content }</textarea>
					</div>

					<form id="formObj" role="form"
						action="<c:url value='/board/delete' />" method="post">
						<input type="hidden" name="boardNum" value="${article.boardNum }">
						<input type="hidden" name="page" value="${p.page }">
						<input type="hidden" name="countPerPage" value="${p.countPerPage }">
						
						
						<input id="list-btn" class="btn" type="button" value="목록"
							style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;
						<input id="modBtn" class="btn" type="button" value="수정"
							style="background-color: orange; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;
						<input id="delBtn" class="btn" type="submit" value="삭제"
							onclick="return confirm('정말로 삭제하시겠습니까?')"
							style="background-color: red; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;

					</form>



				</div>
			</div>
		</div>
	</div>
</div>
<script>
	//제이쿼리 시작
	$(document).ready(function() {
		// 목록 버튼 클릭 이벤트 처리
		$('#list-btn').click(function() {
			console.log('목록 버튼이 클릭됨!');
			location.href = '/board/list?page='+${p.page }+'&countPerPage='+${p.countPerPage };
		});
		const formElement = $('#formObj');

		//수정버튼 클릭 이벤트
		$('#modBtn').click(function() {
			formElement.attr('action', '/board/modify');
			formElement.attr('method', 'get')
			formElement.submit();
		});

	});
	//제이쿼리 끝
</script>
<jsp:include page="../include/footer.jsp" />