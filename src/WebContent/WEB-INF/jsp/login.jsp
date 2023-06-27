<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/jiro_power/css/login.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<!-- <link rel="stylesheet" href="/jiro_power/css/common.css"> -->
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>ログイン</title>

<!--     <style>
      #textPassword {
        border: none;
      }
       #fieldPassword {
        border-width: thin;
        border-style: solid;
        width: 200px;
      }
    </style>
 -->

</head>
<body>

	<div id="logo"><img src="./img/logo.png" alt="ロゴ"></div>
	<br>
    <div class="title">Login</div>

	<div id="login">
		<form name='form-login' id="fieldPassword" method="POST" action="/jiro_power/LoginServlet">
			<div class="wave-group1">
				<input required type="email" id="mail_address" name="Mail_Address" class="input">
<!-- 				<span class="bar"></span> -->
				<label class="label">
					<span class="label-char" style="--index: 0">M</span>
					<span class="label-char" style="--index: 1">a</span>
					<span class="label-char" style="--index: 2">i</span>
					<span class="label-char" style="--index: 3">l</span>
					<span class="label-char" style="--index: 4">_</span>
					<span class="label-char" style="--index: 5">A</span>
					<span class="label-char" style="--index: 6">d</span>
					<span class="label-char" style="--index: 7">d</span>
					<span class="label-char" style="--index: 8">r</span>
					<span class="label-char" style="--index: 9">e</span>
					<span class="label-char" style="--index: 10">s</span>
					<span class="label-char" style="--index: 11">s</span>
				</label>
			</div>
			<!--
			<div class="mailAddress">
				<span class="fontawesome-user"></span>
					<input type="email" id="mail_address" name="Mail_Address" placeholder="mail_address" >
				<br>
			</div>
			 -->
			<div class=mailAddressError>
				<p id="mail_address_error" class="error-message"></p>
			</div>


			<span class="fontawesome-lock"></span>
			<div class="wave-group2">
				<input required type="password" id="textPassword" name="PW" class="input" min="8" maxlength="20">
<!-- 				<span class="bar"></span> -->
				<label class="label">
					<span class="label-char" style="--index: 0">P</span>
					<span class="label-char" style="--index: 1">a</span>
					<span class="label-char" style="--index: 2">s</span>
					<span class="label-char" style="--index: 3">s</span>
					<span class="label-char" style="--index: 4">w</span>
					<span class="label-char" style="--index: 5">o</span>
					<span class="label-char" style="--index: 6">r</span>
					<span class="label-char" style="--index: 7">d</span>
				</label>
				<span id="buttonEye" class="fa fa-eye" onclick="pushHideButton()"></span>
			</div>
			<!--
			<div class= "password">
				<input type="password" id="textPassword" name="PW" placeholder="password"
				min="8" maxlength="20" >
				<span id="buttonEye" class="fa fa-eye" onclick="pushHideButton()"></span>
			</div>
			 -->
			<div class="passwordError">
				<p id="password_error" class="error-message"></p>
			</div>



			<!-- <input type="checkbox" class="checkbox" id="showPassword"> -->
<!-- 			<label for="showPassword" id="showPasswordLabel">
      			<img src="./img/eye6.png" alt="Show Password">
      			<span class="strikethrough"></span>
      		</label>
-->

			<div class="submit">
				<input type="submit" name="login" value="　　ログイン　　" onclick="return validateForm()">
			</div>

			<div style="color:red">
			${errMsg}
			</div>
		</form>

	</div> <!-- id="login" -->

	<div class="regist">
		<input type="button" class="create" value="新規登録はこちら" onclick="window.location.href='/jiro_power/UserRegistServlet'">
	</div>

	<a href="jiro_power/Web-INF/jsp/user_regist.jsp"></a>
	<script src="/jiro_power/js/login.js"></script>

</body>
</html>