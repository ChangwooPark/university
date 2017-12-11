<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<link href="../SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript">
function Nouser(){
alert("입력한 정보와 일치하는 회원이 존재하지 않습니다.");
history.back();
}
</script>
</head>
<body>
<?
	session_start();
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_POST);
	$register = $register1.$register2;
	$q = "select * from users where name = '$name' and register = '$register'";
	$result = $mysqli->query($q);
	if ($result->num_rows == 1) {
		$row = $result->fetch_array (MYSQLI_ASSOC);
?>
<div class="wrap">
		<header>
			<? include("../Template/Header.php") ?>
		</header>
		<div class="clear"></div>
		<h2 class="title">Find Result</h2>
		<hr class="title_hr" color="#59DA50">
		<section>
		<article>
		<div class="Login">
			<?= $row['name'] ?> 님의 ID는 <?= $row['id'] ?>
							Passwrod는 <?= $row['pass'] ?>
		</div>
		<div style="margin-top: 20px; text-align: center;">
		<input type="button" value = "로그인 하러가기" onclick="javascript:window.location = 'http://localhost/PHP_Shop/Login/Login.php'">
		<input type="button" value = "메인화면으로 가기" onclick="javascript:window.location = 'http://localhost/PHP_Shop/index.php'">
		</div>
		</article>
		</section>
		<footer>
		<? include("../Template/Footer.php") ?>
	</footer>
	</div>
	

</body>
</html>


<?
	}
	else {
		echo("<script>Nouser();</script>");
	}
?>
