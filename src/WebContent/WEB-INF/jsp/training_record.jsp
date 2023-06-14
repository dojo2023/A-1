<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/jiro_power/css/training_record.css">

<title>トレーニング記録ページ</title>
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
	<div class="title">Training Record</div>
	</div>
	<form method="POST" action="/jiro_power/TrainingRecordServlet">
	<input type="date">
	<select name="training_name">
	<option>種目1</option>
	<option>種目2</option>
	<option>種目3</option>
	</select>
	<input type = "number" name="training_weight"><p>kg</p>
	<input type = "number" name="training_times"><p>回</p>
	<input type = "number" name="training_set"><p>セット</p>
	<input type = "button" name="training_plus" value="+">
	<input type = "submit" name="record" value="登録">
	</form>


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

<script src="./js/common.js"></script>
<script src="./js/training_record.js"></script>
</body>
</html>