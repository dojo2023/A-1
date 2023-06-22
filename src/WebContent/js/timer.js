

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
        /*audio.play();*/
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

/*タイマーが0になったときにcircleを3秒間赤色に変える*/
/*	const circleElement = document.querySelector('.wrapper p::before');
	circleElement.classList.add('timer-end');

	setTimeout(() => {
    	circleElement.classList.remove('timer-end');
  	}, 3000);
*/

  // タイマー終了時のエフェクトや音声
  // タイマー要素のスタイルを変更してエフェクトを追加
/*  minsElement.style.color = 'red';
  secondsElement.style.color = 'red';*/

  // タイマー終了音を再生する
  const audio = new Audio('./js/cyber.mp3');  /*/jiro_power/cyber.mp3*/
  audio.play();
}

/*function handleTimerEnd() {
  const circleElement = document.querySelector('.wrapper p::before');
  circleElement.classList.add('timer-end');

  setTimeout(() => {
    circleElement.classList.remove('timer-end');
  }, 3000);
}
*/





/*飯田君タイマーJS*/
/*
const semicircles = document.querySelectorAll('.semicircle');
const timer = document.querySelector('.timer');

//input
const hr = 0;
const min = 0;
const sec = 10;

const hours = hr * 3600000;
const minutes = min * 60000;
const seconds = sec * 1000;
const setTime = hours + minutes + seconds;
const starTime = Date.now();
const futureTime = starTime + setTime;


const timerLoop = setInterval(countDownTimer);
countDownTimer();


function countDownTimer(){
    const currentTime = Date.now();
    const remainingTime = futureTime - currentTime;
    const angle = (remainingTime / setTime) * 360


    //progress indicator
    if(angle >180) {
        semicircles[2].style.display = 'none';
        semicircles[0].style.transform = 'rotate(180deg)';
        semicircles[1].style.transform = `rotate(${angle}deg)`;
    } else {
        semicircles[2].style.display = 'block';
        semicircles[0].style.transform = `rotate(${angle}deg)`;
        semicircles[1].style.transform = `rotate(${angle}deg)`;

    }
    //timer
    const hrs = Math.floor((remainingTime / (1000 * 60 * 60))%24).toLocaleString('en-US',{minimumIntegerDigits:2, useGrouping:false});
    const mins = Math.floor((remainingTime / (1000 * 60)) % 60).toLocaleString('en-US',{minimumIntegerDigits:2, useGrouping:false});
    const secs = Math.floor((remainingTime / 1000) % 60).toLocaleString('en-US',{minimumIntegerDigits:2, useGrouping:false});
    timer.innerHTML = `
    <div>${hrs}</div>
    <div class="colon">:</div>
    <div>${mins}<div>
    <div>:<div>
    <div>${secs}</div>
    `;


    //5sec-condition
    if(remainingTime <= 6000){
        semicircles[0].style.backgroundColor = "red"
        semicircles[1].style.backgroundColor = "red"
        timer.style.color = "red"
    }

    //end
    if(remainingTime < 0) {
        clearInterval(timerLoop);
        semicircles[0].style.display = 'none';
        semicircles[1].style.display = 'none';
        semicircles[2].style.display = 'none';

        timer.innerHTML = `
        <div>00</div>
        <div class="colon">:</div>
        <div>00<div>
        <div class="colon">:</div>
        <div>00</div>
        `;
    }
}
*/