<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/style.css" media="screen" rel="stylesheet" type="text/css" />
<link href="/resources/css/sensor.css" media="screen" rel="stylesheet" type="text/css" />
<script src="/resources/chart/Chart.min.js"></script>
<script src="/resources/jquery/jquery.js"></script>
<script src="/resources/jquery/jquery-1.11.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
	var t = setInterval(TempHumiChart, 3000);
	$(document).ready($(function() {
		parent.setIFrameHeight(1200);
		TempHumiChart();
	}));
	function TempHumiChart() {

		//temperature Chart
		$.ajax({
			type : "POST",
			url : "/sensor/TemperatureChart.do",
			// url:"/mainUi.do",
			dataType : "JSON",
			contentType : "application/json;charset=UTF-8",
			//data: JSON.stringify(data),
			//data : data,

			success : function(req) {
				if (req != null) {
					var option = {
						animation : false,
						scaleSteps : 10,
						scaleOverride : true,
						scaleStepWidth : 10,
						scaleStartValue : 0
					}
					var data = {
						labels : req.labels,
						datasets : [ {
							fillColor : "#adff2f",
							strokeColor : "#7cfc00",
							pointColor : "#7cfc00",
							pointStrokeColor : "#fff",
							pointHighlightFill : "#fff",
							pointHighlightStroke : "rgba(220,220,220,1)",
							data : req.data
						} ]
					}
					var temper = $("#temperature_chart").get(0).getContext("2d");
					new Chart(temper).Line(data, option);
				} else {
					alert("error!");
				}
			},
			error : function(xhr, status, error) {
				alert(error);
			}
		}),
		//Humidity Chart
		$.ajax({
			type : "POST",
			url : "/sensor/HumidityChart.do",
			// url:"/mainUi.do",
			dataType : "JSON",
			contentType : "application/json;charset=UTF-8",
			//data: JSON.stringify(data),
			//data : data,
			success : function(req) {
				if (req != null) {
					var option = {
						animation : false,
						scaleSteps : 10,
						scaleOverride : true,
						scaleStepWidth : 10,
						scaleStartValue : 0
					}
					var data = {
						labels : req.labels,
						datasets : [ {
							fillColor : "rgba(151,187,205,0.2)",
							strokeColor : "rgba(151,187,205,1)",
							pointColor : "rgba(151,187,205,1)",
							pointStrokeColor : "#fff",
							pointHighlightFill : "#fff",
							pointHighlightStroke : "rgba(151,187,205,1)",
							data : req.data
						} ]
					}

					var humid = $("#humidity_chart").get(0).getContext("2d");
					new Chart(humid).Line(data, option);
				} else {
					alert("error!");
				}
			},
			error : function(xhr, status, error) {
				alert(error);
			}
		}),
		// smoke Chart
		$.ajax({
			type : "POST",
			url : "/sensor/SmokeChart.do",
			// url:"/mainUi.do",
			dataType : "JSON",
			contentType : "application/json;charset=UTF-8",
			//data: JSON.stringify(data),
			//data : data,
			success : function(req) {
				if (req != null) {
					var option = {
						animation : false,
						scaleSteps : 10,
						scaleOverride : true,
						scaleStepWidth : 400,
						scaleStartValue : 0
					}
					var data = {
						labels : req.labels,
						datasets : [ {
							fillColor : "rgba(220,220,220,0.2)",
							strokeColor : "rgba(220,220,220,1)",
							pointColor : "rgba(220,220,220,1)",
							pointStrokeColor : "#fff",
							pointHighlightFill : "#fff",
							pointHighlightStroke : "rgba(220,220,220,1)",
							data : req.data
						} ]
					}

					var humid = $("#smoke_chart").get(0).getContext("2d");
					new Chart(humid).Line(data, option);
				} else {
					alert("error!");
				}
			},
			error : function(xhr, status, error) {
				alert(error);
			}
		}),
		// spark chart
		$.ajax({
			type : "POST",
			url : "/sensor/SparkChart.do",
			// url:"/mainUi.do",
			dataType : "JSON",
			contentType : "application/json;charset=UTF-8",
			//data: JSON.stringify(data),
			//data : data,
			success : function(req) {
				if (req != null) {
					var option = {
						animation : false,
						scaleSteps : 10,
						scaleOverride : true,
						scaleStepWidth : 400,
						scaleStartValue : 0
					}
					var data = {
						labels : req.labels,
						datasets : [ {
							fillColor : "#cd5c5c",
							strokeColor : "#dc143c",
							pointColor : "r#ff0000",
							pointStrokeColor : "#fff",
							pointHighlightFill : "#fff",
							pointHighlightStroke : "rgba(151,187,205,1)",
							data : req.data
						} ]
					}

					var humid = $("#spark_chart").get(0).getContext("2d");
					new Chart(humid).Line(data, option);
				} else {
					alert("error!");
				}
			},
			error : function(xhr, status, error) {
				alert(error);
			}
		})
	}
</script>

<title>Insert title here</title>
</head>
<body id="bodyColor">
	<div class="div_height_change">
		<div class="div_sensor_cctv">
			<h1>CCTV</h1>
			<!--  <video src="http://203.230.100.202:8080/?action=stream" autoplay="autoplay" controls="controls" height="480" width="640"></video>-->
			<img src="http://203.230.100.202:8080/?action=stream" height="370" width="600">
		</div>
		<div class="div_temperature">
			<h5>온도</h5>
			<canvas height="300" width="580" id="temperature_chart">.</canvas>
		</div>
		<div class="div_humidity">
			<h5>습도</h5>
			<canvas height="300" width="580" id="humidity_chart">.</canvas>
		</div>
		<div class="div_NextLine"></div>
		<div class="div_smoke">
			<h5>가스</h5>
			<canvas height="300" width="580" id="smoke_chart">.</canvas>
		</div>
		<div class="div_spark">
			<h5>불꽃</h5>
			<canvas height="300" width="580" id="spark_chart">.</canvas>
		</div>
	</div>
</body>
</html>