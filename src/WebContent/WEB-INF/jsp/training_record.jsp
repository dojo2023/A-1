<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="initial-scale=1">
<link rel="stylesheet" href="/jiro_power/css/training_record.css">
<link rel="stylesheet" href="/jiro_power/css/common.css">

<title>トレーニング記録ページ</title>
</head>
<body>
<!-- 画面上部ステータス表示 -->
	<header>
        <div class="status">
            <div id="logo"><img src="./img/logo.png" alt="ロゴ"></div>
            <div class="menucoler">
            <h1 class="level">${level_session}</h1>

            <div id="name">${user_name_session}</div>
            </div>

    </div>
        </header>
        <form method="POST" action="/jiro_power/TrainingRecordServlet" id="form">
            <div class="input-form" id="input-form">
        <!--テンプレート作成-->
               <template id="form-template">
                  <div class="record" id="record">
                      <input type="date"  name="training_record_date" id="t_date" /><br>
                         <select name="training_menu" id="t_menu">
                            <option>ベンチプレス</option>
                            <option>チェストプレス</option>
                            <option>ダンベルフライ</option>
                            <option>ラットプルダウン</option>
                            <option>デッドリフト</option>
                            <option>スクワット</option>
                            <option>レッグプレス</option>
                            <option>レッグエクステンション</option>
                            <option>サイドレイズ</option>
                            <option>フロントレイズ</option>
                            <option>ショルダープレス</option>
                            <option>アームカール</option>
                            <option>腹筋</option>
                         </select><br>
                            <input type = "number" name="training_weight" class="t_body" id="training_weight"/><label class="t_body2">kg</label><br>
                            <input type="number" name="training_count"  class="t_body" id="training_count"/><label class="t_body2">回</label><br>
                            <input type = "number" name="training_set"  class="t_body" id="training_set"/><label class="t_body2">セット</label><br>
                   </div>
                    <p id="date_error" class="error-message">ああああああああああああああ</p>
                    <p id="weight_error" class="error-message"></p>
                    <p id=",count_error" class="error-message"></p>
                    <p id="set_error" class="error-message"></p>
                </template>
              </div>
              <input type="hidden" name="update" id="one" >
        <!--ボタンをクリックしたらJavascriptファイル内の関数addForm()を実行する-->
                      <input type = "button" name="record" value="登録" id="submit2"
                      onclick="document.getElementById('one').value='update'; validateForm(event);">
                      <div class="bt_addForm">
                        <input type="button" value="+" onclick="addForm()">
                        <input type="button" id="deletebt" value="-" onclick="deleteLastRecord()">
                      </div>

                      </form>
                      <br>
                      <div class="levelUp">
                      	${level_up}
                      </div>
        <!-- 画面下部メニューバー表示 -->
            <div class="menu">
                <ul>
                    <li class="list active">
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
                    <li class="list">
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

               <!-- <script src="calendar.js"></script> -->
                <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
                <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

        <script src="./js/common.js"></script>
        <script src="./js/training_record.js"></script>
        </body>
        </html>