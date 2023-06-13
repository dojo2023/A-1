<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トレーニング記録ページ</title>
</head>
<body>

<h1>トレーニング記録ページちゃん</h1>
<!-- 画面上部ステータス表示 -->
	<div class="status">
		<header>
			<img src=""> <!-- ロゴ貼る -->
			<p>${level}</p> <!--  {}の中身変える-->
			<p><div id="current_date"></div> <!--  id名前合わせる-->
			<p>${name}</p> <!--  {}の中身変える-->
		</header>
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
			<a href="jiro_power/Web-INF/jsp/training_record.jsp"><img src="./WebContent/img/record.png" alt="記録"></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/calendar.jsp"><img src="./WebContent/img/calender.png"alt="カレンダー"></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/ranking.jsp"><img src="./WebContent/img/ranking.png" alt="ランキング"></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/timer.jsp"><img src="./WebContent/img/timer.png" alt="タイマー"></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/mypage.jsp"><img src="./WebContent/img/mypage.png" alt="マイページ"></a> <!-- srcの後、アイコンのリンク入れる -->
		</footer>
	</div>
<script src="./js/common.js"></script>
<script src="./js/training_record.js"></script>
</body>
</html>