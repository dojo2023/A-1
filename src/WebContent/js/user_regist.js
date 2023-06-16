/**
 *
 */






/* エラーメッセージ*/

// フォームの送信時に実行される関数
function validateForm(event) {

  var userName = document.getElementById("user_name").value;
  var mailAddress = document.getElementById("mail_address").value;
  var password = document.getElementById("password").value;
  var birth = document.getElementById("birth").value;
  var height = document.getElementById("height").value;
  var weight = document.getElementById("weight").value;


  // ユーザー名のチェック
  if (userName === "") {
    document.getElementById("user_name_error").textContent = "※ユーザー名が入力されていません。";
    event.preventDefault(); // フォームの送信を中止
    return false;
  }else{
  	 document.getElementById("user_name_error").textContent = "";
  }

  // メールアドレスのチェック
  if (mailAddress === "") {
    document.getElementById("mail_address_error").textContent = "※メールアドレスが入力されていません。";
    event.preventDefault(); // フォームの送信を中止
    return false;
  }else if (!validateEmail(mailAddress)) {
    document.getElementById("mail_address_error").textContent = "※正しい形式のメールアドレスを入力してください。";
    event.preventDefault(); // フォームの送信を中止
    return false;
  }else{
  	 document.getElementById("mail_address_error").textContent = "";
  }

  // パスワードのチェック
  if (password === "") {
    document.getElementById("password_error").textContent = "※パスワードが入力されていません。";
    event.preventDefault(); // フォームの送信を中止
    return false;
  }else if(password.length < 8) {
	document.getElementById("password_error").textContent = "※パスワードは8文字以上入力してください。";
	event.preventDefault(); // フォームの送信を中止
	  return false;
  }else{
  	 document.getElementById("password_error").textContent = "";
  }

// 生年月日のチェック
if (birth === "") {
  document.getElementById("birth_error").textContent = "※生年月日が入力されていません。";
  event.preventDefault(); // フォームの送信を中止
  return false;
} else {
  var currentDate = new Date();
  var selectedDate = new Date(birth);
  if (selectedDate > currentDate) {
    document.getElementById("birth_error").textContent = "※未来の日付は選択できません。";
    event.preventDefault(); // フォームの送信を中止
    return false;
  } else {
    document.getElementById("birth_error").textContent = "";
  }
}

  // 身長のチェック
  if (height === "") {
    document.getElementById("height_error").textContent = "※身長が入力されていません。";
    event.preventDefault(); // フォームの送信を中止
    return false;
  }else{
  	 document.getElementById("height_error").textContent = "";
  }


  // 体重のチェック
  if (weight === "") {
    document.getElementById("weight_error").textContent = "※体重が入力されていません。";
    event.preventDefault(); // フォームの送信を中止
    return false;
  }else{
  	 document.getElementById("weight_error").textContent = "";
  }


	/*  if (userName === ""){

	  }*/

	/*  if (userName === ""){

	  }*/

/*  else {
    document.getElementById("user_name_error").textContent = "";
  }
*/

  return true; // フォームの送信を許可
}

// メールアドレスの形式チェック
function validateEmail(email) {
  var regex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
  return regex.test(email);
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