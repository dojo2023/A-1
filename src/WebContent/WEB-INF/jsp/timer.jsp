<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/jiro_power/css/timer.css">
    <link rel="stylesheet" href="/jiro_power/css/common.css">
    <title>Timer with Progress Indicator</title>
</head>
<body>

<!-- 画面上部ステータス表示 -->
	<header>
        <div class="status">
            <div id="logo"><img src="./img/logo.png" alt="ロゴ"></div>
            <div class="menucoler">
            <h1 class="level pulsate">${level_session}</h1>
            <div class="allname">
            <div id="names">Name</div>
            <div id="name"><p>${user_name_session}</div>
            </div>
        </div>
    </div>
        </header>

    <div class="container">
        <div class="wrapper">
            <p>
                <span class="mins">60</span>:<span class="seconds">00</span>
            </p> <br>
            <!-- セットボタン -->
			<button class="plus-min">+</button>
			<button class="minus-min">-</button>
			<button class="plus-sec">+</button>
			<button class="minus-sec">-</button>
			<br>
			<br>


            <button class="btn-start">Start</button>
            <button class="btn-stop">Stop</button>
            <button class="btn-reset">Reset</button>
        </div>
    </div>
    </div>

    <hr>

 <!-- 画面下部メニューバー表示 -->
	<div class="menu">
        <ul>
            <li class="list">
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
            <li class="list active">
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

     <!--
// 画面下部メニューバー表示
	<div class="menu">
		<footer>
			<a href="/jiro_power/TrainingRecordServlet"><img src="./img/record.png"></a>
			<a href="/jiro_power/CalendarServlet"><img src="./img/calender.png"></a>
			<a href="/jiro_power/RankingServlet"><img src="./img/ranking.png"></a>
			<a href="/jiro_power/TimerServlet"><img src="./img/timer.png"></a>
			<a href="/jiro_power/MypageServlet"><img src="./img/mypage.png"></a>
		</footer>
	</div>
 -->



<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

	<script src="./js/common.js"></script>
    <script src="/jiro_power/js/timer.js"></script>
     <!-- <div class="timer center"></div> -->

</body>
</html>