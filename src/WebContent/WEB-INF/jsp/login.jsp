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
			<div class="mailAddress">
				<span class="fontawesome-user"></span>
					<input type="email" id="mail_address" name="Mail_Address" placeholder="mail_address" >
				<br>
			</div>
			<div class=mailAddressError>
				<p id="mail_address_error" class="error-message"></p>
			</div>


			<span class="fontawesome-lock"></span>
			<div class= "password">
				<input type="password" id="textPassword" name="PW" placeholder="password"
				min="8" maxlength="20" >
				<span id="buttonEye" class="fa fa-eye" onclick="pushHideButton()"></span>
			</div>
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