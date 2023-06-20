<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/jiro_power/css/login.css">
<!-- <link rel="stylesheet" href="/jiro_power/css/common.css"> -->
<meta name="viewport" content="initial-scale=1">
<title>ログイン</title>
</head>
<body>
    <div class="title">Login</div>
	<img src=""> <!-- ロゴ貼る -->
	<div id="login">
		<form name='form-login' method="POST" action="/jiro_power/LoginServlet">
			<span class="fontawesome-user"></span>
				<input type="email" id="mail_address" name="Mail_Address" placeholder="mail_address" required>
			<br><br>
			<p id="mail_address_error" class="error-message"></p>

			<span class="fontawesome-lock"></span>
			<div class= "password-wwrapper">
				<input type="password" id="pw" name="PW" placeholder="password"
				minlength="8" maxlength="20" required>
			<!-- <input type="checkbox" class="checkbox" id="showPassword"> -->
			<label for="showPassword" id="showPasswordLabel">
      			<img src="./img/eye6.png" alt="Show Password">
      			<span class="strikethrough"></span>
      		</label>
      		</div>
			<br>
			<p id="password_error" class="error-message"></p>

			<p>※パスワードは8文字以上20文字以内です。</p>

			<input type="submit" name="login" value="ログイン">
		</form>
			<p>※メールアドレス又はパスワードが間違っています。</p>
	</div> <!-- id="login" -->

	<input type="button" class="create" value="新規登録はこちら" onclick="window.location.href='/jiro_power/UserRegistServlet'">

	<a href="jiro_power/Web-INF/jsp/user_regist.jsp"></a>
	<script src="/jiro_power/js/login.js"></script>

</body>
</html>