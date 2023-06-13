<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>カレンダー</title>
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

<h1>カレンダーページちゃん</h1>
<p class="yearMonth"></p>
<div id="calendar"></div>

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

<script src="./js/calendar.js"></script>
</body>

<script>
const calendar = document.getElementById("calendar");
const yearMonth = document.querySelector(".yearMonth");
const days = ["月", "火", "水", "木", "金", "土", "日"];
const date = new Date();
let year = date.getFullYear();
let month = date.getMonth() + 1;
// HTMLを組み立てる変数
let calendarHtml = "";

// 年月の表示
yearMonth.textContent = `${year}年${month}月`;

calendarHtml += "<table><tr>";

// 曜日の行を作成(テーブル1行目)
for (let i = 0; i < days.length; i++) {
  // 曜日を表示させる1行目にはクラスdayを付与する
  calendarHtml += "<td class='day'>" + days[i] + "</td>";
}

calendarHtml += "</tr>";
//前月の最後の日の情報
const lastMonthEndDate = new Date(year, month - 1, 0);
// 前月の末日
const lastMonthEndDayCount = lastMonthEndDate.getDate();
// 月の最初の日の曜日を取得
const startDay = startDate.getDay();

// 6週分の行を生成
for (let w = 0; w < 6; w++) {
  calendarHtml += "<tr>";

  // 月～日まで
  for (let d = 0; d < 7; d++) {
    if (w == 0 && d < startDay - 1) { // 第一週目で、且つ今月1日の曜日の前まで
      // 1行目で1日の前の日付
      let num = lastMonthEndDayCount - startDay + d + 2;
      calendarHtml +=
        '<td class="is-disabled">' + num + "</td>";
  }
}
  let dayCount = 1; // 日にちのカウント

  if (w == 0 && d < startDay - 1) {
    // 1行目で1日の前の日付
    let num = lastMonthEndDayCount - startDay + d + 2;
    calendarHtml +=
      '<td class="is-disabled">' + num + "</td>";
  } else if (dayCount > endDayCount) {
    // 末尾の日数を超えた
    let num = dayCount - endDayCount;
    calendarHtml +=
      '<td class="is-disabled">' + num + "</td>";
    dayCount++;
  }
} else if (dayCount > endDayCount) {
	  // 末尾の日数を超えた
	  let num = dayCount - endDayCount;
	  calendarHtml +=
	    '<td class="is-disabled">' + num + "</td>";
	  dayCount++;
	} else {
	  // 今日の日付にクラスtodayを付与
	  if(dayCount == today){
	    calendarHtml += `<td class="today">${dayCount}</td>`;
	    dayCount++;
	  }else{
	    calendarHtml += `<td>${dayCount}</td>`;
	    dayCount++;
	  }
	}
//trをすべて取得
const tr = document.querySelectorAll(".calendar-container tr")
// 最終行の最初のtdにクラスis-disabledが含まれていれば、最終行を削除
if(tr[6].firstChild.classList.contains("is-disabled")){
  tr[6].remove();
}
</script>