<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="initial-scale=1">
<link rel="stylesheet" href="/jiro_power/css/training_record.css">
<link rel="stylesheet" href="/jiro_power/css/common.css">

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
	<form method="POST" action="/jiro_power/TrainingRecordServlet" id="form">
	<div id="target">
	<div>
	<input type="date" name= "training_record_date" Required/>
	<select name="training_menu">
	<option>ベンチプレス</option>
	<option>チェストプレス</option>
	<option>ダンベルフライ</option>
	<option>ラットプルダウン</option>
	<option>デッドリフト</option>
	<option>スクワット</option>
	<option>レッグプレス</option>
	<option>レッグエクステンション</option>
	<option>サイドレイズ</option>
	<option>フロントレイズ</option>
	<option>ショルダープレス</option>
	<option>アームカール</option>
	<option>腹筋</option>
	</select>
	<input type = "number" name="training_weight" min="1" max="999" Required/><p>kg</p>
	<input type = "number" name="training_count" min="1" max="999" Required/><p>回</p>
	<input type = "number" name="training_set" min="1" max="999" Required/><p>セット</p>
	</div>
	</div>
	<button  id = "button"  name="training_plus" disabled>+</button>
	<input type = "submit" name="record" value="登録">
	</form>


<!-- 画面下部メニューバー表示 -->
	<!--<div class="menu">
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
        </div>

        <script src="calendar.js"></script>
        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>-->

<script src="./js/common.js"></script>
<script src="./js/training_record.js"></script>
</body>
</html>