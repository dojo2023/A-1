<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="initial-scale=1">
<link rel="stylesheet" href="/jiro_power/css/result.css">

<title>リザルトページ</title>
</head>
<body>

<div class="result">
        <div class="reselt">
            <div class="logos"><img src="./img/logo.png"></div>
            <div id="share_name">${user_name_session}</div>

            <div id="lv">Lv:</div>
            <div id="share_level">${level_session}</div>
            <div id="share_exp">exp: ${exp_sum_session}</div>

            <div class="ranks">
            <div id="share_ranking">Ranking</div>
            <div id="share_ranking_nam">${my_rank}</div>
            </div>

            <div id="share_w_ranking">Week:${w_rank}</div>
            <div id="share_m_ranking">Month:${m_rank}</div>

        </div>
        <div class="circle"></div>

    </div>


<a href="http://twitter.com/share?text=【ツイートテキスト（※日本語をURLエンコードしたもの）】&url=【そのページのURL】" rel="nofollow" id="twitter"><img src="./img/twitter.png"></a>
		<a href="http://www.facebook.com/share.php?u=【そのページのURL】" target="_blank" id="facebook"><img src="./img/facebook.png"></a>

<script src="./js/result.js"></script>
</body>
</html>