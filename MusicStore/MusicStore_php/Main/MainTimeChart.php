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
	<h3>TimeChart</h3>

		<?
	session_start();
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}

	$q = "select * from music order by hits desc";
	$result = $mysqli->query($q);
	if ($result->num_rows == 0) {
?>
<b> 곡이 존재하지 않습니다.</b>
<?}
	else {
?>
<table>
<colgroup>
<col width="5%">
<col width="75%">
<col width="20%">
</colgroup>
<?
		$i = 1;
		while ($row = $result->fetch_array(MYSQL_ASSOC)) {
			$music_original = $row['music'];
			$music_name = str_replace(".mp3", "", $row['music']);
			$music_title = explode("-", $music_name);
			$video_name = $row['video'];
			$this_idx = $row['idx'];
?>

<tr><td style="text-align: center;" ><?= $i ?></td><td class="title_intro" style="margin-left: 20px;">
<a href="http://localhost/PHP_Shop/Album/AlbumDetail.php?idx=<?=$this_idx?>" target="_parent" class="musicName"><?= $music_title[1] ?></a></td>
<td><?= $row['artist'] ?> </td>
</tr>

<?php

			$i++;
		}
	}
?>
</table>

</body>
</html> 
	