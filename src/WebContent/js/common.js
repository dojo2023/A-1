/**
 *
 */
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
	dialog.innerHTML = "実行するのかい？しないのかい？？？<hr>";
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
		confirmButton.innerHTML = "YES";
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
		cancelButton.innerHTML = "NO";
	//ボタンへのCSSの適用
		cancelButton.className = "no_button";
		cancelButton.classList.add("btn-2");
	//そのボタンが押されたときの処理を書いておく
	cancelButton.onclick = function() {
		//何もせずにその画面にとどまる
		dialog.style.display = "none";
	};

	/* 画像の詳細設定 */
		var img1 = document.createElement("img");
		img1.src = "./img/R0020071.png";
		img1.width = 70; // 幅を200ピクセルに指定
		img1.height = 80; // 高さを150ピクセルに指定
		img1.className = "img_cl";

	//ダイアログボックスの子要素（中身）にYESとNOのボタンを格納する
		dialog.appendChild(confirmButton);

		dialog.appendChild(cancelButton);

	//画像を配置する
		dialog.appendChild(img1);


	//そのダイアログボックスをbodyの一番うしろに表示する
		document.body.appendChild(dialog);

	//メニューバー
		const list = document.querySelectorAll('.list');
	function activeLink(){
		list.forEach((item) =>
			item.classList.remove('active'));
		this.classList.add('active');
	}
		list.forEach((item) =>
			item.addEventListener('click',activeLink));



}