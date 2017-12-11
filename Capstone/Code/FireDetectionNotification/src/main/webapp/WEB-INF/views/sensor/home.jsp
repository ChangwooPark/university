<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>

<script src="/resources/chart/Chart.min.js"></script>
<script src="/resources/jquery/jquery.js"></script>
<script src="/resources/jquery/jquery-1.11.2.min.js"></script>

<script type="text/javascript">
 $(document).ready(function() {
		$.ajax({
			type : "POST",
			url : "/test/json3.do",
			// url:"/mainUi.do",
			dataType : "JSON", 
			contentType : "application/json;charset=UTF-8", 
			//data: JSON.stringify(data),
			//data : data,
			success : function(data) {
				if (data != null) {
					console.log(data);
					var ctx = $("#test_Chart").get(0).getContext("2d");
					new Chart(ctx).Line(data);
				} else {
					alert("error!");
				}
			},
			error : function(xhr, status, error) {
				alert(error);
			}
		})
	}); 
</script>
</head>
<body>
<input type="text" id = "test_txt" />
	<canvas height="500" id="test_Chart" width="1000">.</canvas>
</body>
</html>
