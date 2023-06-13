<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>

</head>
<body>

 <div class="datetime" id="datetime"></div>
<h1>My Page</h1>

	<div class="title">
	 	<div class="label">My Page</div>
	 </div>

	<form name="mypage" method="POST" action="/WEB-INF/jsp/mypage.jsp">

		  <div class="username"><input type="text" name="username" value="${username}"></div>
	      <div class="exp">${exp}exp</div>
	      <div class="birthday_display">${birthday_display}</div>
	      <div class="sex">${sex}</div>
	      <div class="height">身長</div>
	      <div class="height_input"><input type="text" name="height" value="${height}"></div>
	      <div class="unit_height">cm</div>
	      <div class="weight">体重</div>
	      <div class="weight_input"><input type="text" name="weight" value="${weight}"></div>
	      <div class="unit_weight">kg</div>
	      <div class="mail">E-mail</div>
	      <div class="mail_address_display">${mail_address_display}</div>
	</form>


	<div class="share" id="share">
	 <a href="jiro_power/Web-INF/jsp/result.jsp"><img src=""></a> <!-- srcの後、アイコンのリンク入れる -->
	</div>

	<div class="update" id="update">
	 <a href="jiro_power/Web-INF/jsp/mypage.jsp"><img src=""></a> <!-- srcの後、アイコンのリンク入れる -->
	</div>

	<div class="logout" id="logout">
	 <a href="jiro_power/Web-INF/jsp/logout.jsp"><img src=""></a> <!-- srcの後、アイコンのリンク入れる -->
	</div>

<script src="./js/mypage.js"></script>
</body>
</html>