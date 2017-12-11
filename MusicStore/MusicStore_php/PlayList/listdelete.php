<<script type="text/javascript">
function Success(userid){
	location = "http://localhost/PHP_Shop/PlayList/UserPlayList.php?userid="+userid;
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

	$userid = $_SESSION['id'];
	$q = "delete from musiclist where idx = '$idx'";
	$mysqli->query($q) or die(__FILE__.":Line".__LINE__."<p>Query:$q<br><br><br>".$mysqli->error);

	echo("<script language='javascript'>Success('$userid');</script>");
?>