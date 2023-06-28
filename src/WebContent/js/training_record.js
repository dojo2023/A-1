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

   // 登録ボタンクリック時の処理

 var dialog;

function showConfirmationDialog(event) {
  event.preventDefault(); // デフォルトのフォーム送信を防ぐ

  // フォームのバリデーションを実行
 /* if (validateForm(event)) {
	    // 確認ダイアログを表示
	    if (confirm("登録しますか？")) {
	      // フォームを送信
	      document.getElementById("form").submit(); // フォームを送信する
    }
*/

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


}
