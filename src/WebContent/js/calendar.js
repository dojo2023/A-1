/**
 *
 */
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