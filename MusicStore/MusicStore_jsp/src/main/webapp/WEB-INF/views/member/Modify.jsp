<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
				<form method="post" action="../Member/ModifyAction.do">
					
					<table style="margin: auto; margin-top: 10%; margin-bottom: 10%;">
						<colgroup>
							<col width="80" />
							<col width="250" />
							<col width="80" />
							<col width="280" />
						</colgroup>
<input type="hidden" name = "id" value = "<?= $row['id'] ?>">
								<tr>
									<th>ID</th>
									<td>
										${id}
										</td>
								</tr>
								<tr>
									<th>이름</th>
									<td>
										${name}
								</tr>
								<tr>
									<th>주소</th>
									<td><input type=text name=address size="30" maxlength="50"
										value="${address}" required></td>
								</tr>
								<tr>
									<th>E-Mail</th>
									<td><input type=text name=e_mail size="30" maxlength="50"
										value="${e_mail}" placeholder="@와 같이 입력하세요"
										pattern="^([0-9a-zA-Z_-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$"
										required></td>
								</tr>
								<tr>
									<th>폰번호</th>
									<td><input type=text name=phone size="30" maxlength="14"
										value="${phone}" placeholder="-까지 입력하세요"
										pattern="^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$" required></td>
								</tr>
								<tr>
									<th>비밀번호</th>
									<td><input type="password" name=pass size="30" maxlength="14" id="pass1"
										placeholder="변경하실 비밀번호를 입력하세요" value=""
										pattern="^[A-Za-z0-9]{6,13}$" ></td>
								</tr>
								<tr>
									<th>비밀번호 확인</th>
									<td><input type="password" name=passCheck size="30" id="pass2"
										maxlength="14" placeholder="비밀번호 확인"
										pattern="^[A-Za-z0-9]{6,13}$" onchange="passcheck()"></td>
								</tr>
								<tr>
								<td colspan="2" align="center">
								<input type=submit value="정보수정" style="padding-right: 10px;">
								  <input
								type=button value="돌아가기" height="30px;"
								onClick="javascript:location='http://localhost/PHP_Shop/index.php';"
								class="button">
								</td>
								
								</tr>

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