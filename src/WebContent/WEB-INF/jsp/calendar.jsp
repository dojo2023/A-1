<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Datepickerカレンダー</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<style>
		/* 予定のある日の枠の色 */
		.highlight {
		  background-color: red;
		}

		/* 表示箇所を真ん中にするCSS */
		.ui-datepicker {
			margin-left:30%;
		}
	</style>

<title>Calendar</title>
</head>
<body>
    <div id="app">
    <div id="datepicker"></div>

</div>

 <script>
	 var list = <%=new Gson().toJson(request.getAttribute("list")) %>;
	 var dates = [];
	 for (var i = 0; i < list.length; i++) {
		 var bean = list[i];
		 var ss = bean.trainingRecordDate.split(" ");
			var y = ss[2];
			var d = ss[1].replace(",", "");
			var m = ss[0].replace("月", "");

		 dates[i] =new Date( y+"-"+m+"-"+d);

	}

     //日付を擬似的に作成する（テストの為）
   /*   var dates = [];
     dates.push(new Date("2023-06-10"));
     dates.push(new Date("2023-06-10"));
     dates.push(new Date("2023-06-15"));
     dates.push(new Date("2023-06-24"));
 */


	//読み込まれた際に実行する
     $(document).ready(function() {
    	 //idがdatepickerのところに表示する
    	  $("#datepicker").datepicker({



    		//カレンダーに赤枠を表示するメソッド----------------------
    	    beforeShowDay: function(date) {
    	    //ループで配列に格納された日付のところを赤色にする
    	      for (var i = 0; i < dates.length; i++) {
    	    	//ひとつ取り出す
    	        var targetDate = dates[i];
				//もし合致するデータがあったら
    	        if (
    	          date.getFullYear() === targetDate.getFullYear() &&
    	          date.getMonth() === targetDate.getMonth() &&
    	          date.getDate() === targetDate.getDate()
    	        ) {
    	          //色を変える
    	          return [true, "highlight", "Custom text"];
    	        }
    	      }
			  //なんやろかよくわからん
    	      return [true, "", ""];
    	    },

	        //各dayをクリックした際に処理されるメソッド--------------------
	        onSelect: function(dateText, inst) {
	        	//クリックするたび、表示されたボックスを削除する
	        	 // .trainingListクラスの要素を取得
	        	  var trainingListElements = document.getElementsByClassName("trainingList");
	        	  // 要素が存在する場合にのみ削除処理を実行
	        	  if ( trainingListElements.length > 0) {
	        		  //作業途中のボックスのための確認ダイアログ
	        		  if (confirm("開いているボックスがあります。閉じてもよろしいですか？")) {
	        			  //消す
	        			  while ( trainingListElements.length > 0) {
	        				  trainingListElements[0].remove();
	    	        	  }
	        		  }else {
	        			 	return false;
	        		  }
	        	  }
	            // 押した日付を年、月、日で取得する
	            var ans = dateText.split("/");
	            var year = ans[2];
	            var month = ans[0];
	            var day = ans[1];

	            //合致しないフラグ
	            var flg=0;

	            //HTMLの作成
	            for (var i = 0; i < dates.length; i++) {
	            	//今日の日付と合致する予定があったかどうか
				  	if (
	          	          year == dates[i].getFullYear() &&
	          	          month == dates[i].getMonth()+1 &&
	          	          day == dates[i].getDate()
	          	        ) {
	            		 // 要素の作成（合致するものがあったので、データを入れる）
	    	            const divElement = document.createElement('div');
	    	            divElement.classList.add('trainingList');

	    	            const formElement = document.createElement('form');
	    	            formElement.action = '/jiro_power/Calendar_UpdateDeleteServlet';
	    	            formElement.method = 'POST';

						//トレーニングメニュー
	    	            const selectElementM = document.createElement('select');
	    	            selectElementM.name = 'trainingMenu';
	    	            selectElementM.classList.add ('trainingMenu');
	    	            //今回データを入れている場所
	    	             selectElementM.value =list[i].trainingMenu;

	    	            //トレーニングメニュー内容
	    	            	 //ベンチプレス

		    	            const benchPress = document.createElement("option");
		    	            benchPress.text = 'ベンチプレス';
		    	            benchPress.value = 'ベンチプレス';
		    	            if(list[i].trainingMenu=='ベンチプレス'){
		    	            	benchPress.setAttribute('selected','selected');
	    	            	}

	    	            //チェストプレス

		    	            const chestPress = document.createElement("option");
		    	            chestPress.text = 'チェストプレス';
		    	            chestPress.value = 'チェストプレス';
		    	            if(list[i].trainingMenu=='チェストプレス'){
		    	            	 chestPress.setAttribute('selected','selected')
		    	            }

		    	          //ダンベルフライ

		    	            const dumbbellFly = document.createElement("option");
		    	            dumbbellFly.text = 'ダンベルフライ';
		    	            dumbbellFly.value = 'ダンベルフライ';
		    	            if(list[i].trainingMenu=='ダンベルフライ'){
		    	            	 chestPress.setAttribute('selected','selected')
		    	            }


		    	          //ラットプルダウン
		    	            const latPullDown = document.createElement("option");
		    	            latPullDown.text = 'ラットプルダウン';
		    	            latPullDown.value = 'ラットプルダウン';
		    	            if(list[i].trainingMenu=='ラットプルダウン'){
		    	            	 chestPress.setAttribute('selected','selected')
		    	            }


		    	          //デッドリフト
		    	            const deadLift = document.createElement("option");
		    	            deadLift.text = 'デットリフト';
		    	            deadLift.value = 'デットリフト';
		    	            if(list[i].trainingMenu=='デットリフト'){
		    	            	 chestPress.setAttribute('selected','selected')
		    	            }


		    	          //スクワット
		    	            const squat = document.createElement("option");
		    	            squat.text = 'スクワット';
		    	            squat.value = 'スクワット';
		    	            if(list[i].trainingMenu=='スクワット'){
		    	            	 chestPress.setAttribute('selected','selected')
		    	            }


		    	          //レッグプレス
		    	            const legPress = document.createElement("option");
		    	            legPress.text = 'レッグプレス';
		    	            legPress.value = 'レッグプレス';
		    	            if(list[i].trainingMenu=='レッグプレス'){
		    	            	 chestPress.setAttribute('selected','selected')
		    	            }


		    	          //レッグエクステンション
		    	            const legExtension = document.createElement("option");
		    	            legExtension.text = 'レッグエクステンション';
		    	            legExtension.value = 'レッグエクステンション';
		    	            if(list[i].trainingMenu=='レッグエクステンション'){
		    	            	 chestPress.setAttribute('selected','selected')
		    	            }


		    	          //サイドレイズ
		    	            const sideRaise = document.createElement("option");
		    	            sideRaise.text = 'サイドレイズ';
		    	            sideRaise.value = 'サイドレイズ';
		    	            if(list[i].trainingMenu=='サイドレイズ'){
		    	            	 chestPress.setAttribute('selected','selected')
		    	            }


		    	          //フロントレイズ
		    	            const frontRaise = document.createElement("option");
		    	            frontRaise.text = 'フロントレイズ';
		    	            frontRaise.value = 'フロントレイズ';
		    	            if(list[i].trainingMenu=='チェストプレスフロントレイズ'){
		    	            	 chestPress.setAttribute('selected','selected')
		    	            }


		    	          //ショルダープレス
		    	            const shoulderPress = document.createElement("option");
		    	            shoulderPress.text = 'ショルダープレス';
		    	            shoulderPress.value = 'ショルダープレス';
		    	            if(list[i].trainingMenu=='ショルダープレス'){
		    	            	 chestPress.setAttribute('selected','selected')
		    	            }


		    	          //アームカール
		    	            const armCurl = document.createElement("option");
		    	            armCurl.text = 'アームカール';
		    	            armCurl.value = 'アームカール';
		    	            if(list[i].trainingMenu=='アームカール'){
		    	            	 chestPress.setAttribute('selected','selected')
		    	            }


		    	          //腹筋
		    	            const abdominal = document.createElement("option");
		    	            abdominal.text = '腹筋';
		    	            abdominal.value = '腹筋';
		    	            if(list[i].trainingMenu=='腹筋'){
		    	            	 chestPress.setAttribute('selected','selected')
		    	            }


		    	           //トレーニング重量
		    	            const inputElementW = document.createElement('input');
		    	            inputElementW.type = 'number';
		    	            inputElementW.name = 'trainingWeight';
		    	            inputElementW.classList.add ('trainingWeight');
		    	            //今回データを入れている場所
		    	            inputElementW.value =list[i].trainingWeight;

		    	            //トレーニング回数
		    	            const inputElementC = document.createElement('input');
		    	            inputElementC.type = 'number';
		    	            inputElementC.name = 'trainingCount';
		    	            inputElementC.classList.add ('trainingCount');
		    	            //今回データを入れている場所
		    	            inputElementC.value =list[i].trainingCount;

		    	            //トレーニングセット数
		    	            const inputElementS = document.createElement('input');
		    	            inputElementS.type = 'number';
		    	            inputElementS.name = 'trainingSet';
		    	            inputElementS.classList.add ('trainingSet');
		    	            //今回データを入れている場所
		    	            inputElementS.value =list[i].trainingSet;

		    	            //トレーニング経験値
		    	            const ElementE = document.createElement('div');
		    	            ElementE.className='trainingExp';
		    	            ElementE.innerHTML = list[i].trainingExp;

		    	          //トレーニングID(hidden)
		    	             const inputElementI = document.createElement('input');
		    	            inputElementI.hidden = 'number';
		    	            inputElementI.name = 'trainingRecordId';
		    	            inputElementI.classList.add ('trainingRecordId');
		    	            //今回データを入れている場所
		    	            inputElementI.value =list[i].trainingRecordId;


		    	            const submitElementU = document.createElement('input');
		    	            submitElementU.type = 'submit';
		    	            submitElementU.classList.add ('update');
		    	            submitElementU.name = 'update';
		    	            submitElementU.value = 'update';

		    	            const submitElementD = document.createElement('input');
		    	            submitElementD.type = 'submit';
		    	            submitElementD.classList.add ('delete');
		    	            submitElementD.name = 'delete';
		    	            submitElementD.value = 'delete';


		    	            formElement.appendChild(selectElementM);
		    	            selectElementM.appendChild(benchPress);
		    	            selectElementM.appendChild(chestPress);
		    	            selectElementM.appendChild(dumbbellFly);
		    	            selectElementM.appendChild(latPullDown);
		    	            selectElementM.appendChild(deadLift);
		    	            selectElementM.appendChild(squat);
		    	            selectElementM.appendChild(legPress);
		    	            selectElementM.appendChild(legExtension);
		    	            selectElementM.appendChild(sideRaise);
		    	            selectElementM.appendChild(frontRaise);
		    	            selectElementM.appendChild(shoulderPress);
		    	            selectElementM.appendChild(armCurl);
		    	            selectElementM.appendChild(abdominal);

		    	         	formElement.appendChild(inputElementW);
		    	            formElement.appendChild(inputElementC);
		    	            formElement.appendChild(inputElementS);
		    	            formElement.appendChild(inputElementI);
							divElement.appendChild(ElementE);
		    	            formElement.appendChild(submitElementU);
		    	            formElement.appendChild(submitElementD);

		    	            divElement.appendChild(formElement);



		    	            const bodyElement = document.querySelector('body');
		    	            bodyElement.appendChild(divElement);

		    	            flg++;
		          		 }
					 }
	            //HTMLの作成：合致するものが無かったら空の要素を作成する
	         	if(flg==0){
			  		// 要素の作成
	   	            const divElement = document.createElement('div');
	   	            divElement.classList.add('aaa');

	   	            const formElement = document.createElement('form');
	   	            formElement.action = '飛び先';
	   	            formElement.method = 'post';

	   	            const inputElement = document.createElement('input');
	   	            inputElement.type = 'text';
	   	            inputElement.name = 'date';
	   	         	//合致しなかったのでデータを入れなかった場所
	   	            inputElement.value ='';

	   	            const submitElement = document.createElement('input');
	   	            submitElement.type = 'submit';
	   	            submitElement.value = 'クリック';


  					formElement.appendChild(inputElementM);
  					formElement.appendChild(inputElementW);
	   	            formElement.appendChild(submitElement);

	   	            divElement.appendChild(formElement);

	   	            const bodyElement = document.querySelector('body');
	   	            bodyElement.appendChild(divElement);
			  	}
	         }
        });
    });
  </script>


</body>
</html>