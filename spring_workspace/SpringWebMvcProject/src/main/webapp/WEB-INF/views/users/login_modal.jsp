<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 로그인 Modal-->
<div class="modal fade" id="log-in">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">
					<span style="color: #643691;">Spring</span> 로그인
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">

				<form action="#" method="post" id="signInForm"
					style="margin-bottom: 0;">
					<table style="cellpadding: 0; cellspacing: 0; margin: 0 auto; width: 100%">
						<tr>
							<td style="text-align: left">
								<p><strong>아이디를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="idCheck"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="text" name="userId" id="signInId"
								class="form-control tooltipstered" maxlength="10"
								required="required" aria-required="true"
								style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
								placeholder="최대 10자"></td>
						</tr>
						<tr>
							<td style="text-align: left">
								<p><strong>비밀번호를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="pwCheck"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="password" size="17" maxlength="20" id="signInPw"
								name="userPw" class="form-control tooltipstered" 
								maxlength="20" required="required" aria-required="true"
								style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
								placeholder="최소 8자"></td>
						</tr>
						<tr>
							<td style="padding-top: 10px; text-align: center">
								<p><strong>로그인하셔서 더 많은 서비스를 이용하세요~</strong></p>
							</td>
						</tr>
						<tr>
							<td style="width: 100%; text-align: center; colspan: 2;"><input
								type="button" value="로그인" class="btn form-control tooltipstered" id="signIn-btn"
								style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">
							</td>
						</tr>
						<tr>
							<td
								style="width: 100%; text-align: center; colspan: 2; margin-top: 24px; padding-top: 12px; border-top: 1px solid #ececec">

								<a class="btn form-control tooltipstered" data-toggle="modal"
								href="#sign-up"
								style="cursor: pointer; margin-top: 0; height: 40px; color: white; background-color: orange; border: 0px solid #388E3C; opacity: 0.8">
									회원가입</a>
							</td>
						</tr>

					</table>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- 회원가입 Modal -->
<div class="modal fade" id="sign-up" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">
					<span style="color: #643691;">Spring</span> 회원 가입
				</h4>
				<button type="button" class="close" data-dismiss="modal">×</button>

			</div>

			<div class="modal-body">

				<form action="#" name="signup" id="signUpForm" method="post"
					style="margin-bottom: 0;">
					<table
						style="cellpadding: 0; cellspacing: 0; margin: 0 auto; width: 100%">
						<tr>
							<td style="text-align: left">
								<p><strong>아이디를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="idChk"></span></p>
							</td>
								
							
						</tr>
						<tr>
							<td><input type="text" name="userId" id="user_id"
								class="form-control tooltipstered" maxlength="14"
								required="required" aria-required="true"
								style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
								placeholder="숫자와 영어로 4-10자">
								</td>
							
						</tr>

						<tr>
							<td style="text-align: left">
								<p><strong>비밀번호를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="pwChk"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="password" size="17" maxlength="20" id="password"
								name="userPw" class="form-control tooltipstered" 
								maxlength="20" required="required" aria-required="true"
								style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
								placeholder="영문과 특수문자를 포함한 최소 8자"></td>
						</tr>
						<tr>
							<td style="text-align: left">
								<p><strong>비밀번호를 재확인해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="pwChk2"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="password" size="17" maxlength="20" id="password_check"
								name="pw_check" class="form-control tooltipstered" 
								maxlength="20" required="required" aria-required="true"
								style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
								placeholder="비밀번호가 일치해야합니다."></td>
						</tr>

						<tr>
							<td style="text-align: left">
								<p><strong>이름을 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="nameChk"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="text" name="userName" id="user_name"
								class="form-control tooltipstered" maxlength="6"
								required="required" aria-required="true"
								style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
								placeholder="한글로 최대 6자"></td>
						</tr>

						<tr>
							<td style="padding-top: 10px; text-align: center">
								<p><strong>회원가입을 환영합니다~~!</strong></p>
							</td>
						</tr>
						<tr>
							<td style="width: 100%; text-align: center; colspan: 2;"><input
								type="button" value="회원가입" 
								class="btn form-control tooltipstered" id="signup-btn"
								style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">
							</td>
						</tr>

					</table>
				</form>
			</div>
		</div>
	</div>
</div>










