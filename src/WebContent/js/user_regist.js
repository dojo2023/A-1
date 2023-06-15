/**
 *
 */






/* エラーメッセージ*/

// フォームの送信時に実行される関数
function validateForm(event) {

  var userName = document.getElementById("user_name").value;

  // ユーザー名のチェック
  if (userName === "") {
    document.getElementById("user_name_error").textContent = "ユーザー名が記入されていません。";
    event.preventDefault(); // フォームの送信を中止
    return false;
  }else{
  	 document.getElementById("user_name_error").textContent = "";
  }

	/*  if (userName === ""){

	  }*/

	/*  else if (userName === ""){

	  }*/

	/*  else if (userName === ""){

	  }*/

	/*  else if (userName === ""){

	  }*/

	/*  else if (userName === ""){

	  }*/

	/*  else if (userName === ""){

	  }*/

/*  else {
    document.getElementById("user_name_error").textContent = "";
  }
*/
  // 以下、他の項目のチェックを追加する

  return true; // フォームの送信を許可
}


/*

// 登録ボタンクリック時の処理
function showConfirmationDialog(event) {
  event.preventDefault(); // デフォルトのフォーム送信を防ぐ

  // フォームのバリデーションを実行
  if (validateForm(event)) {
    // 確認ダイアログを表示
    if (confirm("登録しますか？")) {
      // フォームを送信
      document.getElementById("myForm").submit(); // フォームを送信する
    }
  }
}


*/


// 登録ボタンクリック時の処理

 var dialog;

function showConfirmationDialog(event) {
  event.preventDefault(); // デフォルトのフォーム送信を防ぐ

  // フォームのバリデーションを実行
  if (validateForm(event)) {
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
			dialog.innerHTML = "登録しますか？<hr>";
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

}
}

/*
 var dialog; // ダイアログ要素の参照を保持する変数

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
			dialog.innerHTML = "登録しますか？<hr>";
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
		}

*/