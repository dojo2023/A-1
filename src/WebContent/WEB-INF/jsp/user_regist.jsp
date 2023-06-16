<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/jiro_power/css/user_regist.css">

<title>ユーザー登録ページ</title>
</head>
<body>

<div class=title>Registration</div>

	<header>
		<a href="jiro_power/Web-INF/jsp/login.jsp"></a> <!-- 戻るボタン -->
		<img src=""> <!-- ロゴ貼る -->
	</header>

	<div id="regist">
		<form id="myForm" name='user_regist' method="GET" action="/jiro_power/LoginServlet" >
			<label>ユーザー名</label>
			<input type="text" id="user_name" name="User_Name" class ="user_name"
			placeholder="8文字以内" maxlength="8" required>
			<br>
			<p id="user_name_error" class="error-message"></p> <!-- ユーザー名のエラーメッセージ -->


			<label>メールアドレス</label>
			<input type="email" id="mail_address" name="Mail_Address" placeholder="mail_address" required>
			<br>
			<p id="mail_address_error" class="error-message"></p>
			<p>※このメールアドレスは既に登録されています。</p>

			<label>パスワード</label>
			<input type="password" id="password" name="Password" placeholder="8文字以上20文字以下"
			minlength="8" maxlength="20" required>
			<br>
			<p id="password_error" class="error-message"></p>
			<p>※入力されたパスワードは不適正です。</p>

			<label>性別</label>
				<input type="radio" id="sexChoice1" name="sex" value=1 checked>
				<label>man</label>

				<input type="radio" id="sexChoice2" name="sex" value=2>
				<label>woman</label>
			<br>
			<p>※どちらか選択してください。</p>

			<label>生年月日</label>
			<input type="number" id="birth" name="Birth" required>
			<br>
			<p>※生年月日が入力されていません。</p>
			<p id="birth_error" class="error-message"></p>

			<label>身長</label>
			<input type="number" id="height" name="Height" placeholder="cm単位" min="1" max="300" required>
			<br>
			<p id="height_error" class="error-message"></p>

			<label>体重</label>
			<input type="number" id="weight" name="Weight" placeholder="kg単位" min="1" max="300" required>
			<br>
			<p id="weight_error" class="error-message"></p>

			<!-- <input type="submit" name="regist" value="登録" onclick="showConfirmationDialog(event)"> -->
			<input type="button" name="regist" value="登録" onclick="showConfirmationDialog(event)">

		</form>
	</div> <!-- id="login" -->
<script src="/jiro_power/js/user_regist.js"></script>
</body>
</html>