<script>
function success() {
	alert("정상적으로 수정되었습니다.");
	location = "http://localhost/PHP_Shop/MusicStory/MusicStory.php";
}
</script>

<?php
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_POST);
	extract($_GET);
	$musicpicture = '../Story_Picture/';
	$picture = $_FILES['picture']['name'];
	$q = "select * from musicstory where idx = '$idx'";
	$result = $mysqli->query($q);
	$row = $result->fetch_array(MYSQL_ASSOC);

	if ($picture == null) {
		$picture = $row['picture'];
	}
	$update = "update musicstory set title = '$title', article = '$article', picture = '$picture' where idx = '$idx'";
	$mysqli->query($update);
	echo "<script>success();</script>";
?>