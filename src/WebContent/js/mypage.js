

/* エラーメッセージ*/
var dialog; // ダイアログ要素の参照を保持する変数
// フォームの送信時に実行される関数
function myPageValidateForm(event) {
	alert("aa");
  var userName = document.getElementById("user_name").value;
  var height = document.getElementById("height").value;
  var weight = document.getElementById("weight").value;
  var flgNumber=0;

  // ユーザー名のチェック
  if (userName === "") {
    document.getElementById("user_name_error").textContent = "※ユーザー名が入力されていません。";
    event.preventDefault(); // フォームの送信を中止
	flgNumber+=1;
  }else{
  	 document.getElementById("user_name_error").textContent = "";
  }
  // 身長のチェック
  if (height === "") {
    document.getElementById("height_error").textContent = "※身長が入力されていません。";
    event.preventDefault(); // フォームの送信を中止
	flgNumber+=1;
  }else if (!Number.isInteger(Number(height))) {
	  document.getElementById("height_error").textContent = "※身長は整数で入力してください。";
	  event.preventDefault(); // フォームの送信を中止
	  return false;
  }else if(height > 300){
    document.getElementById("height_error").textContent = "※適正な値が入力されていません。";
  	event.preventDefault(); // フォームの送信を中止
    return false;

  }else{
  	 document.getElementById("height_error").textContent = "";
  }


  // 体重のチェック
  if (weight === "") {
    document.getElementById("weight_error").textContent = "※体重が入力されていません。";
    event.preventDefault(); // フォームの送信を中止
	flgNumber+=1;
  } else if (!Number.isInteger(Number(weight))) {
	  document.getElementById("weight_error").textContent = "※体重は整数で入力してください。";
	  event.preventDefault(); // フォームの送信を中止
	  return false;
  }else if(weight > 300){
  	document.getElementById("weight_error").textContent = "※適正な値が入力されていません。";
  	event.preventDefault(); // フォームの送信を中止
    return false;

   }else if(weight < 30){
    document.getElementById("weight_error").textContent = "※体重は30kg以上で入力してください。";
  	event.preventDefault(); // フォームの送信を中止
    return false;

   }else{
  	 document.getElementById("weight_error").textContent = "";
  }



/*  else {
    document.getElementById("user_name_error").textContent = "";
  }
*/
	if(flgNumber==0){
 			 event.preventDefault(); // デフォルトのフォーム送信を防ぐ

		  // フォームのバリデーションを実行
		  /*if (validateForm(event)) {*/

		   /* // 確認ダイアログを表示
		    if (confirm("登録しますか？")) {
		      // フォームを送信
		      document.getElementById("myForm").submit(); // フォームを送信する
		    }*/


 		 if (dialog) {
				// 既存のダイアログが存在する場合は削除する
				dialog.remove();
			}
			//<div></div>タグを作り出す　dialogという変数に格納
			dialog = document.createElement("div");
			//その中に文字列を入れる
			dialog.innerHTML = "この内容で登録しますか？<hr>";
			//CSSをあとで適用させるので、上記のdivタグにクラスをつける
			dialog.className = "custom-dialog";

            var closeButton = document.createElement("button");
            closeButton.innerHTML = "×";
            closeButton.className = "close-button";
            closeButton.onclick = function() {
                dialog.style.display = "none";
            };

            dialog.appendChild(closeButton);

			//<input type="button">を作成する　confirmButtonという変数に格納
			var confirmButton = document.createElement("button");
			//上記のボタンの中に文字列を入れる
			confirmButton.innerHTML = "はい";
			//ボタンへのCSSの適用
			confirmButton.className = "yes-button";
			confirmButton.classList.add("btn-1");

			//その文字列が押されたときの処理も書いておく
			confirmButton.onclick = function() {
				dialog.style.display = "none";
				//formに記載されたURLへ画面遷移する
				document.getElementById("myForm").submit(); // フォームを送信する
			};

			//<input type="button">を作成する cancelButtonという変数に格納
			var cancelButton = document.createElement("button");
			//上記のボタンに文字列を入れる
			cancelButton.innerHTML = "いいえ";
			//ボタンへのCSSの適用
			cancelButton.className = "no_button";
			cancelButton.classList.add("btn-2");
			//そのボタンが押されたときの処理を書いておく
			cancelButton.onclick = function() {
				//何もせずにその画面にとどまる
				dialog.style.display = "none";
			};


			//ダイアログボックスの子要素（中身）にYESとNOのボタンを格納する
			dialog.appendChild(confirmButton);

			dialog.appendChild(cancelButton);




			//そのダイアログボックスをbodyの一番うしろに表示する
			document.body.appendChild(dialog);

	/*}*/
 	}else{
 		return false;
 	}
}



/*  ダイアログ表示*/


		//ボタンを押したときに呼び出される関数
		function showConfirmationDialog(event) {
			event.preventDefault(); // デフォルトのフォーム送信を防ぐ

			if (dialog) {
				// 既存のダイアログが存在する場合は削除する
				dialog.remove();
			}
			//<div></div>タグを作り出す　dialogという変数に格納
			dialog = document.createElement("div");
			//その中に文字列を入れる
			dialog.innerHTML = "実行するのかい？しないのかい？？？<hr>";
			//CSSをあとで適用させるので、上記のdivタグにクラスをつける
			dialog.className = "custom-dialog";

            var closeButton = document.createElement("button");
            closeButton.innerHTML = "×";
            closeButton.className = "close-button";
            closeButton.onclick = function() {
                dialog.style.display = "none";
            };

            dialog.appendChild(closeButton);

			//<input type="button">を作成する　confirmButtonという変数に格納
			var confirmButton = document.createElement("button");
			//上記のボタンの中に文字列を入れる
			confirmButton.innerHTML = "YES";
			//ボタンへのCSSの適用
			confirmButton.className = "yes-button";
			confirmButton.classList.add("btn-1");

			//その文字列が押されたときの処理も書いておく
			confirmButton.onclick = function() {
				dialog.style.display = "none";
				//formに記載されたURLへ画面遷移する
				document.getElementById("myForm").submit(); // フォームを送信する
			};

			//<input type="button">を作成する cancelButtonという変数に格納
			var cancelButton = document.createElement("button");
			//上記のボタンに文字列を入れる
			cancelButton.innerHTML = "NO";
			//ボタンへのCSSの適用
			cancelButton.className = "no_button";
			cancelButton.classList.add("btn-2");
			//そのボタンが押されたときの処理を書いておく
			cancelButton.onclick = function() {
				//何もせずにその画面にとどまる
				dialog.style.display = "none";
			};

			/* 画像の詳細設定 */s
			var img1 = document.createElement("img");
			img1.src = "./img/R0020071.png";
			img1.width = 70; // 幅を200ピクセルに指定
			img1.height = 80; // 高さを150ピクセルに指定
			img1.className = "img_cl";



			//ダイアログボックスの子要素（中身）にYESとNOのボタンを格納する
			dialog.appendChild(confirmButton);

			dialog.appendChild(cancelButton);
			//画像を配置する
			dialog.appendChild(img1);




			//そのダイアログボックスをbodyの一番うしろに表示する
			document.body.appendChild(dialog);
		}



/* テスト用　時計
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

*/