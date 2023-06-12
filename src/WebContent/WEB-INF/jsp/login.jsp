<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
	<img src=""> <!-- ロゴ貼る -->
	<div id="login">
		<form name='form-login' method="POST" action="/jiro_power/LoginServlet">
			<span class="fontawesome-user"></span>
				<input type="email" id="mail_address" name="Mail_address" placeholder="mail_address">

			<span class="fontawesome-lock"></span>
				<input type="password" id="password" name="PW" placeholder="password">

			<p>※パスワードは8文字以上20文字以内です。</p>

			<input type="submit" name="ログイン" value="Go!">
		</form>
	</div> <!-- id="login" -->

	<a href="jiro_power/Web-INF/jsp/user_regist.jsp"></a>
</body>
</html>