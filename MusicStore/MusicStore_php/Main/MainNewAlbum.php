<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<link href="../SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet"
	type="text/css">
<script src="../SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
</head>
<body>
<h3>New Album</h3>
		<section>
			<article>
				<?php
	session_start();
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_POST);

	$q = "select * from music group by album order by regis_date desc";
	$result = $mysqli->query($q);
	if ($result->num_rows == 0) {
?>
<div style="text-align: center; margin-top: 20%;">
<b> 곡이 존재하지 않습니다.</b>
</div>
<?}
	else {
?>
<table style="text-align: center;">
<? $i = 0;
		while ($row = $result->fetch_array(MYSQL_ASSOC)) {
			$music_name = str_replace(".mp3", "", $row['music']);
?>
<td><a href="http://localhost/PHP_Shop/Album/AlbumDetail.php?idx=<?=$row['idx']?>" target="_parent"><img class="MainAlbumPicture" src="http://localhost/PHP_Shop/Upload_picture/<?=$row['album_picture']?>"></a><br>
 <?= $row['artist'] ?></td>
<?
			$i++;
			if ($i == 4) {

				echo "<tr></tr>";
			}
		}
	}
?>
</table>
</article>
</section>
		
	
</body>
</html>
