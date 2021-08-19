<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<section>
    <!--Toggleable / Dynamic Tabs긁어옴-->
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-10 col-lg-9 myInfo">
                <div class="titlebox">
                    MEMBER INFO
                </div>

                <ul class="nav nav-tabs tabs-style">
                    <li class="active"><a data-toggle="tab" href="#info">내정보</a></li>
                    <li><a data-toggle="tab" href="#myBoard">내글</a></li>
                    <li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
                </ul>
                <div class="tab-content">
                    <div id="info" class="tab-pane fade in active">

                        <p>*표시는 필수 입력 표시입니다</p>
                        <form method="POST" action="<c:url value='/user/userMyPage' />" id="userInfoForm">
                            <table class="table">
                                <tbody class="m-control">
                                    <tr>
                                        <td class="m-title">*ID</td>
                                        <td><input name="userId" id="userId" class="form-control input-sm" value="${userInfo.userId }"
                                                readonly></td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*이름</td>
                                        <td><input name="userName" id="userName" class="form-control input-sm"
                                                value="${userInfo.userName }" readonly></td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*비밀번호</td>
                                        <td><input  name="userPw" type="password" id="userPw" class="form-control input-sm"></td>
                                        <td><span id="pwMsg"></span></td>

                                    </tr>
                                    <tr>
                                        <td class="m-title">*비밀번호확인</td>
                                        <td><input name="pwCheck" type="password" id="pwCheck" class="form-control input-sm"></td>
                                        <td><span id="pwChkMsg"></span></td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*E-mail</td>
                                        <td>
                                            <input  name="userEmail1" id="userEmail1" class="form-control input-sm"
                                                value="${userInfo.userEmail1 }">@
                                            <select name="userEmail2" id="userEmail2" class="form-control input-sm sel">
                                                <option ${userInfo.userEmail2=='@naver.com' ? 'selected' :'' } value="@naver.com">naver.com
                                                </option>
                                                <option ${userInfo.userEmail2=='@gmail.com' ? 'selected' :'' } value="@gmail.com">gmail.com
                                                </option>
                                                <option ${userInfo.userEmail2=='@daum.net' ? 'selected' :'' } value="@daum.net">daum.net
                                                </option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*휴대폰</td>
                                        <td>
                                            <select name="userPhone1" id="userPhone1" class="form-control input-sm sel">
                                                <option ${userInfo.userPhone1=='010' ? 'selected' : '' }>010</option>
                                                <option ${userInfo.userPhone1=='011' ? 'selected' : '' }>011</option>
                                                <option ${userInfo.userPhone1=='017' ? 'selected' : '' }>017</option>
                                                <option ${userInfo.userPhone1=='018' ? 'selected' : '' }>018</option>
                                            </select>
                                            <input  name="userPhone2" id="userPhone2" class="form-control input-sm"
                                                value="${userInfo.userPhone2 }">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*우편번호</td>
                                        <td><input name="addrZipNum" id="addrZipNum" class="form-control input-sm"
                                                value="${userInfo.addrZipNum }">
                                            <button type="button" class="btn btn-primary" id="addBtn" onclick="goPopup()">주소검색</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*주소</td>
                                        <td><input name="addrBasic" id="addrBasic" class="form-control input-sm add"
                                                value="${userInfo.addrBasic }"></td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*상세주소</td>
                                        <td><input name="addrDetail" id="addrDetail" class="form-control input-sm add"
                                                value="${userInfo.addrDetail }"></td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>

                        <div class="titlefoot">
                            <button id="modifyBtn" class="btn">수정</button>
                            <button class="btn">목록</button>
                        </div>
                    </div>

                    <!-- 첫번째 토글 끝 (내 정보, 내가 쓴 글들을 탭으로 관리) -->
                    <div id="myBoard" class="tab-pane fade">
                        <p>*내 게시글 관리</p>
                        <form>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td>번호</td>
                                        <td>제목</td>
                                        <td>작성일</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="vo" items="${userInfo.userBoardList }">
                                        <tr>
                                            <td>${vo.bno }</td>
                                            <td><a href="<c:url value='/freeBoard/freeDetail?bno=${vo.bno }' />">${vo.title
                                                    }</a></td>
                                            <td>${vo.regdate }</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </form>
                    </div>
                    <!-- 두번째 토글 끝 -->
                    <div id="menu2" class="tab-pane fade">
                        <h3>Menu 2</h3>
                        <p>Some content in menu 2.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="../include/footer.jsp" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    var regex = /^[A-Za-z0-9+]{8,16}$/; //비밀번호 정규표현식
    let bpw = false;
    let bpc = false;
    $('#userPw').keyup(function(){
        if(regex.test($('#userPw').val())){
            $('#pwMsg').html('V');
            bpw = true;
        } else {
            $('#pwMsg').html('X');
            bpw = false;

        }
    });
    $('#pwCheck').keyup(function(){
        if($('#userPw').val() === $('#pwCheck').val()){
            $('#pwChkMsg').html('V');
            bpc = true;

        } else {
            $('#pwChkMsg').html('X');
            bpc = false;

        }
    });    

    $('#modifyBtn').click(function () {
        if ($('#userPw').val() === '') {
            alert('비밀번호를 입력해주세요');
        } else if ($('#pwCheck').val() === '') {
            alert('비밀번호확인을 입력해주세요');
        } else if ($('#userEmail1').val() === '') {
            alert('이메일을 입력해주세요');
        }  else if ($('#userPhone2').val() === '') {
            alert('전화번호를 입력해주세요');
        } else if ($('#addrZipNum').val() === '') {
            alert('주소를 입력해주세요');
        } else if ($('#addrBasic').val() === '') {
            alert('주소를 입력해주세요');
        } else if ($('#addrDetail').val() === '') {
            alert('주소를 입력해주세요');
        } else if(!bpw || !bpc){
            alert('비밀번호 규칙에 어긋나거나 비밀번호 확인이 잘못되었습니다.')
        } else{
            $('#userInfoForm').submit();
        }

    }); //수정버튼 이벤트 끝

    function goPopup(){
	    	new daum.Postcode({
		        oncomplete: function(data) {
		        	// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수

	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }

	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    // document.getElementById("sample6_extraAddress").value = extraAddr;
	                
	                } else {
	                    //document.getElementById("sample6_extraAddress").value = '';
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('addrZipNum').value = data.zonecode;
	                document.getElementById("addrBasic").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("addrDetail").focus();
	            }
		        
	    	}).open();
    		
    	}
</script>