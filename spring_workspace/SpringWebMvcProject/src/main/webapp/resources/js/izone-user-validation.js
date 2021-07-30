$(function(){
	var getIdCheck= RegExp(/^[a-zA-Z0-9]{4,14}$/);
	var getPwCheck= RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
	var getName= RegExp(/^[가-힣]+$/);
	var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
	var chk1 = false, chk2 = false, chk3 = false, chk4 = false, chk5 = false;
	
	//회원가입 검증~~
	//ID 입력값 검증.
	$('#user_id').on('keyup', function() {
		if($("#user_id").val() == ""){
			$('#user_id').css("background-color", "pink");
			$('#idChk').html('<b style="font-size:16px;color:red;">[아이디는 필수 정보에요!]</b>');
			chk1 = false;
		}
		
		//아이디 유효성검사
		else if(!getIdCheck.test($("#user_id").val())){
			$('#user_id').css("background-color", "pink");
			$('#idChk').html('<b style="font-size:16px;color:red;">[영문자,숫자 4-14자로 입력하라구~]</b>');	  
			chk1 = false;
		} 
		//ID 중복확인 비동기 처리
		else {
			var userId = $('#user_id').val();
			$.ajax({
				type: "POST",
				url: "/user/confirm-id",
				data: userId,
				dataType : "json",
	            contentType: "application/json; charset=UTF-8",
				success: function(data) {
					if(data.cnt == 0) {
						$('#user_id').css("background-color", "aqua");
						$('#idChk').html('<b style="font-size:16px;color:green;">[ID 사용 가능!]</b>');
						chk1 = true;
					} else {
						$('#user_id').css("background-color", "pink");
						$('#idChk').html('<b style="font-size:16px;color:red;">[중복된 ID입니다!]</b>');
						chk1 = false;
					}
				},
				error : function(error) {
	                
	                console.log("error : " + error);
	            }
			});
		}
	});
	
	//패스워드 입력값 검증.
	$('#password').on('keyup', function() {
		//비밀번호 공백 확인
		if($("#password").val() == ""){
		    $('#password').css("background-color", "pink");
			$('#pwChk').html('<b style="font-size:16px;color:red;">[패스워드는 필수정보에요!]</b>');
			chk2 = false;
		}		         
		//비밀번호 유효성검사
		else if(!getPwCheck.test($("#password").val()) || $("#password").val().length < 8){
		    $('#password').css("background-color", "pink");
			$('#pwChk').html('<b style="font-size:16px;color:red;">[특수문자 포함 8자이상으루다가~]</b>');
			chk2 = false;
		} else {
			$('#password').css("background-color", "aqua");
			$('#pwChk').html('<b style="font-size:16px;color:green;">[참 잘했어요~♡]</b>');
			chk2 = true;
		}
		
	});
	
	//패스워드 확인란 입력값 검증.
	$('#password_check').on('keyup', function() {
		//비밀번호 확인란 공백 확인
		if($("#password_check").val() == ""){
		    $('#password_check').css("background-color", "pink");
			$('#pwChk2').html('<b style="font-size:16px;color:red;">[패스워드확인은 필수정보에요!]</b>');
			chk3 = false;
		}		         
		//비밀번호 확인란 유효성검사
		else if($("#password").val() != $("#password_check").val()){
		    $('#password_check').css("background-color", "pink");
			$('#pwChk2').html('<b style="font-size:16px;color:red;">[위에랑 똑같이 제대로 써!!]</b>');
			chk3 = false;
		} else {
			$('#password_check').css("background-color", "aqua");
			$('#pwChk2').html('<b style="font-size:16px;color:green;">[참 잘했어요~♡]</b>');
			chk3 = true;
		}
		
	});
	
	//이름 입력값 검증.
	$('#user_name').on('keyup', function() {
		//이름값 공백 확인
		if($("#user_name").val() == ""){
		    $('#user_name').css("background-color", "pink");
			$('#nameChk').html('<b style="font-size:16px;color:red;">[이름은 필수정보에요!]</b>');
			chk4 = false;
		}		         
		//이름값 유효성검사
		else if(!getName.test($("#user_name").val())){
		    $('#user_name').css("background-color", "pink");
			$('#nameChk').html('<b style="font-size:16px;color:red;">[이름은 한글로 쓰세용~]</b>');
			chk4 = false;
		} else {
			$('#user_name').css("background-color", "aqua");
			$('#nameChk').html('<b style="font-size:16px;color:green;">[참 잘했어요~♡]</b>');
			chk4 = true;
		}
		
	});
	
	//이메일 입력값 검증.
	$('#user_email').on('keyup', function() {
		//이메일값 공백 확인
		if($("#user_email").val() == ""){
		    $('#user_email').css("background-color", "pink");
			$('#emailChk').html('<b style="font-size:16px;color:red;">[이메일은 필수정보에요!]</b>');
			chk5 = false;
		}		         
		//이메일값 유효성검사
		else if(!getMail.test($("#user_email").val())){
		    $('#user_email').css("background-color", "pink");
			$('#emailChk').html('<b style="font-size:16px;color:red;">[이메일 형식 몰라?]</b>');
			chk5 = false;
		} else {
			//이메일 중복확인 비동기 처리
			var userEmail = $('#user_email').val();
			$.ajax({
				type: "POST",
				url: "/user/confirm-email",
				data: userEmail,
				dataType : "json",
	            contentType: "application/json; charset=UTF-8",
				success: function(data) {
					if(data.cnt == 0) {
						$('#user_email').css("background-color", "aqua");
						$('#emailChk').html('<b style="font-size:16px;color:green;">[Email 사용 가능!]</b>');
						chk5 = true;
					} else {
						$('#user_email').css("background-color", "pink");
						$('#emailChk').html('<b style="font-size:16px;color:red;">[중복된 Email입니다!]</b>');
						chk5 = false;
					}
				},
				error : function(error) {
	                
	                console.log("error : " + error);
	            }
			});
			
		}
		
	});
	
	$('#signup-btn').click(function(e) {
		if(chk1 && chk2 && chk3 && chk4 && chk5) {
			var answer = confirm('회원가입을 완료하시겠습니까?');
			if(answer) {
				e.preventDefault();
				$('#signUpForm').submit();
			} 
		} else {
			alert('입력정보를 다시 확인하세요.');			
		}
	});
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	//로그인 검증~~
	//ID 입력값 검증.
	$('#signInId').on('keyup', function() {
		if($("#signInId").val() == ""){
			$('#signInId').css("background-color", "pink");
			$('#idCheck').html('<b style="font-size:16px;color:red;">[아이디는 필수 정보에요!]</b>');
			chk1 = false;
		}		
		
		//아이디 유효성검사
		else if(!getIdCheck.test($("#signInId").val())){
			$('#signInId').css("background-color", "pink");
			$('#idCheck').html('<b style="font-size:16px;color:red;">[영문자,숫자 4-14자로 입력하라구~]</b>');	  
			chk1 = false;
		} else {
			$('#signInId').css("background-color", "aqua");
			$('#idCheck').html('<b style="font-size:16px;color:green;">[참 잘했어요~♡]</b>');
			chk1 = true;
		}
	});
	
	//패스워드 입력값 검증.
	$('#signInPw').on('keyup', function() {
		//비밀번호 공백 확인
		if($("#signInPw").val() == ""){
		    $('#signInPw').css("background-color", "pink");
			$('#pwCheck').html('<b style="font-size:16px;color:red;">[패스워드는 필수정보에요!]</b>');
			chk2 = false;
		}		         
		//비밀번호 유효성검사
		else if(!getPwCheck.test($("#signInPw").val()) || $("#signInPw").val().length < 8){
		    $('#signInPw').css("background-color", "pink");
			$('#pwCheck').html('<b style="font-size:16px;color:red;">[특수문자 포함 8자이상으루다가~]</b>');
			chk2 = false;
		} else {
			$('#signInPw').css("background-color", "aqua");
			$('#pwCheck').html('<b style="font-size:16px;color:green;">[참 잘했어요~♡]</b>');
			chk2 = true;
		}
		
	});
	
	$('#signIn-btn').click(function(e) {
		if(chk1 && chk2) {	
			var id = $('#signInId').val();
			var pw = $('#signInPw').val();
			console.log(id);
			console.log(pw);
			var userInfo = {
					"userId": id,
					"userPw": pw
			};
			$.ajax({
				type: "GET",
				url: "/user/login",
				data: userInfo,
				dataType : "json",
	            contentType: "application/json; charset=UTF-8",
				success: function(data) {
					console.log(data.result);
					if(data.result == -1) {
						$('#signInId').css("background-color", "pink");
						$('#idCheck').html('<b style="font-size:16px;color:red;">[회원가입 먼저~~]</b>');
						$('#signInPw').val("");
						$('#signInId').focus();
						chk2 = false;
				    } else if(data.result == 0) {
						$('#signInPw').css("background-color", "pink");
						$('#signInPw').val("");
						$('#signInPw').focus();
						$('#pwCheck').html('<b style="font-size:16px;color:red;">[비밀번호가 틀렸습니다ㅠㅠ]</b>');
						chk2 = false;
					} else if(data.result == 1) {
						location.href="/";
					}
				}
			});			
		} else {
			alert('입력정보를 다시 확인하세요.');			
		}
	});
	
});


