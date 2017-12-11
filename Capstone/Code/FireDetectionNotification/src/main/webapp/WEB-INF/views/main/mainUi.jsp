<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/resources/jquery/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/resources/jquery/jquery.js"></script>
<meta charset="utf-8">
<title>ChromicOS</title>

<script type="text/javascript">
	function changeIframeUrl(url) {
		var iframe = document.getElementById("main_Iframe")
		iframe.src = url;
		//document.getElementById("main_Iframe").onLoad = "setIFrameHeight('this')";
		//var the_height = iframe.contentWindow.document.body.scrollHeight;
		//iframe.height = the_height;
	}
	function setIFrameHeight(height) {
		$("#main_Iframe").css("height", height + 'px');
	}
	var c = setInterval(ColorChange, 1000);
	var number = 1;
	function ColorChange() {
		$.ajax({
			type : "POST",
			url : "/sensor/ColorChange.do",
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			async: false,
			success : function(data) {
				console.log(data.data);
				if (data.data == "yellow" || data.data =="red") {
					if (number % 2 == 1) {
						if (data.data == "yellow") {
							$("#wrap").css('background-color', 'yellow');
						} else {
							$("#wrap").css('background-color', 'red');
						}
					} else
						$("#wrap").css('background-color', 'white');
					number = number + 1;

				} else {
					$("#wrap").css('background-color', 'white');

				}
			},
			error : function(xhr, status, error) {
				alert(error);
			}
		})
	}
</script>
</head>
<body>
	<div class="wrap" id="wrap">
		<nav>
			<ul class="menu">
				<li><img src="" class="logo" /></li>
				<li><a href="javascript:changeIframeUrl('/home.do')"><span class="iconic home"></span> Home</a></li>
				<li><a href="#"><span class="iconic plus-alt"></span> 창고 관리</a>
					<ul>
						<li><a href="javascript:changeIframeUrl('sensor/UserList.do')">회원 List</a></li>
						<li><a href="javascript:changeIframeUrl('sensor/WarehouseList.do')">창고 List</a></li>
						<li><a href="javascript:changeIframeUrl('sensor/RealTimeSensorUi.do')">실시간 Sensor Data 조회</a></li>
						<li><a href="javascript:changeIframeUrl('sensor/BeforeSensorUi.do')">이전 Sensor Data 조회</a></li>
					</ul></li>

				<li><a href="#"><span class="iconic magnifying-glass"></span> 게시판</a>
					<ul>
						<li><a href="javascript:changeIframeUrl('board/NoticeUi.do')">공지사항</a></li>
						<li><a href="javascript:changeIframeUrl('board/HelpUi.do')">도움말</a></li>
					</ul></li>
			</ul>
		</nav>
		<div class="clearfix">
			<iframe src="/home.do" class="iframe-userUi" id="main_Iframe" onload="setIFrameHeight(this);"
				scrolling="no"></iframe>
		</div>
	</div>
</body>
</html>