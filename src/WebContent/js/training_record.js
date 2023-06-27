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
    if (i > 5) {
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

/*
var dialog;

function showConfirmationDialog(event) {
  event.preventDefault(); // デフォルトのフォーム送信を防ぐ


  if (dialog) {
				// 既存のダイアログが存在する場合は削除する
				dialog.remove();
			} //if(dialog)の閉じかっこ
			//<div></div>タグを作り出す　dialogという変数に格納
			dialog = document.createElement("div");
			//その中に文字列を入れる
			dialog.innerHTML = '<%=request.getAttribute("levelUp") %>';
			//CSSをあとで適用させるので、上記のdivタグにクラスをつける
			dialog.className = "custom-dialog";

            var closeButton = document.createElement("button");
            closeButton.innerHTML = "×";
            closeButton.className = "close-button";
            closeButton.onclick = function() {
                dialog.style.display = "none";
            }; //closeButton.onclickの閉じかっこ

            dialog.appendChild(closeButton);

			//<input type="button">を作成する　confirmButtonという変数に格納
			var confirmButton = document.createElement("button");
			//上記のボタンの中に文字列を入れる
			confirmButton.innerHTML = "OK";
			//ボタンへのCSSの適用
			confirmButton.className = "ok-button";
			confirmButton.classList.add("btn-1");

			//その文字列が押されたときの処理も書いておく
			confirmButton.onclick = function() {
				dialog.style.display = "none";
				//formに記載されたURLへ画面遷移する
				document.getElementById("myForm").submit(); // フォームを送信する
			}; //confirmButton.onclickの閉じかっこ


			//ダイアログボックスの子要素（中身）にOKボタンを格納する
			dialog.appendChild(confirmButton);




			//そのダイアログボックスをbodyの一番うしろに表示する
			document.body.appendChild(dialog);
}
*/
