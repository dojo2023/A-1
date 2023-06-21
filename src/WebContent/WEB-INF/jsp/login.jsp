<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/jiro_power/css/login.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<!-- <link rel="stylesheet" href="/jiro_power/css/common.css"> -->
<meta name="viewport" content="initial-scale=1">
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

	<img src=""> <!-- ロゴ貼る -->
	<br>
    <div class="title">Login</div>

	<div id="login">
		<form name='form-login' id="fieldPassword" method="POST" action="/jiro_power/LoginServlet">
			<span class="fontawesome-user"></span>
				<input type="email" id="mail_address" name="Mail_Address" placeholder="mail_address" >
			<br>
			<p id="mail_address_error" class="error-message"></p>


			<span class="fontawesome-lock"></span>
			<div class= "password-wwrapper">

				<input type="password" id="textPassword" name="PW" placeholder="password"
				min="8" maxlength="20" >
				<span id="buttonEye" class="fa fa-eye" onclick="pushHideButton()"></span>



			<!-- <input type="checkbox" class="checkbox" id="showPassword"> -->
<!-- 			<label for="showPassword" id="showPasswordLabel">
      			<img src="./img/eye6.png" alt="Show Password">
      			<span class="strikethrough"></span>
      		</label>
-->

      		</div>

			<p id="password_error" class="error-message"></p>

			<input type="submit" name="login" value="ログイン" onclick="return validateForm()">
			<div style="color:red">
			${errMsg}
			</div>
		</form>

	</div> <!-- id="login" -->

	<input type="button" class="create" value="新規登録はこちら" onclick="window.location.href='/jiro_power/UserRegistServlet'">

	<a href="jiro_power/Web-INF/jsp/user_regist.jsp"></a>
	<script src="/jiro_power/js/login.js"></script>

</body>
</html>