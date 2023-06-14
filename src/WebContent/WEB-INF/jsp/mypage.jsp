<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/jiro_power/css/mypage.css">
<link rel="stylesheet" href="/jiro_power/css/common.css">

<title>マイページ</title>

</head>
<body>

<!-- 画面上部ステータス表示 -->
	<div class="status">
		<header>
			<img src=""> <!-- ロゴ貼る -->
			<p>${level}</p> <!--  {}の中身変える-->
			<p><div id="current_date"></div> <!--  id名前合わせる-->
			<p>${name}</p> <!--  {}の中身変える-->
		</header>
	</div>

<hr>
 <div class="datetime" id="datetime"></div>
<div class=title>My Page</div>


	<form name="mypage" method="POST" action="/WEB-INF/jsp/mypage.jsp">

		  <div class="username"><input type="text" name="username" value="${username}"></div> <!-- user.username -->
	      <div class="exp">${exp}exp</div>
	      <div class="birthday_display">${birthday_display}</div>
	      <div class="sex">${sex}</div>
	      <div class="height">身長</div>
	      <div class="height_input"><input type="text" name="height" value="${height}"></div>
	      <div class="unit_height">cm</div>
	      <div class="weight">体重</div>
	      <div class="weight_input"><input type="text" name="weight" value="${weight}"></div>
	      <div class="unit_weight">kg</div>
	      <div class="mail">E-mail</div>
	      <div class="mail_address_display">${mail_address_display}</div>
	</form>


	<div class="share" id="share">
	 <a href="/jiro_power/ResultServlet"><img src="./img/share.png"></a> <!-- srcの後、アイコンのリンク入れる -->
	</div>

	<div class="update" id="update">
	 <a href="/jiro_power/MypageServlet"><img src="./img/reload.png"></a> <!-- srcの後、アイコンのリンク入れる -->
	</div>

<!-- 	<div class="logout" id="logout">
	 <a href="/jiro_power/LogoutServlet"><img src=""></a> srcの後、ログアウトアイコンのリンク入れる
	</div>

	<input type="submit" class="logout" value="Logout" id="pass">
-->

<!-- 	<form>
  		<input type="button" class="logout" value="Logout" id="pass">
	</form>

	<a href="/jiro_power/LoginServlet" class="logout">Logout</a> -->

	<input type="button" class="logout" value="Logout" onclick="window.location.href='/jiro_power/LoginServlet'">



	<hr>

<!-- 画面下部メニューバー表示 -->
	<div class="menu">
		<footer>
			<a href="/jiro_power/TrainingRecordServlet"><img src="./img/record.png"></a>
			<a href="/jiro_power/CalendarServlet"><img src="./img/calender.png"></a>
			<a href="/jiro_power/RankingServlet"><img src="./img/ranking.png"></a>
			<a href="/jiro_power/TimerServlet"><img src="./img/timer.png"></a>
			<a href="/jiro_power/MypageServlet"><img src="./img/mypage.png"></a>
		</footer>
	</div>

<script src="./js/mypage.js"></script>
</body>
</html>