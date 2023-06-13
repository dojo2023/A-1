<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>タイマーページ</title>
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

<h1>タイマーページちゃん</h1>
<div class=timer>Timer</div><!-- 文字を表示 -->
<div class=trainingtime>Training Time</div><!-- 文字を表示 -->
<!-----タイマーの60分を表示------------------------------------------>
            <p id="default">60：00</p>
<!-----スタートボタンを表示----------------------------------------->
            <button id="start">スタート</button>
<!-----ストップボタンを表示----------------------------------------->
            <button id="stop">ストップ</button>
<!-----リセットボタンを表示----------------------------------------->
            <button id="reset">リセット</button>

<!-- 画面下部メニューバー表示 -->
	<div class="menu">
		<footer>
			<a href="jiro_power/Web-INF/jsp/training_record.jsp"><img src="./img/record.png"></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/calendar.jsp"><img src="./img/calender.png"></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/ranking.jsp"><img src="./img/ranking.png"></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/timer.jsp"><img src="./img/timer.png"></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/mypage.jsp"><img src="./img/mypage.png"></a> <!-- srcの後、アイコンのリンク入れる -->
		</footer>
	</div>
<script src="./js/common.js"></script>
<script src="./js/timer.js"></script>
</body>
</html>