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
            <div class="logos"><img src="0qMHkiUhEaGNQct1687312152_1687312306.png"></div>
            <div id="share_name">${name}</div>
            <div class="en">
            <div id="share_level">${level_session}</div>
            </div>
            <div id="share_exp">${exp_sum_session}</div>
            <div id="share_ranking">Ranking</div>
            <div id="share_ranking_nam">${}</div>
            <div id="share_w_ranking">Week:</div>
            <div id="share_w_ranking_num">${}</div>
            <div id="share_m_ranking">Month:</div>
            <div id="share_m_ranking_num">${}</div>
        </div>
        <div class="circle"></div>


    </div>

<script src="./js/result.js"></script>
</body>
</html>