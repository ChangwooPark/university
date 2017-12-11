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
function music_down(music) {
	location.href = 'http://localhost/PHP_Shop/Album/Down_Load.php?musicname='+music;
}
function hits(music){
	location = 'http://localhost/PHP_Shop/Album/Hits.php?musicname='+music;
}
</script>
</head>

<body>
	<div class="wrap">
		<header>
			<? include("../Template/Header.php") ?>
		</header>
		<div class="clear"></div>
		<h2 class="title">RealTime Chart</h2>
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

	$q = "select * from music order by hits desc";
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

<table class="RealTime" >
<colgroup>
<col width="5%">
<col width="79%">
<col width="8%">
<col width="8%">
</colgroup>
<tr><th>순위</th><th>곡정보</th><th>뮤비</th><th>다운</th> </tr>
<?
		$i = 1;
		while ($row = $result->fetch_array(MYSQL_ASSOC)) {
			$music_original = $row['music'];
			$music_name = str_replace(".mp3", "", $row['music']);
			$music_title = explode("-", $music_name);
			$video_name = $row['video'];
?>

<tr><td style="text-align: center;"><?= $i ?></td><td class="title_intro">
<?php if ($login == 'YES') {
				if ($select['title'] == "1") {
?>
<img src="../img/iconTitle_2.gif">
<?php } ?>
<a href="#" onclick="javascript:hits('<?=$music_original?>')" class="musicName"><?= $music_title[1] ?></a><br><b class="artist_green"><?= $row['artist'] ?></b> <b class="album_color">I <?= $row['album'] ?></b></td><td style="text-align: center;">
<?php
				if ($row['video']) {
?>
<a href="#" onclick="window.open('http://localhost/PHP_Shop/PlayList/VideoPlayer.php?video=<?=$video_name?>','window','width=660, height=600')"> <img src="../img/iconMuviMusic1.gif"></a></td>
<?php } ?>
<td style="text-align: center;">
<a href="javascript:music_down('<?=$row['music']?>')"><img src="../img/iconMuviDown1.gif"></a>
</td></tr>

<?php
			}
			else {
?>
<b class="musicName"><?= $music_title[1] ?></b> <br><b class="artist_green"><?= $row['artist'] ?></b> <b class="album_color">I <?= $row['album'] ?></b></td><td style="text-align: center;">

</td></tr>
<?php
			}
			$i++;
		}
	}
?>
</table>
</div>

			</article>
		</section>
		<footer>
		<? include("../Template/Footer.php") ?>
	</footer>
	</div>
	
</body>
</html>


