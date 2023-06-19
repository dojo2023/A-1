//ボタン再誕の儀
const form = document.getElementById("form");
const button = document.getElementById("button");

form.addEventListener("input", update);
form.addEventListener("change", update);
function update() {
  const isRequired = form.checkValidity();

  if (isRequired) {
    button.disabled = false;
    return;
  }
}

let i = 1

function addForm() {
    // 8人以上なら処理を終了する
    if (i > 5) {
        return;

    } else {
        // HTMLからtemplate要素を取得
        const template = document.getElementById("form-template");

        // templateの内容を複製
        const new_form = template.content.cloneNode(true);

        // 子要素を指定しname属性の値を変更
        const new_form_date = new_form.children[0].children[0];
        new_form_date.id = 'date-'+i;

        const new_form_menu = new_form.children[0].children[1];
        new_form_menu.id = 'menu-'+i;

        const new_form_weight = new_form.children[0].children[2];
        new_form_weight.id = 'weight-'+i;

        const new_form_count = new_form.children[0].children[3];
        new_form_count.id = 'count-'+i;

        const new_form_set = new_form.children[0].children[4];
        new_form_set.id = 'set-'+i;


        //親要素を取得し 複製した要素を追加
        const parent = document.getElementById("input-form");
        parent.appendChild(new_form);

       //インデント番号を更新
        i++;
    }
}
		//ページ読み込み時に関数addForm()を実行
		window.addEventListener('DOMContentLoaded', addForm);

