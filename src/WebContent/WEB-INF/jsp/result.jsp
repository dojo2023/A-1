<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="initial-scale=1">
<link rel="stylesheet" href="/jiro_power/css/result.css">

<title>リザルトページ</title>
</head>
<body>

<div class=title>Result</div>
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

<script src="./js/result.js"></script>
</body>
</html>