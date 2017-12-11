<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/resources/css/login.css">
<meta charset="UTF-8">
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
<script type="text/javascript">
	$(document).ready(function() {
		var data = {
			name : $("#sessionID").val()
		};
		jQuery.ajax({
			type : "POST",
			url : "/User/SessionValue.do",
			dataType : "json",
			data : JSON.stringify(data),
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				$.each(data, function(index, value) {
					$("#address").append("林家 : " + value.address);
					$("#name").append("芒绊疙 : " + value.name);
				});

			},
			error : function(xhr, status, error) {

				alert(xhr.reponseText);
			}
		});
	});
</script>

</head>
<body>
	<div style="margin-top: 20px">
		<input type="hidden" id="sessionID" value="${sessionScope.admin.ID }" />
		<h1>立加 ID : ${sessionScope.admin.ID }</h1>
		<h2 id="address"></h2>
		<h2 id="name"></h2>
	</div>
</body>
</html>