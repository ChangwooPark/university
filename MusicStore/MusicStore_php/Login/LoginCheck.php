<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function Success(){
	alert("로그인에 성공했습니다.");
	window.location="http://localhost/PHP_Shop/index.php";
	}
	function Passcheck(){
		alert("비밀번호를 확인해주세요.");
		history.back();
				
	}
	function idcheck(){
		alert("아이디를 확인해주세요.");
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
	$q = "select * from users where id = '$id'";
	$result = $mysqli->query($q);
	if ($result->num_rows == 1) {
		$row = $result->fetch_array (MYSQLI_ASSOC);

		if ($row['pass'] == $pass) {
			$_SESSION['login'] = 'YES';
			$_SESSION['id'] = $id;
			$_SESSION['name'] = $row['name'];
			echo("<script language='javascript'>Success();</script>");
		}
		else {
			$_SESSION['login'] = 'NO';
			echo("<script language='javascript'>Passcheck();</script>");
		}
	}
	else {
		$_SESSION['login'] = 'NO';
		echo("<script language='javascript'>idcheck();</script>");

	}
	$mysqli->close($mysqli);
?>
</body>
</html>