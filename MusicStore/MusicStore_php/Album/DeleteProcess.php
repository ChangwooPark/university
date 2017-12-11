<script type="text/javascript">
function delect_check(){
	if(confirm("정말 삭제하시겠습니까?") == true){
		return;
	}
	else{
		location = "http://localhost/PHP_Shop/Album/NewAlbum.php";
	}
}

function delete_success(){
	alert("정상적으로 삭제되었습니다.");
	location = "http://localhost/PHP_Shop/Album/NewAlbum.php";
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
	$music_q = "select * from music where idx = '$idx'";
	$result = $mysqli->query($music_q);
	$row = $result->fetch_array(MYSQL_ASSOC);

	$deletemusic = "../Upload_music/";
	$deletepicture = "../Upload_picture/";
	$deletevideo = "../Upload_video/";

	if (is_file($deletemusic.$row['music']) == true) {
		unlink($deletemusic.$row['music']);
	}
	
	if (is_file($deletevideo.$row['video']) == true) {
		unlink($deletevideo.$row['video']);
	}
	$q = "delete from music where idx = '$idx'";
	$mysqli->query($q);

	echo("<script language='javascript'>delete_success();</script>");
?>