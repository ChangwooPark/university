<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<link href="../SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet"
	type="text/css">

</head>

<body>
	<div class="wrap">
		<header>
			<? include("../Template/Header.php") ?>
		</header>
		<div class="clear"></div>
		<h2 class="title">MemberShip</h2>
		<hr class="title_hr" color="#59DA50">
		<section>
			<div style="clear: both;"></div>
			<article>
				<form method="post" action="NewmemberCheck.php">
					<table style="margin: auto; margin-top: 10%; margin-bottom: 10%;" id=newmember>
						<colgroup>
							<col width="80" />
							<col width="280" />
						</colgroup>
						<tr>
							<th>ID</th>
							<td><input type=text name=id size="29" maxlength="18"
								placeholder="영문자 또는 숫자 6~18 " pattern="^[A-Za-z0-9]{6,18}$"
								required></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name=pass size="29" maxlength="14"
								placeholder="영문자 또는 숫자  6~13 " pattern="^[A-Za-z0-9]{6,13}$"
								required></td>
						</tr>
						<tr>
							<th>주민등록번호</th>
							<td><input type=text name=register1 size="10" maxlength="6"
								value="" pattern="\d{6}" required> - <input type="password"
								name=register2 size="10" maxlength="7" value="" pattern="\d{7}"
								required></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type=text name=name size="15" maxlength="15" value=""
								required></td>
						</tr>
						<tr>
							<th>주소</th>
							<td><input type=text name=address size="29" maxlength="50"
								value="" required></td>
						</tr>
						<tr>
							<th>E-Mail</th>
							<td><input type=text name=e_mail1 size="10" maxlength="18"
								value="" pattern="^([0-9a-zA-Z_-]+)" required> @ <input
								type=text name=e_mail2 size="9" maxlength="20" value=""
								pattern="([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$" required></td>
						</tr>
						<tr>
							<th>폰번호</th>
							<td><select name="phone1">
									<option value="010">010</option>
									<option value="010">011</option>
									<option value="010">016</option>
									<option value="010">017</option>
									<option value="010">018</option>
									<option value="010">019</option>
							</select> - <input type=text name=phone2 size="4" maxlength="4"
								value="" pattern="\d{3,4}$" required> - <input type=text
								name=phone3 size="4.5" maxlength="4" value="" pattern="\d{4}$"
								required></td>
						</tr>
						<tr>
							<td colspan="2" align="center" style="padding-right: 10px;"><input
								type=submit value="회원가입" class="button" height="30px;"> <input
								type=button value="돌아가기" height="30px;"
								onClick="javascript:location='http://localhost/PHP_Shop/index.php';"
								class="button"></td>
					
					</table>
				</form>
			</article>
		</section>
		<footer>
		<? include("../Template/Footer.php") ?>
	</footer>
	</div>
</body>
</html>
