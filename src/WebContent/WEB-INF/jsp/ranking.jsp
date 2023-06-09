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
<header>
	<div class="status">
		<div id="logo"><img src="./img/logo.png"  alt="ロゴ"></div>
		<div class="menucoler">
			<h1 class="level">${level_session}</h1>
			<div id="name">${user_name_session}</div>
		</div>
	</div>
</header>

<div class="title">Ranking</div>

<!-- ここにグラフ -->
<canvas id="ranking" width="350" height="450"></canvas>

<!-- 切り替えボタン -->
<div>
	<input type="button" value="Ranking" id="rank_button" onclick="window.location.href='/jiro_power/RankingServlet'">
	<input type="button" value="Monthly" id="mrank_button" onclick="window.location.href='/jiro_power/MrankingServlet'">
	<input type="button" value="Weekly" id="wrank_button" onclick="window.location.href='/jiro_power/WrankingServlet'">
</div>

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
</div> <!-- class="menu" -->

<script src="./js/common.js"></script>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

<script>

/* 横棒グラフの処理 */
let rankData =<%= new Gson().toJson(request.getAttribute("rankList")) %>;
let context = document.querySelector("#ranking").getContext('2d')
new Chart(context, {
	type: 'bar',
	data: {
		labels: ['1：'+ rankData[0].userName,'2：'+ rankData[1].userName,'3：'+ rankData[2].userName,'4：'+rankData[3].userName,'5：'+rankData[4].userName,'6：'+rankData[5].userName,'7：'+rankData[6].userName,'8：'+rankData[7].userName,'9：'+rankData[8].userName,'10：'+rankData[9].userName],
			datasets: [{
				/* ここで取得した配列の中身を分解して配置する */
				label: "総合獲得経験値",
				data: [rankData[0].trainingExp, rankData[1].trainingExp,rankData[2].trainingExp,rankData[3].trainingExp,rankData[4].trainingExp,rankData[5].trainingExp,rankData[6].trainingExp,rankData[7].trainingExp,rankData[8].trainingExp,rankData[9].trainingExp],
				backgroundColor: ['#5AFF19'],
				borderColor: ['#ffffff'],
				borderWidth: 1,
			}
		]
	},
	options: {
		indexAxis: 'y',
		responsive: false,
		plugins: {
			legend: {
				labels: {
					color: '#ffffff',  //テキストカラー
					font: {
						size: 15
					}
				}
			}
		},
		scales: {
			x: {
				grid: {
					offset: true
				},
				ticks: {
					color: '#ffffff',  //テキストカラー
					font: {
						size: 12
					}
				}
			},
			y: {
				grid: {
					offset: true
				},
				ticks: {
					color: '#ffffff',  //テキストカラー
					font: {
						size: 16
					}
				}
			}
		}
	}
});
</script>

</body>
</html>