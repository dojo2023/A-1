/**
 *
 */


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