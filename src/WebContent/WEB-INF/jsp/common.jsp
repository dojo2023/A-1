<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<!-- 画面下部メニューバー表示 -->
	<div class="menu">
		<footer>
			<a href="jiro_power/Web-INF/jsp/training_record.jsp"><img src=""></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/calendar.jsp"><img src=""></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/ranking.jsp"><img src=""></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/timer.jsp"><img src=""></a> <!-- srcの後、アイコンのリンク入れる -->
			<a href="jiro_power/Web-INF/jsp/mypage.jsp"><img src=""></a> <!-- srcの後、アイコンのリンク入れる -->
		</footer>
	</div>
	<script src="/WebContent/common.js"></script>
<script src="./js/common.js"></script>
</body>
</html>