<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<section>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-md-9 write-wrap">
                <div class="titlebox">
                    <p>수정하기</p>
                </div>

                <form method="post" id="formId">
                    <div>
                        <label>DATE</label>
                        <p>${art.updatedate == null ? art.regdate : art.updatedate }</p>
                    </div>
                    <div class="form-group">
                        <label>번호</label>
                        <input class="form-control" name='bno' value="${art.bno }" readonly>
                    </div>
                    <div class="form-group">
                        <label>작성자</label>
                        <input class="form-control" name='writer' value="${art.writer }" readonly>
                    </div>
                    <div class="form-group">
                        <label>제목</label>
                        <input class="form-control" name='title' value="${art.title }">
                    </div>

                    <div class="form-group">
                        <label>내용</label>
                        <textarea class="form-control" rows="10" name='content'>${art.content }</textarea>
                    </div>

                    <button type="button" class="btn btn-dark" id="listBtn">목록</button>
                    <button type="button" class="btn btn-primary" id="modifyBtn">변경</button>
                    <button type="button" class="btn btn-info" id="deleteBtn">삭제</button>
                </form>

            </div>
        </div>
    </div>
</section>
<script>
    $(function(){ //start Jquery
        //목록이동 처리
        $('#listBtn').click(function(){
            if(confirm('게시판 목록으로 이동하시겠습니까?')){
                location.href='<c:url value="/freeBoard/freeList"/>'
            }
        });
        
        //수정 버튼 이벤트 처리
        /* 
            1. 폼 데이터가 공백인지 확인 처리
            2. 공백이 없으면 Controller에 freeUpdate 요청으로 데이터를 전송
            3. 컨트롤러에서 처리가 완료된 후에 "게시글 수정이 정상 처리되었습니다."라는 알림창이
            글 상세보기 페이지에서 처리될 수 있도록 해 주세요.
        */
        $('#modifyBtn').click(function(){
            if($('input[name=writer]').val() === ''){
                alert('작성자는 필수 항목입니다.');
                $('input[name=writer]').focus();
                return;
            } else if($('input[name=title]').val() === ''){
                alert('제목은 필수 항목입니다.');
                $('input[name=title]').focus();
                return;
            } else if($('textarea[name=content]').val() === ''){
                alert('내용은 필수 항목입니다.');
                $('textarea[name=content]').focus();
                return;
            } else {
                $('#formId').attr("action","<c:url value='/freeBoard/freeUpdate'/>");
                $('#formId').submit();
            }
        });

        //삭제 버튼 이벤트 처리
        /*
            삭제같은 경우에는 번호가 노출되면 안되기 때문에 
            form태그를 이용해서 데이터를 전송시키세요.
            action 속성을 delete에 맞게 바꿔서 전송하시면 됩니다.
        */
       $('#deleteBtn').click(function(){
           if(confirm('정말로 삭제하시겠습니까?')){
               $('#formId').attr("action","<c:url value='/freeBoard/freeDelete'/>")
               /*바닐라문법
               document.getE~id('formId').action="~~~"
               document.getE~id('formId').setAttribute('action','~~~~');

               */
               $('#formId').submit();
           }
       });
    }); //end Jquery
    
    

</script>
<%@ include file="../include/footer.jsp" %>