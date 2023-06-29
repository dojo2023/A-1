

// タイマー要素の取得
	const minsElement = document.querySelector('.mins');
	const secondsElement = document.querySelector('.seconds');

// セットボタンの取得
	const plusMinButton = document.querySelector('.plus-min');
	const minusMinButton = document.querySelector('.minus-min');
	const plusSecButton = document.querySelector('.plus-sec');
	const minusSecButton = document.querySelector('.minus-sec');

// スタートボタン、ストップボタン、リセットボタンの取得
	const startButton = document.querySelector('.btn-start');
	const stopButton = document.querySelector('.btn-stop');
	const resetButton = document.querySelector('.btn-reset');

	let timerInterval; // タイマーの間隔を格納する変数
	let minutes = 0; // 分を表す変数
	let seconds = 0; // 秒を表す変数

// タイマーの更新を表示する関数
function updateTimerDisplay() {
	minsElement.textContent = minutes.toLocaleString('en-US', { minimumIntegerDigits: 2, useGrouping: false });
	secondsElement.textContent = seconds.toLocaleString('en-US', { minimumIntegerDigits: 2, useGrouping: false });
}

// タイマーを開始する関数
function startTimer() {
	timerInterval = setInterval(() => {
	// 秒数を1つ減らす
	if (seconds > 0) {
		seconds--;
	} else {
		// 秒数が0になったら分を1つ減らし、秒数を59にする
		if (minutes > 0) {
			minutes--;
			seconds = 59;
		} else {
			// 分も0になったらタイマーを停止し、タイマー終了処理を実行する
			stopTimer();
			handleTimerEnd();
			return; // タイマー終了時に関数を終了する
		}
	}

	// タイマーの表示を更新する
	updateTimerDisplay();
	}, 1000);
}

// タイマーを停止する関数
function stopTimer() {
	clearInterval(timerInterval);
}

// タイマーをリセットする関数
function resetTimer() {
	stopTimer();
	minutes = 0;
	seconds = 0;
	updateTimerDisplay();
}

// セットボタンのクリックイベントリスナー
plusMinButton.addEventListener('click', () => {
	if (minutes < 60) {
		minutes++;
		updateTimerDisplay();
	}
});

minusMinButton.addEventListener('click', () => {
	if (minutes > 0) {
		minutes--;
		updateTimerDisplay();
	}
});

plusSecButton.addEventListener('click', () => {
	if (seconds < 59) {
		seconds++;
		updateTimerDisplay();
	}
});

minusSecButton.addEventListener('click', () => {
	if (seconds > 0) {
		seconds--;
		updateTimerDisplay();
	}
});

// スタートボタン、ストップボタン、リセットボタンのクリックイベントリスナー
startButton.addEventListener('click', () => {
	startTimer();
});

stopButton.addEventListener('click', () => {
	stopTimer();
});

resetButton.addEventListener('click', () => {
	resetTimer();
});

// 初期表示のタイマーを更新する
	updateTimerDisplay();

// タイマーが0になったときの処理を追加する
function handleTimerEnd() {
	// タイマー終了音を再生する
	const audio = new Audio('./js/cyber.mp3');  /*/jiro_power/cyber.mp3*/
	audio.play();
}