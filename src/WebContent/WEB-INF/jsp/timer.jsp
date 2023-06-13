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

<script src="./js/timer.js"></script>
</body>
</html>