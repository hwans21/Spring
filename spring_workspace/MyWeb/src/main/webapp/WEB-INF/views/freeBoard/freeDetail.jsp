<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp" %>
<section>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-md-9 write-wrap">
                <div class="titlebox">
                    <p>상세보기</p>
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
                        <input class="form-control" name='writer' value="${art.writer }" readonly>
                    </div>
                    <div class="form-group">
                        <label>제목</label>
                        <input class="form-control" name='title' value="${art.title }" readonly>
                    </div>

                    <div class="form-group">
                        <label>내용</label>
                        <textarea class="form-control" rows="10" name='content' readonly>${art.content }</textarea>
                    </div>

                    <button type="button" class="btn btn-primary"
                        onclick="location.href='<c:url value="/freeBoard/freeModify?bno=${art.bno}" />'">변경</button>
                    <button type="button" class="btn btn-dark"
                        onclick="location.href='<c:url value="/freeBoard/freeList"/>'">목록 </button> </form> </div>
                        </div> </div> </section> <section style="margin-top: 80px;">
                        <div class="container">
                            <div class="row">
                                <div class="col-xs-12 col-md-9 write-wrap">
                                    <form class="reply-wrap">
                                        <div class="reply-image">
                                            <img src="../resources/img/profile.png">
                                        </div>
                                        <!--form-control은 부트스트랩의 클래스입니다-->
                                        <div class="reply-content">
                                            <textarea class="form-control" rows="3" id="reply"></textarea>
                                            <div class="reply-group">
                                                <div class="reply-input">
                                                    <input type="text" class="form-control" placeholder="이름"
                                                        id="replyId">
                                                    <input type="password" class="form-control" placeholder="비밀번호"
                                                        id="replyPw">
                                                </div>

                                                <button type="button" class="right btn btn-info"
                                                    id="replyRegist">등록하기</button>
                                            </div>

                                        </div>
                                    </form>
									
                                    <!--여기에접근 반복-->
                                    <div id="replyList"></div>
                                        <!-- <div class='reply-wrap'>
                                            <div class='reply-image'>
                                                <img src='../resources/img/profile.png'>
                                            </div>
                                            <div class='reply-content'>
                                                <div class='reply-group'>
                                                    <strong class='left'>honggildong</strong>
                                                    <small class='left'>2019/12/10</small>
                                                    <a href='#' class='right'><span
                                                            class='glyphicon glyphicon-pencil'></span>수정</a>
                                                    <a href='#' class='right'><span
                                                            class='glyphicon glyphicon-remove'></span>삭제</a>
                                                </div>
                                                <p class='clearfix'>여기는 댓글영역</p>
                                            </div>
                                        </div>
                                    </div> -->
                                </div>
                            </div>
                        </div>
</section>

<!-- 모달 -->
<div class="modal fade" id="replyModal" role="dialog">
    <div class="modal-dialog modal-md">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">닫기</button>
                <h4 class="modal-title">댓글수정</h4>
            </div>
            <div class="modal-body">
                <!-- 수정폼 id값을 확인하세요-->
                <div class="reply-content">
                    <textarea class="form-control" rows="4" id="modalReply" placeholder="내용입력"></textarea>
                    <div class="reply-group">
                        <div class="reply-input">
                            <input type="hidden" id="modalRno">
                            <input type="password" class="form-control" placeholder="비밀번호" id="modalPw">
                        </div>
                        <button class="right btn btn-info" id="modalModBtn">수정하기</button>
                        <button class="right btn btn-info" id="modalDelBtn">삭제하기</button>
                    </div>
                </div>
                <!-- 수정폼끝 -->
            </div>
        </div>
    </div>
</div>
<%@ include file="../include/footer.jsp" %>
<script>
    const msg = "${msg}"
    if (msg === 'updateSuccess') {
        alert("게시글 수정이 정상 처리되었습니다.");
    }

    $(document).ready(function () {
        $('#replyRegist').click(function () {
            /*
            	댓글을 등록하려면 게시글 번호도 보내주셔야 합니다.
            	댓글 내용, 작성자, 댓글 비밀번호, 게시글 번호를 
            	json 표기 방법으로 하나로 모아서 전달해 주시면 됩니다.
            	비동기 통시느올 댓글 삽입을 처리해 주시고,
            	console.log를 통해 '댓글 등록 완료!'를 확인하시고
            	실제 DB에 댓글이 추가되는지도 확인해주세요
            	
            */
            const bno = '${art.bno}'; //컨트롤러에서 넘어온 게시글번호
            const reply = $('#reply').val(); // 댓글 내용
            const replyId = $('#replyId').val(); // 댓글 아이디
            const replyPw = $('#replyPw').val(); // 뎃글 비번

            if (reply === '' || replyId === '' || replyPw === '') {
                alert('이름, 비밀번호, 내용을 입력하세요!');
                return;
            }


            $.ajax({
                type: "POST",
                url: "<c:url value='/reply/replyRegist' />",
                headers: {
                    "Content-Type": "application/json"
                },
                dataType: "text", //서버로부터 어떤 형식으로 받을지(생략가능)
                data: JSON.stringify({
                    "bno": bno,
                    "reply": reply,
                    "replyId": replyId,
                    "replyPw": replyPw
                }),
                success: function (data) {
                    console.log('통신성공!' + data);
                    $('#reply').val('');
                    $('#replyId').val('');
                    $('#replyPw').val('');
                    getList(true); // 등록 성공 후 댓글 목록 함수를 호출해서 비동기식으로 목록표현.  
                },
                error: function () {
                    alert('등록에 실패했습니다. 관리자에게 문의하세요');
                }
            }); //댓글 등록 비동기 통신 끝
        }); //댓글 등록 이벤트 끝

        //목록요청
        let strAdd = ""; //화면에 그려넣을 태그를 문자열의 형태로 추가할 변수
        getList(true); // 상세화면 진입시 리스트 목록을 가져옴
        
        
      //화면을 리셋할 것인지의 여부를 bool타입의 reset변수로 받겠다.
      //(댓글이 계속 밑에 쌓여요 페이지가 그대로 머무니까)
        function getList(reset) { 
            const bno = '${art.bno}'; //게시글 번호
            //getJSON 함수를 통해 JSON형식의 파일을 읽어올 수 있다.
            //get방식의 요청을 통해 서버로부터 받은 JSON 데이터를 로드한다.
            //$.getJSON(url,[DATA],[통신 성공 여부])
            $.getJSON(
                "<c:url value='/reply/getList/${art.bno}' />",
                function (data) {
                    console.log(data);
                    //insert, update, delete작업 뒤에는 
                    // 댓글을 누적하고 있는 strAdd변수를 초기화
                    if(reset === true){
                    	strAdd = '';
                    }
                    for(let i=0;i<data.length;i++){
                        strAdd += "<div class='reply-wrap' style='display:none;'>";
                        strAdd += "<div class='reply-image'>";
                        strAdd += "<img src='../resources/img/profile.png'>";
                        strAdd += "</div>";
                        strAdd += "<div class='reply-content'>";
                        strAdd += "<div class='reply-group'>";
                        strAdd += "<strong class='left'>"+ data[i].replyId +"</strong>"; 
                		strAdd += "<small class='left'>"+ data[i].replyDate +"</small>"
                        strAdd += "<a href='"+ data[i].rno +"' class='right replyModify'><span class='glyphicon glyphicon-pencil'></span>수정</a>";
                        strAdd += "<a href='"+ data[i].rno +"' class='right replyDelete'><span class='glyphicon glyphicon-remove'></span>삭제</a>";
                        strAdd += "</div>";
                        strAdd += "<p class='clearfix'>"+ data[i].reply +"</p>";
                        strAdd += "</div>";
                        strAdd += "</div>";
                    }
                    $('#replyList').html(strAdd); // replyList영역에 문자열 형식으로 모든 댓글을 추가.
                    $('.reply-wrap').fadeIn(500); //화면에 댓글ㅇ을 표현할 때 reply-wrap의 display를 none으로 해두고
                    							  // jquery fadeIn 함수로 서서히 드러나도록 처리
                }

            ); //end getJSON
        } //end getlist
    }); //end jquery
</script>