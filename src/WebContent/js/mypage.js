/**
 *
 */
function displayDateTime() {
    var datetimeElement = document.getElementById("datetime");

    // 現在の日付と時間を取得
    var currentDate = new Date();
    var date = currentDate.toLocaleDateString();
    var time = currentDate.toLocaleTimeString();

    // 日付と時間を表示
    datetimeElement.innerHTML = "" + date + "<br>" +time;
  }

  // ページが読み込まれた時に実行
  window.onload = function() {
    displayDateTime();
  };
