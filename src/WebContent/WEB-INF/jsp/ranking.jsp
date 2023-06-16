<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/jiro_power/css/ranking.css">
<link rel="stylesheet" href="/jiro_power/css/common.css">
<meta name="viewport" content="initial-scale=1">
<title>総合ランキング</title>
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

<div class="title">Ranking</div>
<!-- ここにグラフ -->
<canvas width="300" height="400"></canvas>
<!-- 切り替えボタン -->
<input type="submit" name="submit" value="Ranking">
<input type="submit" name="submit" value="Monthly">
<input type="submit" name="submit" value="Weekly">

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

<script>
/* 顔文字のドーナツチャートの部分の処理 */

let inputData ='${Expsum.rankingData}';
let context = document.querySelector("#kimochi").getContext('2d')
new Chart(context, {
  type: 'bar',
  data: {
    labels: ['1','2','3','4','5','6','7','8','9','10'],
    datasets: [{
      /* ここで取得した配列の中身を分解して配置する */
      data: [inputData[0], inputData[1],inputData[2],inputData[3],inputData[4],inputData[5],inputData[6],inputData[7],inputData[8],inputData[9]],
      backgroundColor: ['#5AFF19', '#5AFF19', '#5AFF19','#5AFF19','#5AFF19','#5AFF19','#5AFF19','#5AFF19','#5AFF19','#5AFF19'],
    }]
  },
  options: {
  indexAxis: 'y',
    responsive: false,
  }
});
</script>
</body>
</html>