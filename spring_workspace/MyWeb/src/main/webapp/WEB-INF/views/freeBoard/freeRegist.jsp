<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<section>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 content-wrap">
				<div class="titlebox">
					<p>자유게시판</p>
				</div>
				<form action="<c:url value='/freeBoard/registForm' />" name="registForm" method="post">

					<table class="table">
						<tbody class="t-control">
							<tr>
								<td class="t-title">NAME</td>
								<td><input class="form-control input-sm" name="writer" value="${login.userId }" readonly></td>
							</tr>
							<tr>
								<td class="t-title">TITLE</td>
								<td><input class="form-control input-sm" name="title"></td>
							</tr>
							<tr>
								<td class="t-title">CONTENT</td>
								<td>
									<textarea class="form-control" rows="7" name="content"></textarea>
								</td>
							</tr>
						</tbody>
					</table>
				</form>

				<div class="titlefoot">
					<button class="btn" id="registBtn">등록</button>
					<button class="btn" id="listBtn">목록</button>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="../include/footer.jsp" %>

<script>
	//바닐라 형식
	const registBtn = document.getElementById('registBtn');
	registBtn.onclick = function () {
		//form태그는 document.폼 네임으로 바로 접근이 가능.
		if (document.registForm.writer.value === '') {
			alert('작성자는 필수 항목 입니다.');
			document.registForm.writer.focus();
			return; //이벤트 함수 강제 종료
		} else if (document.registForm.title.value === '') {
			alert('제목은 필수 항목입니다.');
			document.registForm.title.focus();
			return;
		} else if (document.registForm.content.value === '') {
			alert('내용은 필수 항목입니다.');
			document.registForm.content.focus();
			return;
		} else {
			document.registForm.submit();
		}
	}
	//제이쿼리 형식
	/*
	$(function () {
		$('#registBtn').click(function () {
			if($('input[name=writer]').val() === ''){

			}
		});
	});
	*/

	$('#listBtn').click(function(){
		if(confirm('목록으로 돌아가시겠습니까?')){
			location.href = '<c:url value="/freeBoard/freeList" />';
		} else {
			return;
		}
	});
</script>