<script type="text/javascript">
function Success(){
	alert("정상적으로 탈퇴되었습니다.");
	window.location = "http://localhost/PHP_Shop/index.php";
}
function Pass_No(){
	alert("비밀번호가 다릅니다.");
	history.back();
}
</script>

<?php
	session_start();
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_POST);
	$id = $_SESSION['id'];
	$q = "select * from users where id = '$id'";
	$result = $mysqli->query($q);
	$row = $result->fetch_array (MYSQLI_ASSOC);
	if ($pass == $row['pass']) {
		$delete = "delete from users where id = '$id'";
		$mysqli->query($delete);
		session_destroy();
		echo("<script language='javascript'>Success();</script>");
	}
	else {
		echo("<script language='javascript'>Pass_No();</script>");

	}
?>
