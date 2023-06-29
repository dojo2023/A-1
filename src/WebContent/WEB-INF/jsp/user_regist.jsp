<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" href="/jiro_power/css/user_regist.css">

<title>ユーザー登録ページ</title>

</head>

<body>
	<div class="header">
		<div class="button001">
			<button type="button" onclick="history.back()"></button>
		</div>
		<div id="logo"><img src="./img/logo.png" alt="ロゴ"></div>
	</div>

	<div id="regist">
		<form id="myForm" name='user_regist' method="POST" action="/jiro_power/UserRegistServlet" >
			<div class="title">Registration</div>
			<div class="Name">
				<input type="text" class="input-field" id="user_name" name="User_Name" value="${param.User_Name}"
					placeholder="8字以内" maxlength="8" required>
				<label for="input-field" class="input-label">Name</label>
			<br>
				<p id="user_name_error" class="error-message"></p> <!-- ユーザー名のエラーメッセージ -->
			</div>

			<div class="mailAddress">
				<input type="email" class="input-field" id="mail_address" name="Mail_Address" placeholder="E-mail" value="${param.Mail_Address}" required>
				<label for="input-field" class="input-label">E-mail</label>
			<br>
				<p id="mail_address_error" class="error-message"></p> <!-- メールアドレスのエラーメッセージ -->
				<span class="error-message">${mac}</span> <!-- エラーメッセージを赤色で表示 -->
			<br>
			</div>

			<div class="password">
				<input type="password" class="input-field" id="password" name="Password" placeholder="8字以上20字以下"
					min="8" maxlength="20" required>
				<label for="input-field" class="input-label">Password</label>
			<br>
				<p id="password_error" class="error-message"></p>
			</div>

			<div class="sex">

				<input type="radio" id="sexChoice1" name="User_Sex" value="1" checked>
				<label>man</label>

				<input type="radio" id="sexChoice2" name="User_Sex" value="2">
				<label>woman</label>
				<br>
			</div>

			<div class="birth">
				<input type="date" class="input-field" id="birth" name="User_Birth" max="9999-12-31" value="${param.User_Birth}" required>
				<label for="input-field" class="input-label">Birth</label>
				<br>
				<p id="birth_error" class="error-message"></p>
			</div>

			<div class="height">
				<input type="number" class="input-field" id="height" name="User_Height" value="${param.User_Height}" placeholder="〇〇cm" min="1" max="300">
				<label for="input-field" class="input-label">Height</label>
			<br>
				<p id="height_error" class="error-message"></p>
			</div>

			<div class="weight">
				<input type="number" class="input-field" id="weight" name="User_Weight" placeholder="〇〇kg" min="30" max="300" value="${param.User_Weight}" required>
				<label for="input-field" class="input-label">Weight</label>
			<br>
				<p id="weight_error" class="error-message"></p>
			</div>

			<input type="button" name="regist" class="regist" value="登録" onclick="showConfirmationDialog(event)">
		</form>
	</div> <!-- id="regist" -->
<script src="/jiro_power/js/user_regist.js"></script>

</body>
</html>