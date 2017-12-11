<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<link href="../SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet"
	type="text/css">
<script src="../SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<script type="text/javascript">
function passcheck() {
	var pass1 = document.getElementById("pass1").value;
	var pass2 = document.getElementById("pass2").value;
	if(pass1 != pass2){
		alert("비밀번호를 다시 확인해주세요");
		document.getElementById("pass1").focus();
	}
}

</script>

</head>
<body>
<?php
	session_start();
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_POST);
	$id = $_SESSION['id'];
	$q = "select * from users where id='$id'";
	$result = $mysqli->query($q);
	$row = $result->fetch_array (MYSQLI_ASSOC);
	$e_mail = str_replace(" ", "@", $row['e_mail']);
	$phone = str_replace(" ", "-", $row['phone']);
?>
<div class="wrap">
		<header>
			<? include("../Template/Header.php") ?>
		</header>
		<div class="clear"></div>
		<h2 class="title">Member Modify</h2>
		<hr class="title_hr" color="#59DA50">
		<section>
			<article>
			<form method="post" action="ModifyProcess.php">
					
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
										<?= $row['id'] ?>
										</td>
								</tr>
								<tr>
									<th>이름</th>
									<td>
										<?= $row['name'] ?></td>
								</tr>
								<tr>
									<th>주소</th>
									<td><input type=text name=address size="30" maxlength="50"
										value="<?= $row['address'] ?>" required></td>
								</tr>
								<tr>
									<th>E-Mail</th>
									<td><input type=text name=e_mail size="30" maxlength="50"
										value="<?=$e_mail?>" placeholder="@와 같이 입력하세요"
										pattern="^([0-9a-zA-Z_-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$"
										required></td>
								</tr>
								<tr>
									<th>폰번호</th>
									<td><input type=text name=phone size="30" maxlength="14"
										value="<?=$phone?>" placeholder="-까지 입력하세요"
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
		<? include("../Template/Footer.php") ?>
	</footer>
	</div>

</body>
</html>