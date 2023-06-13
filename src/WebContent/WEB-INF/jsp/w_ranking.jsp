<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>週間ランキングページ</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.2.0/chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-adapter-date-fns@next/dist/chartjs-adapter-date-fns.bundle.min.js"></script>

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

<div class="ranking">Weekly Ranking</div>
<!-- ここにグラフ -->
<canvas width="300" height="400"></canvas>
<!-- 切り替えボタン -->
<input type="button" value="Ranking">
<input type="button" value="Monthly">
<input type="button" value="Weekly">
<!-- 画面下部メニューバー表示 -->
	<div class="menu">
		<footer>
			<a href="jiro_power/Web-INF/jsp/training_record.jsp"><img src="./WebContent/img/record.png"></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/calendar.jsp"><img src="./WebContent/img/calender.png"></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/ranking.jsp"><img src="./WebContent/img/ranking.png"></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/timer.jsp"><img src="./WebContent/img/timer.png"></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/mypage.jsp"><img src="./WebContent/img/mypage.png"></a> <!-- srcの後、アイコンのリンク入れる -->
		</footer>
	</div>

<script src="./js/common.js"></script>
<script src="./js/ranking.js"></script>
</body>
</html>