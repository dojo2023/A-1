<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>月間ランキングページ</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.2.0/chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-adapter-date-fns@next/dist/chartjs-adapter-date-fns.bundle.min.js"></script>

</head>
<body>
<div class="ranking">Monthly Ranking</div>
<!-- ここにグラフ -->
<canvas width="300" height="400"></canvas>
<!-- 切り替えボタン -->
<input type="button" value="Ranking">
<input type="button" value="Monthly">
<input type="button" value="Weekly">
<script src="./js/ranking.js"></script>
</body>
</html>