<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="/resources/SpryAssets/SpryMenuBarHorizontal.css"
	rel="stylesheet" type="text/css">
	
	<c:if test="${check == 1}">
	<script type="text/javascript">
		alert("정보가 틀렸습니다 다시 입력해주세요!");
	</script>
</c:if>
<script src="/resources/SpryAssets/SpryMenuBar.js"
	type="text/javascript"></script>

</head>

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
					<form action="../Member/loginaction.do" method="post">
						<input type="text" size="10" placeholder="ID" name="id"> <input
							type="password" size="10" placeholder="PW" name="pass"><br>
						<div class="clear"></div>
						<input type="submit" size="5" value="Login">
					</form>
				</div>
			</article>
		</section>
		<footer>
			<jsp:include page="../Template/Footer.jsp"></jsp:include>
		</footer>
	</div>
</body>
</html>