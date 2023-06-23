<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/jiro_power/css/mypage.css">
<link rel="stylesheet" href="/jiro_power/css/common.css">
<meta name="viewport" content="initial-scale=1">


<title>マイページ</title>

</head>
<body>

<!-- 画面上部ステータス表示 -->
	<div class="status">
		<header>
			<img src=""> <!-- ロゴ貼る -->
			<p>${level_session}</p> <!--  {}の中身変える-->
			<p><div id="current_date"></div> <!--  id名前合わせる-->
			<p>${user_name_session}</p> <!--  {}の中身変える-->
		</header>
	</div>

<hr>
<!--  <div class="datetime" id="datetime"></div> -->
<div class=title>My Page</div>


	<form name="mypage" method="POST" action="/jiro_power/Mypage_UpdateDeleteServlet">

		  <div class="user_name"><input type="text" name="user_name" value="${user_name_session}"
		  placeholder="8文字以内" maxlength="8" id="user_name" ></div> <!-- user.username -->
		  <br>
		  <p id="user_name_error" class="error-message">


		  <div class="exp">${exp_sum_session} exp</div>		<!-- 経験値表示 -->

	      <div class="birthday_display">${user_birth_session}</div>

	      <div class="sex"><c:choose> <c:when test = "${user_sex_session == 1}">MEN</c:when>
	      <c:otherwise>WOMEN</c:otherwise></c:choose></div>

	      <div class="height">身長</div>
	      <div class="height_input"><input type="text" name="user_height" id="height" value="${user_height_session}"
	      placeholder="cm単位" min="1" max="300" required></div>
	      <div class="unit_height">cm</div>
	      <br>
	      <p id="height_error" class="error-message"></p>

	      <div class="weight">体重</div>
	      <div class="weight_input"><input type="text" name="user_weight" id="weight" value="${user_weight_session}"
	      placeholder="kg単位" min="30" max="300" required></div>
	      <div class="unit_weight">kg</div>
	      <br>
	      <p id="weight_error" class="error-message"></p>

	      <div class="mail_address">E-mail</div>
	      <div class="mail_address_display">${user_mail_address_session}</div>

		  <input type="hidden" name="update" id="one" >
	      		<!-- 更新ボタン -->
 		  <div class="update" >
			  <input type="image" src="./img/reload.png"  id="update" name= "update1" value = "update"
			  onclick="document.getElementById('one').value='update';myPageValidateForm(event);">
				<!--   <label for="update">
			      <img src="./img/reload.png" alt="Reload" >
			      </label>-->
		  </div>

	</form>

		<!-- シェアボタン -->
	      	<div class="share" id="share">
			<a href="/jiro_power/ResultServlet"><img src="./img/share.png"></a>
			</div>




		 <!--  シェアボタンと同じように更新ボタン書くか？？ -->
		 	<!-- 更新ボタン -->
<!-- 	      	<div class="update" id="update">
			<a href="/jiro_power/MypageServle"><img src="./img/reload.png"></a>
			</div> -->


		<!-- ログアウトボタン -->
			<input type="button" class="logout" value="Logout"
			onclick="window.location.href='/jiro_power/LoginServlet'">


<!-- 	<div class="logout" id="logout">
	 <a href="/jiro_power/LogoutServlet"><img src=""></a> srcの後、ログアウトアイコンのリンク入れる
	</div>

	<input type="submit" class="logout" value="Logout" id="pass">
-->

<!-- 	<form>
  		<input type="button" class="logout" value="Logout" id="pass">
	</form>

	<a href="/jiro_power/LoginServlet" class="logout">Logout</a> -->


	<hr>

 <!-- 画面下部メニューバー表示 -->
	<div class="menu">
        <ul>
            <li class="list">
                <a href="/jiro_power/TrainingRecordServlet">
                    <span class="icon">
                    <ion-icon name="pencil-outline"></ion-icon>
                    </span>
                    <span class="text">Record</span>
                </a>
            </li>
            <li class="list">
                <a href="/jiro_power/CalendarServlet">
                    <span class="icon">
                    <ion-icon name="calendar-outline"></ion-icon>
                    </span>
                    <span class="text">Calendar</span>
                </a>
            </li>
            <li class="list">
                <a href="/jiro_power/RankingServlet">
                    <span class="icon">
                    <ion-icon name="trophy-outline"></ion-icon>
                    </span>
                    <span class="text">Ranking</span>
                </a>
            </li>
            <li class="list">
                <a href="/jiro_power/TimerServlet">
                    <span class="icon">
                    <ion-icon name="timer-outline"></ion-icon>
                    </span>
                    <span class="text">Timer</span>
                </a>
            </li>
            <li class="list active">
                <a href="/jiro_power/MypageServlet">
                    <span class="icon">
                    <ion-icon name="person-outline"></ion-icon>
                    </span>
                    <span class="text">Mypage</span>
                </a>
            </li>
            <div class="indicator"></div>
        </ul>
     </div>

     <!--
// 画面下部メニューバー表示
	<div class="menu">
		<footer>
			<a href="/jiro_power/TrainingRecordServlet"><img src="./img/record.png"></a>
			<a href="/jiro_power/CalendarServlet"><img src="./img/calender.png"></a>
			<a href="/jiro_power/RankingServlet"><img src="./img/ranking.png"></a>
			<a href="/jiro_power/TimerServlet"><img src="./img/timer.png"></a>
			<a href="/jiro_power/MypageServlet"><img src="./img/mypage.png"></a>
		</footer>
	</div>
 -->



<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

<script src="./js/common.js"></script>
<script src="./js/mypage.js"></script>
</body>
</html>