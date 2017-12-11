<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" media="screen" href="/resources/jquery/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/resources/jquery/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/style.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/button.css" />

<script src="/resources/jquery/jquery-1.11.2.min.js" type="text/javascript"></script>
<script src="/resources/jquery/jquery-migrate-1.2.1.js" type="text/javascript"></script>
<script src="/resources/jquery/grid.locale-en.js" type="text/javascript"></script>
<script src="/resources/jquery/jquery.jqGrid.src.js" type="text/javascript"></script>
<script src="/resources/jquery/JQuery-lib.js" type="text/javascript"></script>


<script type="text/javascript">
	$(document).ready(function() {
		//$("#viewLoading").fadeIn(500);
		//$('.wrap-loading').removeClass('display-none');
		$("#list").jqGrid({
			url : "/warehouse/SelectAll.do",
			loadtext : '로딩중..',
			datatype : "json",
			mtype : "post",
			width : "650",
			height : "700",

			jsonReader : {
				repeatitems : false
			},
			colNames : [ 'idx', 'admin_id', 'name', 'address', 'raspi_id', 'flag' ],
			colModel : [ //data mapping and row attribute
			{
				name : 'idx',
				width : "10%"
			}, {
				name : 'admin_id',
				width : "20%"
			}, {
				name : 'name',
				width : "20%"
			}, {
				name : 'address',
				width : "30%"
			}, {
				name : 'raspi_id',
				width : "20%"

			}, {
				name : 'flag',
				hidden : true
			} ],
			rowList : [ 10, 20, 30 ],
			caption : "창고 List",
			pager : '#pager',
			rowNum : '10',
			viewrecords : true,
			contentType : "application/json; charset=utf-8",
			emptyrecords : "데이터 없음",
			loadonce : false,
			pager : $("#pager"),

			serializeGridData : function(postData) {
				postData.formData = $("#list").serializeArray();
				return JSON.stringify(postData);
			},
			//korean language 
			ajaxGridOptions : {
				contentType : "application/json;charset=UTF-8"
			},
			//loading Complete
			//gridComplete : function() {
			//	$("#raspi_id").append("<option value='raspi_001'>raspi_001</option>");
			//	$("#raspi_id").append("<option value='raspi_002'>raspi_002</option>");
			//},

			//double click
			ondblClickRow : function(idx) {

				var rowdata = $("#list").jqGrid('getRowData', idx);
				jQuery("#idx").val(rowdata.idx);
				jQuery("#admin_id").val(rowdata.admin_id);
				jQuery("#name").val(rowdata.name);
				jQuery("#address").val(rowdata.address);
				jQuery("#raspi_id").val(rowdata.raspi_id);

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
			var rowid = $("#list").jqGrid('getGridParam', "selrow");
			var idx = $("#list").jqGrid('getRowData', rowid).idx;
			var total = $("#list").getGridParam("records") + 1;
			var admin_id = jQuery("#admin_id").val();
			var name = jQuery("#name").val();
			var address = jQuery("#address").val();
			var raspi_id = jQuery("#raspi_id").val();

			var addData = {
				"idx" : idx,
				"admin_id" : admin_id,
				//"imgPath" : imgPath,
				"name" : name,
				"address" : address,
				"raspi_id" : raspi_id,
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
			jQuery("#admin_id").val('');
			jQuery("#name").val('');
			jQuery("#address").val('');
			jQuery("#raspi_id").val('');

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
			var idx = $("#list").jqGrid('getRowData', rowid).idx;
			var admin_id = jQuery("#admin_id").val();
			var name = jQuery("#name").val();
			var address = jQuery("#address").val();
			var raspi_id = jQuery("#raspi_id").val();
			var deleteflag = $("#list").jqGrid('getRowData', rowid).flag;

			var isInsert = false;
			$("#list").setCell(rowid, 'admin_id', admin_id);
			$("#list").setCell(rowid, 'name', name);
			$("#list").setCell(rowid, 'address', address);
			$("#list").setCell(rowid, 'raspi_id', raspi_id);
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
				url : "/warehouse/Save.do",

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

	});
</script>

</head>

<div>

	<div class="wrap-loading display-none">
		<div>
			<img src="/resources/images/viewLoading.gif" />
		</div>
	</div>

	<div class="list_area">
		<table id="list"></table>
		<div id="pager"></div>
	</div>
	<div class="crud_area">
		<div class="crud_area_box">

			<table class="table_area">

				<tr>
					<td colspan="4"><input type="button" value="조회" id="btnSelect" class="button"> <input type="button" value="초기화"
						id="btnInit" class="button"> <input type="button" value="추가" id="btnInsert" class="button add"> <input
						type="button" value="삭제" id="btnDelete" class="button delete"></td>
				</tr>
				<tr>
					<td>idx</td>
					<td><input type="text" id="idx" readonly="readonly" class="input"></td>
					<td>admin_id</td>
					<td><input type="text" id="admin_id" maxlength="30" class="input"></td>
				</tr>
				<tr>
					<td>name</td>
					<td><input type="text" id="name" maxlength="30" class="input"></td>
					<td>address</td>
					<td><input type="text" id="address" maxlength="50" class="input"></td>
				</tr>

				<tr>
					<td>raspi_id</td>
					<td><select id="raspi_id">
							<option value="raspi_001">raspi_001</option>
							<option value="raspi_002">raspi_002</option>
					</select></td>
				</tr>
			</table>
		</div>
		<div class="save_area">
			<input type="button" value="저장" id="btnSave" class="button save">
		</div>

	</div>

</div>

</html>