<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../include/header.jsp" %>
<section>
    <div class="container-fluid">
        <div class="row">
            <!--lg에서 9그리드, xs에서 전체그리드-->
            <div class="col-lg-9 col-xs-12 board-table">
                <div class="titlebox">
                    <p>자유게시판</p>
                </div>
                <hr>

                <!--form select를 가져온다 -->
                <form>
                    <div class="search-wrap">
                    	<input type="text" type="hidden"><!-- 엔터키 입력시 새로고침 방지 -->

                        <button id="searchBtn" type="button" class="btn btn-info search-btn">검색</button>
                        <input id="searchInp" type="text" class="form-control search-input" value="${pc.page.keyword }">
                        <select class="form-control search-select">
                            <option value="title" ${pc.page.condition=='title'? 'selected':'' }>제목</option>
                            <option value="content" ${pc.page.condition=='content'? 'selected':'' }>내용</option>
                            <option value="writer" ${pc.page.condition=='writer'? 'selected':'' }>작성자</option>
                            <option value="titleContent" ${pc.page.condition=='titleContent'? 'selected':'' }>제목+내용</option>
                        </select>
                    </div>
                </form>

                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th class="board-title">제목</th>
                            <th>작성자</th>
                            <th>등록일</th>
                            <th>수정일</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="art" items="${list }">
                            <tr>
                                <td>${art.bno }</td>
                                <td><a href="<c:url value='/freeBoard/freeDetail?bno=${art.bno}&pageNum=${pc.page.pageNum}&keyword=${pc.page.keyword}&condition=${pc.page.condition}' />">${art.title }</a>
                                	<c:if test="${art.newMark }">
	                                	<span> <img src="<c:url value='/img/new.gif' />" alt="new"> </span>                                	
                                	</c:if>
                                </td>
                                <td>${art.writer }</td>
                                <td>
                                    <fmt:formatDate value="${art.regdate }" pattern="YY.MM.dd HH:mm" />
                                </td>
                                <td>
                                    <fmt:formatDate value="${art.updatedate }" pattern="YY.MM.dd HH:mm" />
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>

                </table>


                <!--페이지 네이션을 가져옴-->
                <form id="pageForm" action="<c:url value='/freeBoard/freeList' />" method="get">
                    <input type="hidden" name="pageNum" value="${pc.page.pageNum }">
                    <input type="hidden" name="keyword" value="${pc.page.keyword }">
                    <input type="hidden" name="condition" value="${pc.page.condition }">
                    <div class="text-center">
                        <hr>
                        <ul class="pagination pagination-sm" id="pagination">
                        	<c:if test="${pc.prev }">
	                            <li><a id="prev" href="#" data-pageNum="${pc.begin-1 }">이전</a></li>
                        	</c:if>
		                        <c:forEach var="i" begin="${pc.begin }" end="${pc.end }" step="1">
		                        	
		                        	
		                        	<li ${pc.page.pageNum == i ? 'class="active"':''}><a class="num" href="#" data-pageNum="${i }">${i }</a></li>
		                        	
		                        </c:forEach>
                            <!-- <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li> -->
                            <c:if test="${pc.next }">
	                            <li><a id="next" href="#" data-pageNum="${pc.end+1 }">다음</a></li>                    
                            </c:if>
                        
                        </ul>
                        <button type="button" class="btn btn-info"
                            onclick="location.href='<c:url value="/freeBoard/freeRegist" />'">글쓰기</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</section>

<%@ include file="../include/footer.jsp" %>
<script>
    const msg = "${msg}"
    if(msg !== ''){
        alert(msg);
    }
    
    //
    $(function() {
    	
    	
        $('#pageForm a').click(function(e){
            e.preventDefault();
        });
        document.getElementById('pagination').onclick = function(e){
        	$('input[name=pageNum]').attr('value', e.target.dataset.pagenum);
        	$('input[name=condition]').attr('value', $('select').val());
        	$('input[name=keyword]').attr('value', $('#searchInp').val());
            $('#pageForm').submit();
        };
        // $('#next').click(function(){
        // 	$('input[name=pageNum]').attr('value', ${pc.end+1 });
        // 	$('input[name=condition]').attr('value', $('select').val());
        // 	$('input[name=keyword]').attr('value', $('#searchInp').val());
        //     $('#pageForm').submit();
        // });
        // $('.num').click(function(){
        //     $('input[name=pageNum]').attr('value', $(this).html());
        //     $('input[name=condition]').attr('value', $('select').val());
        // 	$('input[name=keyword]').attr('value', $('#searchInp').val());
        //     $('#pageForm').submit();
        // });
        // $('#searchBtn').click(function() {
        // 	$('input[name=pageNum]').attr('value', 1);
        //     $('input[name=condition]').attr('value', $('select').val());
        // 	$('input[name=keyword]').attr('value', $('#searchInp').val());
        // 	$('#pageForm').submit();
        // });
        // $('#searchInp').keydown(function(key) {
        // 	if(key.keyCode === 13){
        // 		$('#searchBtn').click();
        // 	}
        // });

    })
</script>