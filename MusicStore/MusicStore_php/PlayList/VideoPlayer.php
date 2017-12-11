<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MusicVideo Player</title>
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
	$q = "select * from music where video = '$video'";
	$result = $mysqli->query($q);
	$video_name = str_ireplace(".mp4", "", $video);

?>
<div class="PlayListTitle">
<span class="PlayListTitle"><h3 class="PlayListTitle1" >MusicVideo Player</h3></span> 
</div>
<div class="clear"></div>
<hr class="title_hr" color="#59DA50" style="margin-left: 0; margin-bottom: 20px;">

<div class="clear"></div>
<div>
<video src="http://localhost/PHP_Shop/Upload_video/<?=$video?>" controls="controls" autoplay="autoplay"> </video>
</div>
<table class="PlayTable" style="text-align: left; width: 500px; margin-left: 20px;">
<?php
	while ($row = $result->fetch_array(MYSQL_ASSOC)) {
?>
		<tr><td colspan="2" style="padding-bottom: 10px; padding-top: 5px;"><b style="color: #2d2d2d;"><?= $video_name ?></b></td></tr>
		<tr><td style="padding-bottom: 5px;padding-top: 5px;">가수명 </td> <td><?=$row['artist']?></td>
		<tr><td style="padding-bottom: 5px;padding-top: 5px;">앨범 </td> <td><?=$row['album']?></td>
		<tr><td style="padding-bottom: 5px;padding-top: 5px;">장르 </td> <td><?=$row['genre']?></td>
		<?php } ?>
</table>
</body>
</html>