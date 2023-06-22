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
  }
}*/

let i = 1

function addForm() {
    // 5個で処理を終了
    if (i > 3) {
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
    }
}
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
    }
    }