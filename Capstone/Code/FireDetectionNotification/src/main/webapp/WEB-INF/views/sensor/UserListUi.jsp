<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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

<script type="text/javascript">
	$(document).ready(function() {

		$("#list").jqGrid({
			url : "/User/SelectAll.do",
			loadtext : '로딩중..',
			datatype : "json",
			mtype : "post",
			width : "700",
			height : "700",
			jsonReader : {
				repeatitems : false
			},
			colNames : [ 'idx', 'user_ID', 'user_pass', 'user_phone', 'flag' ],
			colModel : [ //data mapping and row attribute
			{
				name : 'idx',
				width : "10%"
			}, {
				name : 'user_id',
				width : "30%"
			}, {
				name : 'user_pass',
				width : "30%"
			}, {
				name : 'user_phone',
				width : "30%"
			}, {
				name : 'flag',
				hidden : true

			} ],

			rowList : [ 10, 20, 30 ],
			caption : "사용자 관리",
			pager : '#pager',
			rowNum : '10',
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
			},

			//double click
			ondblClickRow : function(idx) {

				var rowdata = $("#list").jqGrid('getRowData', idx);

				jQuery("#idx").val(rowdata.idx);
				jQuery("#user_id").val(rowdata.user_id);
				jQuery("#user_pass").val(rowdata.user_pass);
				jQuery("#user_phone").val(rowdata.user_phone);
			}
		});

		jQuery("#list").jqGrid('navGrid', "#pager", {
			edit : false,
			add : false,
			del : false,
			search : false,
			refresh : false
		});

		//flag
		var InsertArray = new Array();
		var count = 0;
		var gridNm = "list";
		//add button
		$("#btnInsert").click(function() {

			var total = $("#list").getGridParam("records") + 1;
			var user_id = jQuery("#user_id").val();
			var user_pass = jQuery("#user_pass").val();
			var user_phone = jQuery("#user_phone").val();
			var addData = {
				"idx" : total,
				"user_id" : user_id,
				"user_pass" : user_pass,
				"user_phone" : user_phone,
				"flag" : "I"
			};

			$("#list").jqGrid('addRowData', total, addData, "last");
			//color change
			BackgroundChange(gridNm, total, "#8AE634");
			InsertArray[count] = total;
			count++;
		});

		//select button
		$("#btnSelect").click(function() {

			$("#list").trigger('reloadGrid');

		});

		//Init button
		$("#btnInit").click(function() {
			jQuery("#idx").val('');
			jQuery("#user_id").val('');
			jQuery("#user_pass").val('');
			jQuery("#user_phone").val('');
			$("#list").resetSelection();
		});

		//delete button
		$("#btnDelete").click(function() {
			var rowid = $("#list").jqGrid('getGridParam', "selrow");
			var idx = $("#list").jqGrid('getRowData', rowid).idx;
			BackgroundChange(gridNm, rowid, "#FF0000");

			var setData = {
				"idx" : idx,
				"flag" : "D"
			};

			$("#list").setRowData(rowid, setData, false);
		});

		//save button
		$("#btnSave").click(function() {
			var rowid = $("#list").jqGrid('getGridParam', "selrow");
			var user_id = jQuery("#user_id").val();
			var user_pass = jQuery("#user_pass").val();
			var user_phone = jQuery("#user_phone").val();
			var isInsert = false;
			$("#list").setCell(rowid, 'user_id', user_id);
			$("#list").setCell(rowid, 'user_pass', user_pass);
			$("#list").setCell(rowid, 'user_phone', user_phone);

			var idx = $("#list").jqGrid('getRowData', rowid).idx;
			var deleteflag = $("#list").jqGrid('getRowData', rowid).flag;

			var setData = {
				"idx" : idx,
				"flag" : "U"
			};
			if (!(deleteflag == "D")) {
				$("#list").setRowData(rowid, setData, false);
			}
			var gridData = jQuery("#list").getRowData();
			jQuery.ajax({

				type : "POST",
				url : "/User/Save.do",
				// url:"/mainUi.do",
				dataType : "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
				data : JSON.stringify(gridData),
				contentType : "application/json;charset=UTF-8", //한글 안깨지게

				success : function(data) {
					$("#list").trigger('reloadGrid');
				},
				error : function(xhr, status, error) {

					alert(xhr.reponseText);
				}

			});

		});
		//iframe 길이
		$("#main_Iframe", parent.document).width(1350);
		//input table div height change
		$("#crud_area_box").height(200);
		$("#table_area").height(200);
	});
</script>

</head>

<body>
	<div class="list_area">
		<table id="list"></table>
		<div id="pager"></div>
	</div>
	<div class="crud_area">
		<div class="crud_area_box" id="crud_area_box">
			<table class="table_area" id="table_area">
				<tr class="center">
					<td><input type="button" value="조회" id="btnSelect" class="button"></td>
					<td><input type="button" value="초기화" id="btnInit" class="button"></td>
					<td><input type="button" value="추가" id="btnInsert" class="button add"></td>
					<td><input type="button" value="삭제" id="btnDelete" class="button delete"></td>
				</tr>
				<tr>
					<td><b>idx</b></td>
					<td><input type="text" id="idx" readonly="readonly" maxlength="5" class="input"></td>
					<td><b>user_ID</b></td>
					<td><input type="text" id="user_id" maxlength="15" class="input"></td>

				</tr>
				<tr>
					<td><b>password</b></td>
					<td><input type="text" id="user_pass" maxlength="15" class="input"></td>
					<td><b>phone</b></td>
					<td><input type="text" id="user_phone" maxlength="15" class="input"></td>
				</tr>
			</table>
		</div>
		<div class="save_area">
			<input type="button" value="저장" id="btnSave" class="button save">
		</div>
	</div>

</body>
</html>