<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Delete</title>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="/resources/SpryAssets/SpryMenuBarHorizontal.css"
	rel="stylesheet" type="text/css">
	<script src="/resources/SpryAssets/SpryMenuBar.js"
	type="text/javascript"></script>
</head>
<body>
<body>
	<div class="wrap">
		<header>
			<jsp:include page="../Template/Header.jsp"></jsp:include>
		</header>
		<div class="clear"></div>
		<h2 class="title">Login</h2>
		<hr class="title_hr" color="#59DA50">
		<section>

			<article>
				<div class="Login">
					<form action="../Member/Deleteaction.do" method="post">
						<input type="password" size="15" placeholder="PW" name="pass1" id="pass1"> <input
							type="password" size="15" placeholder="PW È®ÀÎ" name ="pass2" id="pass2"><br>
						<div class="clear"></div>
						<input type="submit" size="5" value="È¸¿øÅ»Åð" onclick="passcheck();return false;">
					</form>
				</div>
			</article>
		</section>
		<footer>
			<jsp:include page="../Template/Footer.jsp"></jsp:include>
		</footer>
	</div>
</body>
</body>
</html>