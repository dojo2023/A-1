<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>リザルトページ</title>
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
<h1>リザルトページちゃん</h1>
		<img src=""> <!-- ロゴ貼る -->
		<p>${name}</p> <!--  {}の中身変える-->
		<p>${level}</p> <!--  {}の中身変える-->
		<p>${exp}</p> <!--  {}の中身変える-->
		<p>${ranking}</p> <!--  {}の中身変える-->
		<p>${wranking}</p> <!--  {}の中身変える-->
		<p>${mranking}</p> <!--  {}の中身変える-->
		<a href="http://twitter.com/share?text=【ツイートテキスト（※日本語をURLエンコードしたもの）】&url=【そのページのURL】" rel="nofollow">ツイート</a>
		<a href="http://www.facebook.com/share.php?u=【そのページのURL】" target="_blank">Facebook</a>
		<a href="https://social-plugins.line.me/lineit/share?url=【エンコードしたURL】" target="_blank">LINE</a>

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

<script src="./js/common.js"></script>
<script src="./js/result.js"></script>
</body>
</html>