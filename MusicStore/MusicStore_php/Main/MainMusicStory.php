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
<h3>Music Story</h3>
		<section style="min-height: 300px;">
			<article>
				<?php
	session_start();
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_POST);

	$q = "select * from musicstory order by idx desc limit 0,3";
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
<? 
		while ($row = $result->fetch_array(MYSQL_ASSOC)) {
?>
<td><a href="http://localhost/PHP_Shop/MusicStory/StoryDetail.php?idx=<?=$row['idx']?>" target="_parent"><img style="width: 300px;height: 200px;" src="http://localhost/PHP_Shop/Story_Picture/<?=$row['picture']?>"></a><br>
 <?= $row['title'] ?></td>
<?

		}
	}
?>
</table>
</article>
</section>
		
	
</body>
</html>
