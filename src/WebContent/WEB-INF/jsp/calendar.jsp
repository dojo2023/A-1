<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>カレンダー</title>
</head>
<body>

<h1>カレンダーページちゃん</h1>
<p class="yearMonth"></p>
<div id="calendar"></div>

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