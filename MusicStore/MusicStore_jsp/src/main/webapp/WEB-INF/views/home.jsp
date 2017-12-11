<!doctype html>
<html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="utf-8">
<title>listen to</title>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="/resources/SpryAssets/SpryMenuBarHorizontal.css"
	rel="stylesheet" type="text/css">
<script src="/resources/SpryAssets/SpryMenuBar.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function Search() {
		var form = document.searchform;
		if (form.search.value == "") {
			alert("단어를 입력해주세요");
			form.search.focus();
			return;
		}
		form.submit();
	}
</script>
</head>
<body>
	<div class="wrap">
		<header>
			<jsp:include page="Template/Header.jsp?Is_session=${Is_session }?"></jsp:include>
		</header>
		<div>
			<c:out value="${classpath }"></c:out>
		</div>
		<div class="clear"></div>
		<div style="margin-top: 20px; margin-bottom: 20px; margin-left: 40px;">
			<form action="*" method="post" name="searchform">
				<select name="search_cate">
					<option value="1">아티스트</option>
					<option value="2">곡</option>
				</select> <input type="text" name="search" id="search"> <input
					type="button" value="검색" onclick="Search();">
			</form>
		</div>
		<div class="clear"></div>
		<iframe src="/main/MainFrame" class="MainFrame" id="MainIframe"></iframe>
		<script type="text/javascript">
			var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {
				imgDown : "resources/SpryAssets/SpryMenuBarDownHover.gif",
				imgRight : "resources/SpryAssets/SpryMenuBarRightHover.gif"
			});
		</script>
		<footer>
			<jsp:include page="Template/Footer.jsp"></jsp:include>
		</footer>
	</div>
</html>
