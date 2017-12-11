<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="/resources/SpryAssets/SpryMenuBarHorizontal.css"
	rel="stylesheet" type="text/css">
<script src="/resources/SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
</head>
<body>
	<div class="wrap">
		<header>
			<jsp:include page="../Template/Header.jsp"></jsp:include>
		</header>
		<div class="clear"></div>
		<h2 class="title">MemberShip</h2>
		<hr class="title_hr" color="#59DA50">
		<section>
			<div style="clear: both;"></div>
			<article>
				<form method="post" action="../Member/NewMember_Process.do">
					
					<table style="margin: auto; margin-top: 10%; margin-bottom: 10%;"
						id=newmember>
						<colgroup>
							<col width="80" />
							<col width="280" />
						</colgroup>
						<tr>
							<th>ID</th>
							<td><input type=text name=id size="29" maxlength="18"
								placeholder="영문자 또는 숫자 6~18 " pattern="^[A-Za-z0-9]{6,18}$"
								required /></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type=password name=pass size="29"
								maxlength="14" placeholder="영문자 또는 숫자  6~13 "
								pattern="^[A-Za-z0-9]{6,13}$" required></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type=text name=name size="15" maxlength="15"
								value="" required></td>
						</tr>
						<tr>
							<th>주소</th>
							<td><input type=text name=address size="29" maxlength="50"
								value="" required></td>
						</tr>
						<tr>
							<th>E-Mail</th>
							<td><input type=text name=e_mail size="29" maxlength="25"
								value=""
								pattern="^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z]*\.[a-zA-Z]{2,3}$)"
								required></td>
						</tr>
						<tr>
							<th>폰번호</th>
							<td><input type=text name=phone size="29" maxlength="12"
								value="" pattern="^\d{3}-\d{3,4}-\d{4}$" required></td>
						</tr>
						<tr>
							<td colspan="2" align="center" style="padding-right: 10px;"><input
								type=submit value="회원가입" class="button" height="30px;">
								<input type=button value="돌아가기" height="30px;"
								onClick="javascript:location='http://localhost/PHP_Shop/index.php';"
								class="button"></td>
					</table>
				</form>
			</article>
		</section>
		<footer>
			<jsp:include page="../Template/Footer.jsp"></jsp:include>
		</footer>
	</div>
</body>
</html>