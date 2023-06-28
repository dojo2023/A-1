<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="https://kit.fontawesome.com/cd4fd21e2f.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/jiro_power/css/mypage.css">
<link rel="stylesheet" href="/jiro_power/css/common.css">
<meta name="viewport" content="initial-scale=1">
<style>

</style>

<title>マイページ</title>

</head>
<body>

<!-- 画面上部ステータス表示 -->
	<header>
        <div class="status">
            <div id="logo"><img src="./img/logo.png" alt="logo"></div>
            <div class="menucoler">
            	<h1 class="level pulsate">${level_session}</h1>

            		<div id="name"><p>${user_name_session}</div>
            	</div>
        	</div>

    </header>

<hr>
<!--  <div class="datetime" id="datetime"></div> -->
<div class=title>My Page</div>



	<form name="mypage" id="myForm" method="POST" action="/jiro_power/Mypage_UpdateDeleteServlet">

		  <div class="user_name"><input type="text" name="user_name" value="${user_name_session}"
		  placeholder="8文字以内" maxlength="8" id="user_name" style="width: 200px; height: 35px;"></div> <!-- user.username -->

		  <p id="user_name_error" class="error-message">


		  <!-- 経験値表示 -->
		   <div class="exp">
		   	<span class="decor">—</span>
		   	${exp_sum_session}  exp
		   	<span class="decor">—</span>
		   </div>


	      <div class="birthday_display">
	           ${user_birth_session}
	      </div>

	      <!-- <i class="fas fa-birthday-cake" style="color: #ffffff;"></i> -->

	      <div class="sex">
	      	<c:choose>
		      	<c:when test = "${user_sex_session == 1}">
		      	</i>MEN
		      	</c:when>
		      	<c:otherwise>
		      	</i>WOMEN
		      	</c:otherwise>
	      	</c:choose>
	      </div>


		  <!--
	      <i class="fas fa-mars">
	      <i class="fas fa-venus">
	       -->

	      <!-- <div class="height">身長</div> -->
	      <label for="height" class="height">身長:</label>
	      <div class="height_input"><input type="text" name="user_height" id="height" value="${user_height_session}"
	      placeholder="cm単位" style="width: 80px; height: 35px;" min="1" max="300" required></div>
	      <!-- <div class="unit_height">cm</div> -->
	      <label for="height-input" class="unit_height">cm</label>
	      <p id="height_error" class="error-message"></p>

	      <!-- <div class="weight">体重</div> -->
	      <label for="weight" class="weight">体重:</label>
	      <div class="weight_input"><input type="text" name="user_weight" id="weight" value="${user_weight_session}"
	      placeholder="kg単位" style="width: 80px; height: 35px;" min="30" max="300" required></div>
	      <label for="weight-input" class="unit_weight">kg</label>
	      <p id="weight_error" class="error-message"></p>

	      <!-- <div class="mail_address">E-mail</div> -->
	      <label for="mail_address" class="mail_address"><i class="fas fa-envelope"></i>
	      </label>
	      <div class="mail_address_display">${user_mail_address_session}</div>

		  <input type="hidden" name="update" id="one" >

	      		<!-- 更新ボタン -->
	      		<button id="update" name="update1" value="update" onclick="document.getElementById('one').value='update'; myPageValidateForm(event);">
  					<i class="fas fa-sync-alt" style="color: #ffffff;"></i>
				</button>


<!--  		  <div class="update" >
			  <input type="image" id="update" name= "update1" value = "update"
			  onclick="document.getElementById('one').value='update';myPageValidateForm(event);">
			  <i class="fas fa-sync-alt" style="color: #ffffff;"></i>
				  <label for="update">
			      <img src="./img/reload.png" alt="Reload" >
			      </label>
		  </div> -->

	</form>

		<!-- シェアボタン -->
	      	<div class="share" id="share">
			<a href="/jiro_power/ResultServlet" target="_blank">
				<i class="fas fa-share-from-square" style="color: #ffffff;"></i>
			</a>
			</div>

			<!-- aタグ内にいたシェアアイコン写真
			<img src="./img/share.png"> -->

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