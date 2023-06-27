<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.google.gson.Gson" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>週間ランキングページ</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link rel="stylesheet" href="/jiro_power/css/ranking.css">
<link rel="stylesheet" href="/jiro_power/css/common.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.2.0/chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-adapter-date-fns@next/dist/chartjs-adapter-date-fns.bundle.min.js"></script>

</head>
<body>
<!-- 画面上部ステータス表示 -->
	<header>
        <div class="status">
            <div id="logo"><img src="./img/logo.png" alt="ロゴ"></div>
            <div class="menucoler">
            <h1 class="level">${level_session}</h1>
            <div class="allname">
            <div id="names">Name</div>
            <div id="name">${user_name_session}</div>
            </div>
        </div>
    </div>
        </header>

<div class="title">Weekly Ranking</div>
<!-- ここにグラフ -->
<div class="canvas">
<canvas id="wmranking" width="350" height="250"></canvas>
<canvas id="wwranking" width="350" height="250"></canvas>
</div>
<!-- 切り替えボタン -->
<input type="button" value="Ranking" id="rank_button" onclick="window.location.href='/jiro_power/RankingServlet'">
<input type="button" value="Monthly" id="mrank_button" onclick="window.location.href='/jiro_power/MrankingServlet'">
<input type="button" value="Weekly" id="wrank_button" onclick="window.location.href='/jiro_power/WrankingServlet'">

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

let wmrankData =<%= new Gson().toJson(request.getAttribute("wmrankList")) %>;

let wmcontext = document.querySelector("#wmranking").getContext('2d')
new Chart(wmcontext, {
  type: 'bar',
  data: {
    labels: ['1'+wmrankData[0].userName,'2'+wmrankData[1].userName,'3'+wmrankData[2].userName,'4'+wmrankData[3].userName,'5'+wmrankData[4].userName],
    datasets: [{
      /* ここで取得した配列の中身を分解して配置する */
        label: "週間獲得経験値",
      data: [wmrankData[0].trainingExp, wmrankData[1].trainingExp,wmrankData[2].trainingExp,wmrankData[3].trainingExp,wmrankData[4].trainingExp],
      backgroundColor: ['#5AFF19', '#5AFF19', '#5AFF19','#5AFF19','#5AFF19'],
    }]
  },
  options: {
	    indexAxis: 'y',
	    responsive: false,
	    plugins: {
	    	legend: {
	    		labels: {
	    			color: '#ffffff'  //テキストカラー
	    		}
	    	}
	    },
		scales: {
			x: {
	            grid: {
	              offset: true
	            },
	            ticks: {
	            	color: '#ffffff'  //テキストカラー
	            }
	        },
	        y: {
	            grid: {
	              offset: true
	            },
	            ticks: {
	            	color: '#ffffff'  //テキストカラー
	            }
	        }
		}
}
});

let wwrankData =<%= new Gson().toJson(request.getAttribute("wwrankList")) %>;
let wwcontext = document.querySelector("#wwranking").getContext('2d')
new Chart(wwcontext, {
  type: 'bar',
  data: {
    labels: ['1'+wwrankData[0].userName,'2'+wwrankData[1].userName,'3'+wwrankData[2].userName,'4'+wwrankData[3].userName,'5'+wwrankData[4].userName],
    datasets: [{
      /* ここで取得した配列の中身を分解して配置する */
        label: "週間獲得経験値",
      data: [wwrankData[0].trainingExp, wwrankData[1].trainingExp,wwrankData[2].trainingExp,wwrankData[3].trainingExp,wwrankData[4].trainingExp],
      backgroundColor: ['#5AFF19', '#5AFF19', '#5AFF19','#5AFF19','#5AFF19'],
    }]
  },
  options: {
	    indexAxis: 'y',
	    responsive: false,
	    plugins: {
	    	legend: {
	    		labels: {
	    			color: '#ffffff'  //テキストカラー
	    		}
	    	}
	    },
		scales: {
			x: {
	            grid: {
	              offset: true
	            },
	            ticks: {
	            	color: '#ffffff'  //テキストカラー
	            }
	        },
	        y: {
	            grid: {
	              offset: true
	            },
	            ticks: {
	            	color: '#ffffff'  //テキストカラー
	            }
	        }
		}
}
});
</script>
</body>
</html>