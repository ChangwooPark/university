<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Music Play List</title>
<link href="http://localhost/PHP_Shop/style.css" rel="stylesheet" type="text/css">

</head>
<body bgcolor="#F3F3F3">
<?
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_GET);
	$music_name = str_replace(".mp3", "", $music);
	$q = "select * from music where music = '$music'";
	$result = $mysqli->query($q);
?>
<div class="PlayListTitle">
<span class="PlayListTitle"><h3 class="PlayListTitle1" >Music Play List</h3></span> 
</div>
<div class="clear"></div>
<hr class="title_hr" color="#59DA50" style="margin-left: 0; margin-bottom: 20px;">

<div class="clear"></div>
<div class="playmusicdiv">
<b class="playmusic"><?= $music_name ?></b>
</div>
<div>
<audio src="http://localhost/PHP_Shop/Upload_music/<?=$music?>" controls="controls" autoplay="autoplay" preload="auto" ></audio>
</div>
<table class="PlayTable">
<colgroup>
<col width="8%">
<col width="62%">
<col width="30%">
</colgroup>
<tr><th>No.</th><th>곡명</th><th>아티스트</th>
<?php
	$i = 1;
	while ($row = $result->fetch_array(MYSQL_ASSOC)) {
		$playmusic = str_replace(".mp3", "", $row['music']);
		$music_title = explode("-", $playmusic);
?>
		<tr><td><?= $i ?></td><td><?= $music_title[1] ?></td><td><?= $row['artist'] ?></td></tr>
		<?
		$i++;
	}
?>
</table>
</body>
</html>