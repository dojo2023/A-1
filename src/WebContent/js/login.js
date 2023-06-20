/**
 *
 */


/*新しい目隠し機能*/

      function pushHideButton() {
        var txtPass = document.getElementById("textPassword");
        var btnEye = document.getElementById("buttonEye");
        if (txtPass.type === "text") {
          txtPass.type = "password";
          btnEye.className = "fa fa-eye";
        } else {
          txtPass.type = "text";
          btnEye.className = "fa fa-eye-slash";
        }
      }

/*
	目隠し機能
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

*/






	/* エラーメッセージ*/

	// フォームの送信時に実行される関数
	function validateForm(event) {
		alert("アラートだよ");

		/*event.preventDefault(); // デフォルトのフォーム送信を防ぐ*/

		  var mailAddress = document.getElementById("mail_address").value;
		  var password = document.getElementById("textPassword").value;
		  alert(mailAddress);

		let n=0;
		// メールアドレスのチェック
		if (mailAddress == "") {
		alert("if文はいったよ");
		  document.getElementById("mail_address_error").textContent = "※メールアドレスが入力されていません。";
		  /*event.preventDefault(); // フォームの送信を中止*/
		  n+=1;
		} else {
		  document.getElementById("mail_address_error").textContent = ""; // エラーメッセージをクリア
		}

		// パスワードのチェック
		if (password === "") {
		  document.getElementById("password_error").textContent = "※パスワードが入力されていません。";
		 /* event.preventDefault(); // フォームの送信を中止*/
		  n+=1;
		} else if (password.length < 8) {
		  document.getElementById("password_error").textContent = "※パスワードは8文字以上入力してください。";
		  /*event.preventDefault(); // フォームの送信を中止*/
		  n+=1;
		} else {
		  document.getElementById("password_error").textContent = ""; // エラーメッセージをクリア
		}

		if(n!=0){
			return false;
		}else{
			return true;
		}
	}

/*	// メールアドレスの形式チェック
	function validateEmail(email) {
	  var regex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
	  return regex.test(email);
	}*/


/*	else if (!validateEmail(mailAddress)) {
		  document.getElementById("mail_address_error").textContent = "※正しい形式のメールアドレスを入力してください。";
		  /*event.preventDefault(); // フォームの送信を中止
		  n+=1;
		}
*/




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