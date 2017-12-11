<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<link href="../SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet"
	type="text/css">
<script src="../SpryAssets/SpryMenuBar.js" type="text/javascript"></script></head>
<body>
<div class="wrap">
		<header>
			<? include("../Template/Header.php") ?>
		</header>
		<div class="clear"></div>
		<h2 class="title">Music Story</h2>
		<hr class="title_hr" color="#59DA50">
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

	$q = "select * from musicstory";
	$result = $mysqli->query($q);
	if ($result->num_rows == 0) {
?>
<div style="text-align: center; margin-top: 20%;">
<b> 글이 존재하지 않습니다.</b>
</div>
<?}
	else {
?>
<div class="clear"></div>
<div class="Album">

<table class="Album">
<colgroup>
<col width="25%">
<col width="25%">
<col width="25%">
<col width="25%">
</colgroup>

<?
		$i = 0;
		while ($row = $result->fetch_array(MYSQL_ASSOC)) {
			$idx = $row['idx'];
?>
<td style="text-align: center;"><a href="http://localhost/PHP_Shop/MusicStory/StoryDetail.php?idx=<?=$idx?>" class="story"><img style="width: 250px; height: 200px;" src="../Story_Picture/<?=$row['picture']?>"><br>
 <?= $row['title'] ?><br> 
</a>
</td>
<?
			$i++;
			if ($i == 3) {

				echo "<tr></tr>";
			}
		}
	}
?>
</table>
</div>
<?
	$name = $_SESSION['name'];
	if ($name == "관리자") {
?>
<div style="float: right; margin-right: 20%;margin-top: 40px;">
<input type="button" value = "글쓰기" onclick="javascript:location='StoryWrite.php'">
</div>
<?
	}
?>
			</article>
		</section>
		<footer>
		<? include("../Template/Footer.php") ?>
	</footer>
	</div>
	
</body>
</html>