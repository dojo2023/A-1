<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
    <div class="title">Login</div>
	<img src=""> <!-- ロゴ貼る -->
	<div id="login">
		<form name='form-login' method="POST" action="/jiro_power/LoginServlet">
			<span class="fontawesome-user"></span>
				<input type="email" id="email" name="EMAIL" placeholder="mail_address" required>

			<span class="fontawesome-lock"></span>
				<input type="password" id="pw" name="PW" placeholder="password"
				minlength="8" maxlength="20" required>

			<p>※パスワードは8文字以上20文字以内です。</p>

			<input type="submit" name="login" value="ログイン">
		</form>
			<p>※メールアドレス又はパスワードが間違っています。</p>
	</div> <!-- id="login" -->

	<a href="jiro_power/Web-INF/jsp/user_regist.jsp"></a>
<script src="./js/login.js"></script>
</body>
</html>