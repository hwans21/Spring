<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
<style>
header.masthead {
	
	display: none;
}	
</style>
<br/><br/>
<div class="container">

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header text-white" style="background-color: #643691;">??번 게시물 내용</div>
      <div class="card-body">

        
          <div class="form-group">
            <label>작성자</label>
            <input type="text" class="form-control" name='writer' value="#" readonly>
          </div>
          
          <div class="form-group">
            <label>제목</label>
            <input type="text" class="form-control" name='title' value="#" readonly>
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name='content' readonly>###</textarea>
          </div>

        <form role="form" action="#" method="post">
         
	          <input class="btn" type="button" value="목록"
			style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;
	          <input class="btn" type="button" value="수정"
			style="background-color: orange; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;
	          <input class="btn" type="button" value="삭제" onclick="return confirm('정말로 삭제하시겠습니까?')"
			style="background-color: red; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;
       
       </form>



      </div>
    </div>
  </div>
</div>
</div>
<jsp:include page="../include/footer.jsp" />