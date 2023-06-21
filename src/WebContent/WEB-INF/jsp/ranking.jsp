<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.google.gson.Gson" %>
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
<canvas id="ranking" width="300" height="400"></canvas>
<!-- 切り替えボタン -->
<input type="submit" name="submit" value="Ranking">
<input type="submit" name="submit" value="Monthly">
<input type="submit" name="submit" value="Weekly">

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
            <li class="list active">
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

		<script src="./js/common.js"></script>
        <!-- <script src="./js/ranking.js"></script>  -->
        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

<script>
/* 横棒グラフの処理 */

let rankData =<%= new Gson().toJson(request.getAttribute("rankList")) %>;

let context = document.querySelector("#ranking").getContext('2d')
new Chart(context, {
  type: 'bar',
  data: {
	  /* あとで10位まで項目追加 */
    labels: ['1'+rankData[0].user_name,'2'+rankData[1].user_name,'3'+rankData[2].user_name,'4'+rankData[3].user_name,'5'+rankData[4].user_name,'6'+rankData[5].user_name],
    datasets: [{
      /* ここで取得した配列の中身を分解して配置する、10位まで追加予定 */
      data: [rankData[0].training_exp, rankData[1].training_exp,rankData[2].training_exp,rankData[3].training_exp,rankData[4].training_exp,rankData[5].training_exp],
      backgroundColor: ['#5AFF19', '#5AFF19', '#5AFF19','#5AFF19','#5AFF19','#5AFF19','#5AFF19','#5AFF19','#5AFF19','#5AFF19']
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