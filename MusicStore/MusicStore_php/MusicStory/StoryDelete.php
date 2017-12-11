<script type="text/javascript">


function delete_success(){
	alert("정상적으로 삭제되었습니다.");
	location = "http://localhost/PHP_Shop/MusicStory/MusicStory.php";
}
</script>

<?php

	session_start();
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_GET);

	$deletepicture = "../Story_Picture/";


	if (is_file($deletepicture.$row['picture']) == true) {
		unlink($deletepicture.$row['picture']);
	}

	$q = "delete from musicstory where idx = '$idx'";
	$mysqli->query($q);

	echo("<script language='javascript'>delete_success();</script>");
?>