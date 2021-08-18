<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="../include/header.jsp" %>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7 col-xs-10 login-form">
                    <div class="titlebox">
                        로그인
                    </div>
                    <form action="<c:url value='/user/login' />" method="post" id="loginForm">
                        <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" name="userId" id="userId" placeholder="아이디">
                         </div>
                         <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">비밀번호</label>
                            <input type="password" class="form-control" name="userPw" id="userPw" placeholder="비밀번호">
                         </div>
                         <div class="form-group">
                            <button id="loginBtn" type="button" class="btn btn-info btn-block">로그인</button>
                            <button type="button" class="btn btn-primary btn-block">회원가입</button>
                         </div>
                    </form>                
                </div>
            </div>
        </div>
    </section>
    
    <%@ include file="../include/footer.jsp" %>
    
    <script>
       
    	const msg = '${msg}';
    	if(msg === 'joinSuccess') {
    		alert('회원가입 정상 처리되었습니다.');
    	} else if(msg === 'loginFail') {
    		alert('로그인 실패! 아이디와 비밀번호를 확인하세요!');
    	}
    	
    	$(function() {
			$('#loginBtn').click(function() {
				if($('#userId').val() === '') {
					alert('아이디를 적어야 로그인을 하죠~');
					return;
				} else if($('#userPw').val() === '') {
					alert('비밀번호를 작성을 하세요!');
					return;
				} else {
					$('#loginForm').submit();
				}
			});
		});
    	
    	
    </script>
    
    
    
    
    
    
    
    
    
    
    
