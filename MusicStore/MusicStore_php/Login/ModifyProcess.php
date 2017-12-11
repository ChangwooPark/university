<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<?
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_POST);
	$re_e_mail = str_replace("@", " ", $e_mail);
	$re_phone = str_replace("-", " ", $phone);

	$q = "select * from users where id = '$id'";
	$result = $mysqli->query($q);
	$row = $result->fetch_array (MYSQLI_ASSOC);
	if ($pass == null) {
		$pass = $row['pass'];
	}
	$modify = "update users set address = '$address', e_mail = '$re_e_mail', phone = '$re_phone', pass='$pass' where id = '$id'";
	$mysqli->query($modify);
?>
<script>
alert("회원정보가 수정 되었습니다.");
location.replace("http://localhost/PHP_Shop/index.php");
</script>
</body>
</html>