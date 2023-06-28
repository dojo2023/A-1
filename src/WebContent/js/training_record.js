/*ボタン再誕の儀(しなくてよくない？)
const form = document.getElementById("form");
const button = document.getElementById("submit");

form.addEventListener("input", update);
form.addEventListener("change", update);
function update() {
  const isRequired = form.checkValidity();

  if (isRequired) {
    button.disabled = false;
    return;
  } //if(isRequired)の閉じかっこ
}*/

let i = 1

function addForm() {
    // 5個で処理を終了
    if (i > 4) {
        return;

    } else {
        // HTMLからtemplate要素を取得
        const template = document.getElementById("form-template");

        // templateの内容を複製
        const new_form = template.content.cloneNode(true);


        //親要素を取得し 複製した要素を追加
        const parent = document.getElementById("input-form");
        parent.appendChild(new_form);

        i++;
    } //if(i>3),elseの閉じかっこ
} //function addForm()の閉じかっこ
		//ページ読み込み時に関数addForm()を実行
		window.addEventListener('DOMContentLoaded', addForm);

  function deleteLastRecord() {
      // 最後のレコード要素を取得
  var recordElements = document.getElementsByClassName('record');
  var lastRecord = recordElements[recordElements.length - 1];

    if(recordElements.length!=1) {
        // レコード要素を削除
         lastRecord.remove();
        i--;
    } //if(recordElements.length!=1)の閉じかっこ
    } //function deleteLastRecord()の閉じかっこ

/* エラーメッセージ*/

// フォームの送信時に実行される関数
function validateForm(event) {

  var date = document.getElementById("t_date").value;
  var weight = document.getElementById("training_weight").value;
  var count = document.getElementById("training_count").value;
  var set = document.getElementById("training_set").value;
  var flgNumber=0;

  // 日付のチェック
  if (date === "") {
    document.getElementById("date_error").textContent = "※日付が入力されていません。";
  event.preventDefault(); // フォームの送信を中止
  flgNumber+=1;
} else {
  var currentDate = new Date();
  var selectedDate = new Date(date);
  if (selectedDate > currentDate) {
    document.getElementById("date_error").textContent = "※未来の日付は選択できません。";
    event.preventDefault(); // フォームの送信を中止
    return false;
  } else {
    document.getElementById("date_error").textContent = "";
  }

  // 器具重量のチェック
  if (weight === "") {
    if (weight === "") {
    document.getElementById("weight_error").textContent = "※重量が入力されていません。";
    event.preventDefault(); // フォームの送信を中止
    flgNumber+=1;
  }else if(weight > 999){
  	document.getElementById("weight_error").textContent = "※適正な値が入力されていません。";
  	event.preventDefault(); // フォームの送信を中止
    return false;
   } else if(weight < 1){
    document.getElementById("weight_error").textContent = "※適正な値が入力されていません。";
  	event.preventDefault(); // フォームの送信を中止
    return false;

   }else {
  	 document.getElementById("weight_error").textContent = "";
  }

  // トレーニング回数のチェック
  if (count === "") {
    if (count === "") {
    document.getElementById("count_error").textContent = "※回数が入力されていません。";
    event.preventDefault(); // フォームの送信を中止
    flgNumber+=1;
  }else if(count > 999){
  	document.getElementById("count_error").textContent = "※適正な値が入力されていません。";
  	event.preventDefault(); // フォームの送信を中止
    return false;
   } else if(weight < 1){
    document.getElementById("count_error").textContent = "※適正な値が入力されていません。";
  	event.preventDefault(); // フォームの送信を中止
    return false;

   }else {
  	 document.getElementById("count_error").textContent = "";
  }

  // セット数のチェック
if (set === "") {
  if (set === "") {
    document.getElementById("set_error").textContent = "※セット数が入力されていません。";
    event.preventDefault(); // フォームの送信を中止
    flgNumber+=1;
  }else if(set > 999){
  	document.getElementById("set_error").textContent = "※適正な値が入力されていません。";
  	event.preventDefault(); // フォームの送信を中止
    return false;
   } else if(set < 1){
    document.getElementById("_error").textContent = "※適正な値が入力されていません。";
  	event.preventDefault(); // フォームの送信を中止
    return false;

   }else {
  	 document.getElementById("set_error").textContent = "";
  }


   // 登録ボタンクリック時の処理

 var dialog;

function showConfirmationDialog(event) {
  event.preventDefault(); // デフォルトのフォーム送信を防ぐ
 alert("non");
if(flgNumber==0){
 			 event.preventDefault(); // デフォルトのフォーム送信を防ぐ

  // フォームのバリデーションを実行
      /*if (validateForm(event)) {
	   // 確認ダイアログを表示
	    if (confirm("登録しますか？")) {
	      // フォームを送信
	      document.getElementById("form").submit(); // フォームを送信する*/
    }
}
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
				document.getElementById("form").submit(); // フォームを送信する
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

}}}}}