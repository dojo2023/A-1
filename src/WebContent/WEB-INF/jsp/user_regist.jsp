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
		<!-- <a href="#" onclick="history.back(-1);return false;">戻る</a> -->
		<div class="button001">
			<button type="button" onclick="history.back()"></button>
		</div>
		<div id="logo"><img src="./img/logo.png" alt="ロゴ"></div>
	</div>

<div class="title">Registration</div>

	<div id="regist">
		<form id="myForm" name='user_regist' method="POST" action="/jiro_power/UserRegistServlet" >
			<div class="name">
				<label>ユーザー名</label><br>
				<input type="text" id="user_name" name="User_Name" value="${param.User_Name}"
				placeholder="8文字以内" maxlength="8" required>
				<br>
				<p id="user_name_error" class="error-message"></p> <!-- ユーザー名のエラーメッセージ -->
			</div>

			<div class="mailAddress">
				<label>メールアドレス</label><br>
				<input type="email" id="mail_address" name="Mail_Address" placeholder="mail_address" value="${param.Mail_Address}" required>
				<br>
				<p id="mail_address_error" class="error-message"></p> <!-- メールアドレスのエラーメッセージ -->
				<span class="error-message">${mac}</span><!-- エラーメッセージを赤色で表示 -->
				<br>
			</div>

			<div class="password">
				<label>パスワード</label><br>
				<input type="password" id="password" name="Password" placeholder="8文字以上20文字以下"
				min="8" maxlength="20" required>
				<br>
				<p id="password_error" class="error-message"></p>
			</div>

			<div class="sex">
				<label>性別</label><br>
				<input type="radio" id="sexChoice1" name="User_Sex" value="1" checked>
				<label>man</label>

				<input type="radio" id="sexChoice2" name="User_Sex" value="2">
				<label>woman</label>
				<br>
			</div>

			<div class="birth">
				<label>生年月日</label><br>
				<input type="date" id="birth" name="User_Birth" max="9999-12-31" value="${param.User_Birth}" required>
				<br>
				<p id="birth_error" class="error-message"></p>
			</div>
<!--  			<label for="dob">生年月日:</label>
			  <div class="dob-input">
			    <input type="text" id="dob-day" maxlength="2" placeholder="DD">
			    <input type="text" id="dob-month" maxlength="2" placeholder="MM">
			    <input type="text" id="dob-year" maxlength="4" placeholder="YYYY">
			  </div>
-->

			<div class="height">
				<label>身長</label><br>
				<input type="number" id="height" name="User_Height" value="${param.User_Height}" placeholder="cm単位" min="1" max="300">
				<br>
				<p id="height_error" class="error-message"></p>
			</div>

			<div class="weight">
				<label>体重</label><br>
				<input type="number" id="weight" name="User_Weight" placeholder="kg単位" min="30" max="300" value="${param.User_Weight}" required>
				<br>
				<p id="weight_error" class="error-message"></p>
			</div>

			<!-- <input type="submit" name="regist" value="登録" onclick="showConfirmationDialog(event)"> -->
			<input type="button" name="regist" value="登録" onclick="showConfirmationDialog(event)">

		</form>
	</div> <!-- id="login" -->
<script src="/jiro_power/js/user_regist.js"></script>
</body>
</html>