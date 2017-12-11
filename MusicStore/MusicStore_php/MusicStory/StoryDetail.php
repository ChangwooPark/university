<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<link href="../SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet"
	type="text/css">
<script src="../SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<script type="text/javascript">
function delect_check(idx){
	if(confirm("정말 삭제하시겠습니까?") == true){
		location = "http://localhost/PHP_Shop/MusicStory/StoryDelete.php?idx=" + idx;
	}
	else{
	}
}
</script>
</head>

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
	extract($_GET);
	$login = $_SESSION['login'];
	$userid = $_SESSION['id'];
	$q = "select * from musicstory where idx='$idx'";
	$result = $mysqli->query($q);
	$row = $result->fetch_array(MYSQL_ASSOC);
	$idx = $row['idx'];
?>
<div style="margin-left: 130px; ">
<h2><?= $row['title'] ?></h2>
<div class="clear"></div>

<img  src="http://localhost/PHP_Shop/Story_Picture/<?=$row['picture']?>" style="margin-left: 40px;width: 600px;height: 400px;"><br><br><br>

<div style="width: 500px;margin-left: 40px;text-align: center;"><?= $row['article'] ?></div>

<?
	$name = $_SESSION['name'];
	if ($name == "관리자") {
?>
<div style="float: right; margin-right: 20%;margin-top: 40px;margin-bottom: 40px;">
<input type="button" value = "삭제하기" onclick="delect_check('<?=$idx?>')"> 
<input type = "button" value = "수정하기" onclick="javascript:location='StoryModify.php?idx=<?=$idx?>'">
<?
	}
?>
</div>
<div style="margin-bottom: 120px;"></div>
				</div>
			</article>
		</section>
		<footer>
		<? include("../Template/Footer.php") ?>
	</footer>
	</div>
</body>
</html>

