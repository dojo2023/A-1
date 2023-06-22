<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.google.gson.Gson" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/jiro_power/css/m_ranking.css">
<link rel="stylesheet" href="/jiro_power/css/common.css">

<title>月間ランキングページ</title>
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

<div class="title">Monthly Ranking</div>
<!-- ここにグラフ -->
<canvas id="mmranking" width="300" height="400"></canvas>
<canvas id="mwranking" width="300" height="400"></canvas>
<!-- 切り替えボタン -->
<input type="submit" value="Ranking">
<input type="submit" value="Monthly">
<input type="submit" value="Weekly">

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
        <script src="./js/ranking.js"></script>
        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>


<script>
/* 横棒グラフの処理 */

let mmrankData =<%= new Gson().toJson(request.getAttribute("mmrankList")) %>;
let mmcontext = document.querySelector("#mmranking").getContext('2d')
new Chart(mmcontext, {
  type: 'bar',
  data: {
    labels: ['1','2','3','4','5'],
    datasets: [{
      /* ここで取得した配列の中身を分解して配置する */
      data: [mmrankData[0].training_exp, mmrankData[1].training_exp,mmrankData[2].training_exp,mmrankData[3].training_exp,mmrankData[4].training_exp],
      backgroundColor: ['#5AFF19', '#5AFF19', '#5AFF19','#5AFF19','#5AFF19'],
    }]
  },
  options: {
  indexAxis: 'y',
    responsive: false,
  }
});

let mwrankData =<%= new Gson().toJson(request.getAttribute("mwrankList")) %>;
let mwcontext = document.querySelector("#mwranking").getContext('2d')
new Chart(mwcontext, {
  type: 'bar',
  data: {
    labels: ['1','2','3','4','5'],
    datasets: [{
      /* ここで取得した配列の中身を分解して配置する */
      data: [mwrankData[0].training_exp, mwrankData[1].training_exp,mwrankData[2].training_exp,mwrankData[3].training_exp,mwrankData[4].training_exp],
      backgroundColor: ['#5AFF19', '#5AFF19', '#5AFF19','#5AFF19','#5AFF19'],
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