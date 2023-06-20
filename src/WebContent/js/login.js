/**
 *
 */



	/*目隠し機能*/
	function togglePasswordVisibility() {
	  var passwordField = document.getElementById("pw");
	  var strikethrough = document.querySelector("#showPasswordLabel .strikethrough");

	  if (passwordField.type === "password") {
	    passwordField.type = "text";
	    strikethrough.style.display = "inline";
	  } else {
	    passwordField.type = "password";
	    strikethrough.style.display = "none";
	  }
	}

	var showPasswordLabel = document.getElementById("showPasswordLabel");
	showPasswordLabel.addEventListener("click", togglePasswordVisibility);



/* //目のアイコンがクリックされた時にパスワードフィールドの表示を切り替える関数
	function togglePasswordVisibility() {
	  var passwordField = document.getElementById("pw");

	  if (passwordField.type === "password") {
	    passwordField.type = "text";
	  } else {
	    passwordField.type = "password";
	  }
	}

  	// 目のアイコンのチェック状態に応じてパスワードフィールドの表示を切り替える
	var showPasswordCheckbox = document.getElementById("showPassword");
	showPasswordCheckbox.addEventListener("click", togglePasswordVisibility);*/




/* エラーメッセージ*/
/*  document.querySelector('form[name="form-login"]').addEventListener('submit', function(event) {
    var mailAddress = document.getElementById('mail_address').value;
    var password = document.getElementById('pw').value;
    var mailAddressError = document.getElementById('mail_address_error');
    var passwordError = document.getElementById('password_error');
    var isValid = true;

    mailAddressError.textContent = '';
    passwordError.textContent = '';

    if (mailAddress.trim() === '') {
      mailAddressError.textContent = '※メールアドレスが入力されていません。';
      isValid = false;
    }

    if (password.trim() === '') {
      passwordError.textContent = '※パスワードが入力されていません。';
      isValid = false;
    } else if (password.length < 8) {
      passwordError.textContent = '※パスワードは8文字以上入力してください。';
      isValid = false;
    }

    if (!isValid) {
      event.preventDefault(); // フォームの送信を中止
    }
  });

  */


// フォームの送信時に実行される関数
function validateForm(event) {

event.preventDefault(); // デフォルトのフォーム送信を防ぐ

  var mailAddress = document.getElementById("mail_address").value;
  var password = document.getElementById("pw").value;


// メールアドレスのチェック
if (mailAddress === "") {
  document.getElementById("mail_address_error").textContent = "※メールアドレスが入力されていません。";
  event.preventDefault(); // フォームの送信を中止
  return false;
} else if (!validateEmail(mailAddress)) {
  document.getElementById("mail_address_error").textContent = "※正しい形式のメールアドレスを入力してください。";
  event.preventDefault(); // フォームの送信を中止
  return false;
} else {
  document.getElementById("mail_address_error").textContent = ""; // エラーメッセージをクリア
}

// パスワードのチェック
if (password === "") {
  document.getElementById("password_error").textContent = "※パスワードが入力されていません。";
  event.preventDefault(); // フォームの送信を中止
  return false;
} else if (password.length < 8) {
  document.getElementById("password_error").textContent = "※パスワードは8文字以上入力してください。";
  event.preventDefault(); // フォームの送信を中止
  return false;
} else {
  document.getElementById("password_error").textContent = ""; // エラーメッセージをクリア
}
}
