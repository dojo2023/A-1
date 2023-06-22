const week = ["日", "月", "火", "水", "木", "金", "土"];
const today = new Date();
// 月末だとずれる可能性があるため、1日固定で取得
var showDate = new Date(today.getFullYear(), today.getMonth(), 1);

// 初期表示
window.onload = function () {
    showProcess(today, calendar);
};
// 前の月表示
function prev(){
    showDate.setMonth(showDate.getMonth() - 1);
    showProcess(showDate);
}

// 次の月表示
function next(){
    showDate.setMonth(showDate.getMonth() + 1);
    showProcess(showDate);
}

// カレンダー表示
function showProcess(date) {
    var year = date.getFullYear();
    var month = date.getMonth();
    document.querySelector('#header').innerHTML = year + "年 " + (month + 1) + "月";

    var calendar = createProcess(year, month);
    document.querySelector('#calendar').innerHTML = calendar;
}

// カレンダー作成
function createProcess(year, month) {
    // 曜日
    var calendar = "<table><tr class='dayOfWeek'>";
    for (var i = 0; i < week.length; i++) {
        calendar += "<th>" + week[i] + "</th>";
    }
    calendar += "</tr>";

    var count = 0;
    var startDayOfWeek = new Date(year, month, 1).getDay();
    var endDate = new Date(year, month + 1, 0).getDate();
    var lastMonthEndDate = new Date(year, month, 0).getDate();
    var row = Math.ceil((startDayOfWeek + endDate) / week.length);

    // 1行ずつ設定
    for (var i = 0; i < row; i++) {
        calendar += "<tr>";
        // 1colum単位で設定
        for (var j = 0; j < week.length; j++) {
            if (i == 0 && j < startDayOfWeek) {
                // 1行目で1日まで先月の日付を設定
                calendar += "<td class='disabled'>" + (lastMonthEndDate - startDayOfWeek + j + 1) + "</td>";
            } else if (count >= endDate) {
                // 最終行で最終日以降、翌月の日付を設定
                count++;
                calendar += "<td class='disabled'>" + (count - endDate) + "</td>";
            } else {
                // 当月の日付を曜日に照らし合わせて設定
                count++;
                if(year == today.getFullYear()
                  && month == (today.getMonth())
                  && count == today.getDate()){
                    calendar += "<td class='today'>" + count + "</td>";
                } else {
					//表示したい項目がある場合は、ここでリンクを設定する
                    calendar += "<td>" + count + "<br>"
                    +"<a href=''>テスト文字列"+year+"</a>"
                    +"</td>";

                }
            }
        }
        calendar += "</tr>";
    }
    return calendar;
}

	const week = ["日", "月", "火", "水", "木", "金", "土"];
	const today = new Date();
	// 月末だとずれる可能性があるため、1日固定で取得
	var showDate = new Date(today.getFullYear(), today.getMonth(), 1);

	// 初期表示
	window.onload = function () {
	    showProcess(today, calendar);
	};
	// 前の月表示
	function prev(){
	    showDate.setMonth(showDate.getMonth() - 1);
	    showProcess(showDate);
	}

	// 次の月表示
	function next(){
	    showDate.setMonth(showDate.getMonth() + 1);
	    showProcess(showDate);
	}

	// カレンダー表示
	function showProcess(date) {
	    var year = date.getFullYear();
	    var month = date.getMonth();
	    document.querySelector('#header').innerHTML = year + "年 " + (month + 1) + "月";

	    var calendar = createProcess(year, month);
	    document.querySelector('#calendar').innerHTML = calendar;
	}

	//クラス付与
		const td = document.querySelectorAll('.btn');
	function activeLink(){
	td.forEach((item) =>
	item.classList.remove('active'));
	this.classList.add('active');
	}
	td.forEach((item) =>
	item.addEventListener('click',activeLink));



	// カレンダー作成
	function createProcess(year, month) {
	    // 曜日
	    var calendar = "<table><tr class='dayOfWeek'>";
	    for (var i = 0; i < week.length; i++) {
	        calendar += "<th>" + week[i] + "</th>";
	    }
	    calendar += "</tr>";

	    var count = 0;
	    var startDayOfWeek = new Date(year, month, 1).getDay();
	    var endDate = new Date(year, month + 1, 0).getDate();
	    var lastMonthEndDate = new Date(year, month, 0).getDate();
	    var row = Math.ceil((startDayOfWeek + endDate) / week.length);
	    var list = [{"training_record_id":1,"training_record_date":"6月 13, 2023","user_id":1,"training_menu":"ベンチプレス","training_weight":60.0,"training_count":10,"training_set":3,"training_exp":90},{"training_record_id":2,"training_record_date":"6月 15, 2023","user_id":2,"training_menu":"チェストプレス","training_weight":30.0,"training_count":20,"training_set":2,"training_exp":15},{"training_record_id":3,"training_record_date":"6月 22, 2023","user_id":3,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":2,"training_exp":10},{"training_record_id":4,"training_record_date":"6月 22, 2023","user_id":4,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":2,"training_exp":10},{"training_record_id":5,"training_record_date":"6月 22, 2023","user_id":5,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":2,"training_exp":10},{"training_record_id":6,"training_record_date":"6月 22, 2023","user_id":6,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":10,"training_set":2,"training_exp":12},{"training_record_id":7,"training_record_date":"6月 22, 2023","user_id":7,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":10,"training_set":2,"training_exp":12},{"training_record_id":8,"training_record_date":"6月 22, 2023","user_id":8,"training_menu":"ベンチプレス","training_weight":60.0,"training_count":20,"training_set":1,"training_exp":15},{"training_record_id":9,"training_record_date":"6月 22, 2023","user_id":9,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":20,"training_set":3,"training_exp":38},{"training_record_id":10,"training_record_date":"6月 22, 2023","user_id":10,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":10,"training_set":2,"training_exp":12},{"training_record_id":11,"training_record_date":"6月 22, 2023","user_id":11,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":3,"training_exp":15},{"training_record_id":12,"training_record_date":"6月 22, 2023","user_id":12,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":3,"training_exp":15},{"training_record_id":13,"training_record_date":"6月 22, 2023","user_id":13,"training_menu":"ベンチプレス","training_weight":30.0,"training_count":10,"training_set":3,"training_exp":11},{"training_record_id":14,"training_record_date":"6月 22, 2023","user_id":14,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":20,"training_set":3,"training_exp":30}];
	    // 1行ずつ設定
	    for (var i = 0; i < row; i++) {
	        calendar += "<tr>";
	        // 1colum単位で設定
	        for (var j = 0; j < week.length; j++) {
	            if (i == 0 && j < startDayOfWeek) {
	                // 1行目で1日まで先月の日付を設定
	                calendar += "<td class='disabled'>" + (lastMonthEndDate - startDayOfWeek + j + 1) + "</td>";
	            } else if (count >= endDate) {
	                // 最終行で最終日以降、翌月の日付を設定
	                count++;
	                calendar += "<td class='disabled'>" + (count - endDate) + "</td>";
	            } else {
	                // 当月の日付を曜日に照らし合わせて設定
	                count++;
	                console.log("year"+year+"::"+today.getFullYear());

	                if(year == today.getFullYear() && month == (today.getMonth())&& count == today.getDate()){
	                	var list = [{"training_record_id":1,"training_record_date":"6月 13, 2023","user_id":1,"training_menu":"ベンチプレス","training_weight":60.0,"training_count":10,"training_set":3,"training_exp":90},{"training_record_id":2,"training_record_date":"6月 15, 2023","user_id":2,"training_menu":"チェストプレス","training_weight":30.0,"training_count":20,"training_set":2,"training_exp":15},{"training_record_id":3,"training_record_date":"6月 22, 2023","user_id":3,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":2,"training_exp":10},{"training_record_id":4,"training_record_date":"6月 22, 2023","user_id":4,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":2,"training_exp":10},{"training_record_id":5,"training_record_date":"6月 22, 2023","user_id":5,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":2,"training_exp":10},{"training_record_id":6,"training_record_date":"6月 22, 2023","user_id":6,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":10,"training_set":2,"training_exp":12},{"training_record_id":7,"training_record_date":"6月 22, 2023","user_id":7,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":10,"training_set":2,"training_exp":12},{"training_record_id":8,"training_record_date":"6月 22, 2023","user_id":8,"training_menu":"ベンチプレス","training_weight":60.0,"training_count":20,"training_set":1,"training_exp":15},{"training_record_id":9,"training_record_date":"6月 22, 2023","user_id":9,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":20,"training_set":3,"training_exp":38},{"training_record_id":10,"training_record_date":"6月 22, 2023","user_id":10,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":10,"training_set":2,"training_exp":12},{"training_record_id":11,"training_record_date":"6月 22, 2023","user_id":11,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":3,"training_exp":15},{"training_record_id":12,"training_record_date":"6月 22, 2023","user_id":12,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":3,"training_exp":15},{"training_record_id":13,"training_record_date":"6月 22, 2023","user_id":13,"training_menu":"ベンチプレス","training_weight":30.0,"training_count":10,"training_set":3,"training_exp":11},{"training_record_id":14,"training_record_date":"6月 22, 2023","user_id":14,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":20,"training_set":3,"training_exp":30}];
	                	 calendar += "<td class = 'today'>" +"<a href='#' onclick = 'click()' >"+count+"</a>"+ "</td>" ;
	            		/*for(var i=0;i<list.length;i++){
	            			var bean = list[i];
	            			var date = new Date(bean.training_record_date);
	            			var ss = bean.training_record_date.split(" ");
	            			var y = ss[2];
	            			var d = ss[1].replace(",","");
	            			var m = ss[0].replace("月","");


	            			if(year==y && (month+1)==m && count==d){
	            				calendar +="<a href='#' javascript:OnLinkClick='Record(bean)'></a>	</td>";
	            			}else{
	            				calendar +="<a href='#' javascript:OnLinkClick='Record(bean)'></a>	</td>";
	            			}
	            		}
 */
	                } else {
	                	var list = [{"training_record_id":1,"training_record_date":"6月 13, 2023","user_id":1,"training_menu":"ベンチプレス","training_weight":60.0,"training_count":10,"training_set":3,"training_exp":90},{"training_record_id":2,"training_record_date":"6月 15, 2023","user_id":2,"training_menu":"チェストプレス","training_weight":30.0,"training_count":20,"training_set":2,"training_exp":15},{"training_record_id":3,"training_record_date":"6月 22, 2023","user_id":3,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":2,"training_exp":10},{"training_record_id":4,"training_record_date":"6月 22, 2023","user_id":4,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":2,"training_exp":10},{"training_record_id":5,"training_record_date":"6月 22, 2023","user_id":5,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":2,"training_exp":10},{"training_record_id":6,"training_record_date":"6月 22, 2023","user_id":6,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":10,"training_set":2,"training_exp":12},{"training_record_id":7,"training_record_date":"6月 22, 2023","user_id":7,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":10,"training_set":2,"training_exp":12},{"training_record_id":8,"training_record_date":"6月 22, 2023","user_id":8,"training_menu":"ベンチプレス","training_weight":60.0,"training_count":20,"training_set":1,"training_exp":15},{"training_record_id":9,"training_record_date":"6月 22, 2023","user_id":9,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":20,"training_set":3,"training_exp":38},{"training_record_id":10,"training_record_date":"6月 22, 2023","user_id":10,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":10,"training_set":2,"training_exp":12},{"training_record_id":11,"training_record_date":"6月 22, 2023","user_id":11,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":3,"training_exp":15},{"training_record_id":12,"training_record_date":"6月 22, 2023","user_id":12,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":3,"training_exp":15},{"training_record_id":13,"training_record_date":"6月 22, 2023","user_id":13,"training_menu":"ベンチプレス","training_weight":30.0,"training_count":10,"training_set":3,"training_exp":11},{"training_record_id":14,"training_record_date":"6月 22, 2023","user_id":14,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":20,"training_set":3,"training_exp":30}];
	                	calendar += "<td class = 'otherdays'> "+"<a onclick = 'click()'>"+count+"</a>" +"</td>";
	                	/* for(var i=0;i<list.length;i++){
	            			var bean = list[i];
	            			var date = new Date(bean.training_record_date);
	            			var ss = bean.training_record_date.split(" ");
	            			var y = ss[2];
	            			var d = ss[1].replace(",","");
	            			var m = ss[0].replace("月","");


	            			if(year==y && (month+1)==m && count==d){
	            				calendar +="<a href='#' javascript:OnLinkClick='Record(bean)'></a>	</td>";
	            			}else{
	            				calendar +="<a href='#' javascript:OnLinkClick='Record(bean)'></a>	</td>";
	            			}
	            		}
 */
		               /*  calendar += "<td class = 'otherdays' onclick = 'click(count)'>" + count  +" </td>"; */


	                }
	            }
	        }
	        calendar += "</tr>";
	    }
	    return calendar;
	}
	//クリック時のイベント
	function click(){
		alert('Click');
		var list = [{"training_record_id":1,"training_record_date":"6月 13, 2023","user_id":1,"training_menu":"ベンチプレス","training_weight":60.0,"training_count":10,"training_set":3,"training_exp":90},{"training_record_id":2,"training_record_date":"6月 15, 2023","user_id":2,"training_menu":"チェストプレス","training_weight":30.0,"training_count":20,"training_set":2,"training_exp":15},{"training_record_id":3,"training_record_date":"6月 22, 2023","user_id":3,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":2,"training_exp":10},{"training_record_id":4,"training_record_date":"6月 22, 2023","user_id":4,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":2,"training_exp":10},{"training_record_id":5,"training_record_date":"6月 22, 2023","user_id":5,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":2,"training_exp":10},{"training_record_id":6,"training_record_date":"6月 22, 2023","user_id":6,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":10,"training_set":2,"training_exp":12},{"training_record_id":7,"training_record_date":"6月 22, 2023","user_id":7,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":10,"training_set":2,"training_exp":12},{"training_record_id":8,"training_record_date":"6月 22, 2023","user_id":8,"training_menu":"ベンチプレス","training_weight":60.0,"training_count":20,"training_set":1,"training_exp":15},{"training_record_id":9,"training_record_date":"6月 22, 2023","user_id":9,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":20,"training_set":3,"training_exp":38},{"training_record_id":10,"training_record_date":"6月 22, 2023","user_id":10,"training_menu":"ベンチプレス","training_weight":50.0,"training_count":10,"training_set":2,"training_exp":12},{"training_record_id":11,"training_record_date":"6月 22, 2023","user_id":11,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":3,"training_exp":15},{"training_record_id":12,"training_record_date":"6月 22, 2023","user_id":12,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":10,"training_set":3,"training_exp":15},{"training_record_id":13,"training_record_date":"6月 22, 2023","user_id":13,"training_menu":"ベンチプレス","training_weight":30.0,"training_count":10,"training_set":3,"training_exp":11},{"training_record_id":14,"training_record_date":"6月 22, 2023","user_id":14,"training_menu":"ベンチプレス","training_weight":40.0,"training_count":20,"training_set":3,"training_exp":30}];
		for(var i=0;i<list.length;i++){
			var bean = list[i];
			var date = new Date(bean.training_record_date);
			var ss = bean.training_record_date.split(" ");
			var y = ss[2];
			var d = ss[1].replace(",","");
			var m = ss[0].replace("月","");

			 if(year==y && (month+1)==m && count==d){
				//追加したいタグを追加
				var RL =document.getElementById("#recordList");
				RL.innerHTML += "aaaa";
				RL.insertAdjacentHTML('beforeend',"aaaaa");

	    	}
		}
	}
/*
	function test(){

		calendar += "<td class = 'today'><a href='javascript:OnLinkClick='Record(bean)'>" + count +"</a></td>";
		for(var i=0;i<list.length;i++){
			var bean = list[i];
			var date = new Date(bean.training_record_date);
			var ss = bean.training_record_date.split(" ");
			var y = ss[2];
			var d = ss[1].replace(",","");
			var m = ss[0].replace("月","");


			if(year==y && (month+1)==m && count==d){
				<a href='#' javascript:OnLinkClick='Record(bean)'></a>
			}else{
				<a href='#' javascript:OnLinkClick='Record(bean)'></a>
			}
		}
S
	} */