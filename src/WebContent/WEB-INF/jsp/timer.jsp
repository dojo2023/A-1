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

<div class=title>Timer</div>

    <div class="main-container center">

    <div class="circle-container center">
        <div class="semicircle"></div>
        <div class="semicircle"></div>
        <div class="semicircle"></div>
        <div class="outermost-circle"></div>
    </div>
    </div>

    <!-- timer -->
    <div class ="timer-container center">
    <div class="timer center"></div>
    </div>

    <!-- 画面下部メニューバー表示 -->
	<div class="menu">
        <ul>
            <li class="list ">
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

    <script src="/jiro_power/js/timer.js"></script>
     <div class="timer center"></div>

</body>
</html>