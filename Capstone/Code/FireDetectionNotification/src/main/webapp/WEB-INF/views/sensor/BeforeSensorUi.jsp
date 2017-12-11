<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" media="screen" href="/resources/jquery/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/resources/jquery/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/style.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/button.css" />

<script src="/resources/jquery/jquery-1.11.2.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/jquery/jquery.blockUI.js"></script>
<script src="/resources/jquery/jquery-migrate-1.2.1.js" type="text/javascript"></script>
<script src="/resources/jquery/grid.locale-en.js" type="text/javascript"></script>
<script src="/resources/jquery/jquery.jqGrid.src.js" type="text/javascript"></script>
<script src="/resources/jquery/JQuery-lib.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	$(document).ready(function() {

		jQuery.ajax({
			type : "POST",
			url : "/sensor/beforeDate.do",
			dataType : "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
			contentType : "application/json;charset=UTF-8", //한글 안깨지게
			success : function(data) {
				$.each(data, function(index, value) {
					console.log(value[index]);
					$("#datecombo").append("<option value='"+value[index]+"'>" + value[index] + "</option>");
				});
			},
			error : function(xhr, status, error) {

				alert(xhr.reponseText);
			}
		});

		$("#datecombo").change(function() {
			alert("hi");
			loadJqgrid();
		});

		$("#list").jqGrid({
			width : "700",
			height : "670",
			jsonReader : {
				repeatitems : false
			},
			colNames : [ 'time', 'temperature', 'humid', 'flame', 'smoke' ],
			colModel : [ //data mapping and row attribute
			{
				name : 'time',
				width : "20%"
			}, {
				name : 'temperature',
				width : "20%"
			}, {
				name : 'humid',
				width : "20%"
			}, {
				name : 'flame',
				width : "20%"
			}, {
				name : 'smoke',
				width : "20%"
			} ],

			rowList : [ 10, 20, 30 ],
			caption : "이전 센서 Data",
			pager : '#pager',
			rowNum : '20',
			viewrecords : true,

			emptyrecords : "데이터 없음",
			loadonce : false,
			pager : $("#pager"),
			contentType : "application/json; charset=utf-8",

			serializeGridData : function(postData) {
				postData.formData = $("#list").serializeArray();
				return JSON.stringify(postData);
			},
			//korean language 
			ajaxGridOptions : {
				contentType : "application/json;charset=UTF-8"
			}

		});

		jQuery("#list").jqGrid('navGrid', "#pager", {
			edit : false,
			add : false,
			del : false,
			search : false,
			refresh : false
		});
	});

	function loadJqgrid() {
		$("#list").clearGridData(); // 이전 데이터 삭제
		$("#list").setGridParam({
			url : "/sensor/beforeSensorData.do",
			datatype : "json",
			loadtext : '로딩중..',
			mtype : "post",
			postData : {
				datecombo : $("#datecombo").val()
			},
		}).trigger("reloadGrid");

		jQuery("#list").jqGrid('navGrid', "#pager", {
			edit : false,
			add : false,
			del : false,
			search : false,
			refresh : false
		});

	}
</script>
<body>

	<div class="before_sensor_list">
		<div id="div_datecombo" class="div_datecombo">
			<select id="datecombo">
			</select>
		</div>
		<table id="list"></table>
		<div id="pager"></div>
	</div>
</body>
</html>