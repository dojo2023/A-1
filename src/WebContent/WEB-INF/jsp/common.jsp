<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="initial-scale=1">

<link rel="stylesheet" href="/jiro_power/css/.css">
<link rel="stylesheet" href="/jiro_power/css/common.css">

<title>Insert title here</title>
</head>

<body>

<!-- 画面上部ステータス表示 -->
<header>
	<div class="status">
		<div id="logo"><img src="./img/logo.png" width="260" height="260" alt="ロゴ"></div>
		<div class="menucoler">
			<h1 class="level">${level_session}</h1>
			<div class="allname">
				<div id="names">Name</div>
				<div id="name">${user_name_session}</div>
			</div>
		</div>
	</div>
</header>


<!-- 画面下部メニューバー表示 -->
<div class="menu">
	<ul>
		<li class="list active">
			<a href="/jiro_power/TrainingRecordServlet">
				<span class="icon">
					<ion-icon name="pencil-outline"></ion-icon>
				</span>
				<span class="text">Record</span>
			</a>
		</li>

		<li class="list">
			<a href="/jiro_power/CalendarServlet">
				<span class="icon">
					<ion-icon name="calendar-outline"></ion-icon>
				</span>
				<span class="text">Calendar</span>
			</a>
		</li>

		<li class="list">
			<a href="/jiro_power/RankingServlet">
				<span class="icon">
					<ion-icon name="trophy-outline"></ion-icon>
				</span>
				<span class="text">Ranking</span>
			</a>
		</li>

		<li class="list">
			<a href="/jiro_power/TimerServlet">
				<span class="icon">
					<ion-icon name="timer-outline"></ion-icon>
				</span>
				<span class="text">Timer</span>
			</a>
		</li>

		<li class="list">
			<a href="/jiro_power/MypageServlet">
				<span class="icon">
					<ion-icon name="person-outline"></ion-icon>
				</span>
				<span class="text">Mypage</span>
			</a>
		</li>
		<div class="indicator"></div>
	</ul>
</div> <!-- class="menu" -->

<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<script src="./js/common.js"></script>

</body>
</html>