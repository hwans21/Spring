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
                        
                        <form>
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
                                <input class="form-control" name='writer' value="${art.writer }">
                            </div>    
                            <div class="form-group">
                                <label>제목</label>
                                <input class="form-control" name='title' value="${art.title }">
                            </div>

                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" rows="10" name='content'>${art.content }</textarea>
                            </div>

                            <button type="button" class="btn btn-dark" onclick="location.href='<c:url value="/freeBoard/freeList" />'">목록</button>    
                            <button type="button" class="btn btn-primary" id="modify-btn">변경</button>
                            <button type="button" class="btn btn-info" id="delete-btn">삭제</button>
                    </form>
                                    
                </div>
            </div>
        </div>
        </section>
        <script>
            const content = {
                "bno":$('button[name="bno"]').val(),
                "title":$('button[name="title"]').val(),
                "content":$('button[name="content"]').val(),
            }
            //start JQuery
            $(function() {
                
            }); //end JQuery

        </script>
      <%@ include file="../include/footer.jsp" %>
      