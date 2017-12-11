<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<script type="text/javascript">
function idcheck(){
	alert("중복되는 ID입니다");
	history.back();
	
}
function regcheck(){
	alert("중복되는 주민등록번호입니다");
	history.back();
}
function Success(){
	alert("회원가입이 완료되었습니다.");
	window.location="http://localhost/PHP_Shop/index.php";
}
</script>
</head>

<body>
	<?
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_POST);
	$register = $register1.$register2;
	$e_mail = $e_mail1." ".$e_mail2;
	$phone = $phone1." ".$phone2." ".$phone3;

	$q_check = "select * from users where id = '$id'";
	$result = $mysqli->query($q_check);

	if ($result->num_rows == 0) {
		$q_check_reg = "select * from users  where register = '$register'";
		$result_reg = $mysqli->query($q_check_reg);
		if ($result_reg->num_rows == 0) {

			$q = "insert into users (id, pass,register, name, address,e_mail,phone) values('$id', '$pass', '$register', '$name', '$address', '$e_mail', '$phone')";
			$mysqli->query($q);
			echo("<script language='javascript'>Success();</script>");
		}
		else {
			echo("<script language='javascript'>regcheck();</script>");
		}
	}
	else {
		echo("<script language='javascript'>idcheck();</script>");
	}
	$mysqli->close($mysqli);
?>
</body>
</html>
