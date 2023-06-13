/* 顔文字のドーナツチャートの部分の処理 */

let inputData ='${Expsum.rankingData}';
let context = document.querySelector("#kimochi").getContext('2d')
new Chart(context, {
  type: 'bar',
  data: {
    labels: ['1','2','3','4','5','6','7','8','9','10'],
    datasets: [{
      /* ここで取得した配列の中身を分解して配置する */
      data: [inputData[0], inputData[1],inputData[2],inputData[3],inputData[4],inputData[5],inputData[6],inputData[7],inputData[8],inputData[9]],
      backgroundColor: ['#5AFF19', '#5AFF19', '#5AFF19','#5AFF19','#5AFF19','#5AFF19','#5AFF19','#5AFF19','#5AFF19','#5AFF19'],
    }]
  },
  options: {
    responsive: false,
  }
});
