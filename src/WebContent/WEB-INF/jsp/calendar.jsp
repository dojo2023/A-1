<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/jiro_power/css/calendar.css">
<link rel="stylesheet" href="/jiro_power/css/common.css">

<title>Calendar</title>
</head>
<body>
	<div class="wrapper">
		<!-- xxxx年xx月を表示 -->
		<h1 id="header"></h1>

		<!-- ボタンクリックで月移動 -->
		<div id="next-prev-button">
			<button id="prev" onclick="prev()">‹</button>
			<button id="next" onclick="next()">›</button>
		</div>

		<!-- カレンダー -->
		<div id="calendar"></div>
		<div id="recordList">トレーニング記録</div>




	</div>

	<!-- 画面上部ステータス表示 -->
	<div class="status">
		<header>
			<img src="">
			<!-- ロゴ貼る -->
			<p>${level}</p>
			<!--  {}の中身変える-->
			<p>
			<div id="current_date"></div>
			<!--  id名前合わせる-->
			<p>${name}</p>
			<!--  {}の中身変える-->
		</header>
	</div>



	<!-- 画面下部メニューバー表示 -->
	<div class="menu">
		<ul>
			<li class="list"><a href="/jiro_power/TrainingRecordServlet">
					<span class="icon"> <ion-icon name="pencil-outline"></ion-icon>
				</span> <span class="text">Recode</span>
			</a></li>
			<li class="list active"><a href="/jiro_power/CalendarServlet">
					<span class="icon"> <ion-icon name="calendar-outline"></ion-icon>
				</span> <span class="text">calendar</span>
			</a></li>
			<li class="list"><a href="/jiro_power/RankingServlet"> <span
					class="icon"> <ion-icon name="trophy-outline"></ion-icon>
				</span> <span class="text">Ranking</span>
			</a></li>
			<li class="list"><a href="/jiro_power/TimerServlet"> <span
					class="icon"> <ion-icon name="timer-outline"></ion-icon>
				</span> <span class="text">Timer</span>
			</a></li>
			<li class="list"><a href="/jiro_power/MypageServlet"> <span
					class="icon"> <ion-icon name="person-outline"></ion-icon>
				</span> <span class="text">Mypage</span>
			</a></li>
			<div class="indicator"></div>
		</ul>
	</div>


	<script type="module"
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

	<!-- <script src="./js/calendar.js"></script> -->
	<script src="./js/common.js"></script>

	<script>
		const week = ["日", "月", "火", "水", "木", "金", "土"];
		const today = new Date();
		// 月末だとずれる可能性があるため、1日固定で取得
		var showDate = new Date(today.getFullYear(), today.getMonth(), 1);

		// 初期表示
		window.onload = function () {
			showProcess(today, calendar);
		};
		// 前の月表示
		function prev() {
			showDate.setMonth(showDate.getMonth() - 1);
			showProcess(showDate);
		}

		// 次の月表示
		function next() {
			showDate.setMonth(showDate.getMonth() + 1);
			showProcess(showDate);
		}

		// カレンダー表示
		function showProcess(date) {
			var year = date.getFullYear();
			var month = date.getMonth();
			document.querySelector('#header').innerHTML = year + "年 " + (month + 1) + "月";

			var calendar = createProcess(year, month);
			document.querySelector('#calendar').innerHTML = calendar;
		}

		//クリック時のアクション
		function test(year,month,count){
				alert(year);
				alert(month);
				alert(count);
				list = <%= new Gson().toJson(request.getAttribute("list")) %>;
				alert(list[0].trainingMenu);
				//記録がたまっていくから、最初にremoveしてあげたい
				input.remove();
				var input = document.createElement("input");
					input.type = "text";
					input.name = "day";
					input.id = "day"+i;
					input.value = count;
					document.body.appendChild(input);
				for(var i=0;i<list.length;i++){
	    			var bean = list[i];
	    			var date = new Date(bean.trainingRecordDate);
	    			var ss = bean.trainingRecordDate.split(" ");
	    			var y = ss[2];
	    			var d = ss[1].replace(",","");
	    			var m = ss[0].replace("月","");



	     			if(year==y && (month)==m && count==d){
	     				alert("aaa");
	     				/* var input = document.createElement("input");
						input.type = "hidden";
						input.name = "day";
						input.id = "day"+i;
						input.value = count;
						document.body.appendChild(input);
						 */
	     			}
	     		}
	     		if(list.length==0){
	     			alert("bbb");
	     			/* var input = document.createElement("input");
					input.type = "hidden";
					input.name = "day";
					input.id = "day"+i;
					input.value = count;
					document.body.appendChild(input); */
	     		}
			}
		let yy;
		let mm;
		let dd;
		let oyy;
		let omm;
		let odd = 0;

		// カレンダー作成
		function createProcess(year, month) {
			// 曜日
			var calendar = "<table><tr class='dayOfWeek'>";
			for (var i = 0; i < week.length; i++) {
				calendar += "<th>" + week[i] + "</th>";
			}
			calendar += "</tr>";

			var count = 0;
			var startDayOfWeek = new Date(year, month, 1).getDay();
			var endDate = new Date(year, month + 1, 0).getDate();
			var lastMonthEndDate = new Date(year, month, 0).getDate();
			var row = Math.ceil((startDayOfWeek + endDate) / week.length);

			// 1行ずつ設定
			for (var i = 0; i < row; i++) {
				calendar += "<tr>";

				// 1colum単位で設定
				for (var j = 0; j < week.length; j++) {

					if (i == 0 && j < startDayOfWeek) {
						// 1行目で1日まで先月の日付を設定
						calendar += "<td class='disabled'>" + (lastMonthEndDate - startDayOfWeek + j + 1) + "</td>";
					} else if (count >= endDate) {
						// 最終行で最終日以降、翌月の日付を設定
						count++;
						calendar += "<td class='disabled'>" + (count - endDate) + "</td>";
					} else {
		                // 当月の日付を曜日に照らし合わせて設定
		                count++

		                console.log("year"+year+"::"+today.getFullYear());

		                if(year == today.getFullYear() && month == (today.getMonth())&& count == today.getDate()){
							var list = <%= new Gson().toJson(request.getAttribute("list")) %>;
							yy=year;
							mm=month+1;
							dd=count;

		                	 calendar += "<td class = 'today'>"+"<a href ='javascript:void(0)' onclick = 'test(yy,mm,dd)'>"+count+"</a>"+"</td>";
		            		for(var i=0;i<list.length;i++){
		            			var bean = list[i];
		            			var date = new Date(bean.trainingRecordDate);
		            			var ss = bean.trainingRecordDate.split(" ");
		            			var y = ss[2];
		            			var d = ss[1].replace(",","");
		            			var m = ss[0].replace("月","");


		            			/* if(year==y && (month+1)==m && count==d){
		            				calendar +="<a href='#'>aa</a>"+"</td>";
		            			}else{
		            				calendar +="<a href='#'>bb</a>"+"</td>";
		            			} */
							}

	            		}else {
							var list = <%= new Gson().toJson(request.getAttribute("list")) %>;
							oyy=year;
							omm=month+1;

							calendar += odd++
		                	calendar += "<td class = 'otherdays'> "+"<a href ='javascript:void(0)' onclick = 'test(oyy,omm,odd)'>"+count+"</a>"+"</td>";

		                	for(var i=0;i<list.length;i++){
		            			var bean = list[i];
		            			var date = new Date(bean.trainingRecordDate);
		            			var ss = bean.trainingRecordDate.split(" ");
		            			var y = ss[2];
		            			var d = ss[1].replace(",","");
		            			var m = ss[0].replace("月","");


		            			/* if(year==y && (month+1)==m && count==d){
		             			}else{
		             			} */
		            		 }

		                }

					}
				}
				calendar += "</tr>";
			}
			return calendar;
		}



	</script>
</body>

</html>