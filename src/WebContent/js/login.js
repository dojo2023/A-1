/**
 *
 */


/*新しい目隠し機能*/

function pushHideButton() {
	var txtPass = document.getElementById("password");
	var btnEye = document.getElementById("buttonEye");
	if (txtPass.type === "text") {
		txtPass.type = "password";
		btnEye.className = "fa fa-eye";
	} else {
		txtPass.type = "text";
		btnEye.className = "fa fa-eye-slash";
	}
}


/* エラーメッセージ*/

// フォームの送信時に実行される関数
function validateForm(event) {
	  var mailAddress = document.getElementById("mail-address").value;
	  var password = document.getElementById("password").value;

	let n=0;
	// メールアドレスのチェック
	if (mailAddress == "") {
		document.getElementById("mail-address-error").textContent = "※メールアドレスが入力されていません。";
		n+=1;
	} else {
		document.getElementById("mail-address-error").textContent = ""; // エラーメッセージをクリア
	}

	// パスワードのチェック
	if (password === "") {
		document.getElementById("password-error").textContent = "※パスワードが入力されていません。";
		n+=1;
	} else if (password.length < 8) {
		document.getElementById("password-error").textContent = "※パスワードは8文字以上入力してください。";
		n+=1;
	} else {
		document.getElementById("password-error").textContent = ""; // エラーメッセージをクリア
	}

	if(n!=0){
		return false;
	}else{
		return true;
	}
}