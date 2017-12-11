<script type="text/javascript">
function List_open(music, idx){
	window.open("http://localhost/PHP_Shop/PlayList/PlayList.php?music="+music,"window","width=350, height=400");
	window.location.replace('http://localhost/PHP_Shop/Album/AlbumDetail.php?idx='+idx);
}

</script>
<?php
	extract($_GET);

	session_start();
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	$hits_q = "select * from music where music = '$musicname'";
	$result = $mysqli->query($hits_q);
	$row = $result->fetch_array(MYSQL_ASSOC);
	$hits = $row['hits'];
	$idx = $row['idx'];
	$hits++;
	$q = "update music set hits = '$hits' where music = '$musicname'";
	$mysqli->query($q);

	echo "<script>List_open('$musicname','$idx' );</script>";
?>