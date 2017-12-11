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
		location = "http://localhost/PHP_Shop/Album/DeleteProcess.php?idx="+idx;
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
		<h2 class="title">Delete</h2>
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

	$q = "select * from music";
	$result = $mysqli->query($q);
	if ($result->num_rows == 0) {
?>
<div style="text-align: center; margin-top: 20%;">
<b> 곡이 존재하지 않습니다.</b>
</div>
<?}
	else {
?>
<div class="clear"></div>
<div class="Album">

<table class="Album">
<colgroup>
<col width="10%">
<col width="70%">
<col width="20%">

</colgroup>
<tr><th></th><th>앨범정보</th><th></th> </tr>
<?$i = 1;
		while ($row = $result->fetch_array(MYSQL_ASSOC)) {
			$music_name = str_replace(".mp3", "", $row['music']);
			$idx = $row['idx'];
?>
<tr><td><img class="AlbumPicture" src="../Upload_picture/<?=$row['album_picture']?>"></td><td><b><?= $row['album'] ?></b><br> <?= $row['artist'] ?><br>
<?= $row['regis_date'] ?><br><?= $music_name ?>

</td>
<td>
<input type="button" value = "삭제하기" onclick="delect_check('<?=$idx?>')">
</td>
</tr>

<?
			$i += 1;

		}

	}
?></table>
</div>
			</article>
		</section>
		<footer>
		<? include("../Template/Footer.php") ?>
	</footer>
	</div>
</body>
</html>
