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
function ListAdd(idx, userid,music) {
	alert("MyPlayList에 담겼습니다.");
	location = 'http://localhost/PHP_Shop/PlayList/UserPlayListAdd.php?idx='+idx+'&userid='+userid+'&music='+music;
}
</script>
</head>

<body>
	<div class="wrap">
		<header>
			<? include("../Template/Header.php") ?>
		</header>
		<div class="clear"></div>
		<h2 class="title">Detail</h2>
		<hr class="title_hr" color="#59DA50">
		<section>
			<article>
				<div class="newAlbum">
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
	$q = "select * from music where idx='$idx'";
	$result = $mysqli->query($q);
	$row = $result->fetch_array(MYSQL_ASSOC);
?>
<div class="newAlbumHeadBox">
<h2><img  src="../img/h2AlbumTi01.gif"></h2>  <span class="titT"><?= $row['album'] ?></span>
</div>
<div class="clear"></div>
<table class="alBox1">
<tr>
<td rowspan="5"> <img src="../Upload_picture/<?=$row['album_picture']?>" style="width: 200px;height: 200px;"> </td>
<td><b class="title">아티스트</b> <b class="value"><?= $row['artist'] ?></b></td>
</tr>
<tr><td><b class="title">발매일</b> <b class="value"><?= $row['regis_date'] ?></b></td></tr>
<tr><td><b class="title">기획사</b> <b class="value"><?= $row['agency'] ?></b></td></tr>
<tr><td><b class="title">장르</b><b class="value"><?= $row['genre'] ?></b></td></tr>

</table>
				</div>
				<div>
				<?php
	$album = $row['album'];
	$album_select = "select * from music where album='$album'";
	$result = $mysqli->query($album_select);
?>
	<table class="albumdetail">
	<colgroup>
	<col width="3%">
	<col width="67%">
	<col width="10%">
	<col width="5%">
	<col width="5%">
	<col width="5%">
	<col width="5%">
	</colgroup>
<tr><th>No.</th><th>곡</th><th>아티스트</th><th>뮤비</th><th>담기</th><th>다운</th></tr>
<?
	$i = 1;
	while ($select = $result->fetch_array(MYSQL_ASSOC)) {
		$music_original = $select['music'];
		$music_name = str_replace(".mp3", "", $select['music']);
		$music_title = explode("-", $music_name);
		$video_name = $select['video'];
		$idx = $select['idx'];
?>

<tr><td><?= $i ?></td><td>
<?php if ($login == 'YES') {
			if ($select['title'] == "1") {
?>
<img src="../img/iconTitle_2.gif">
<?php } ?>
<a href="#" onclick="javascript:hits('<?=$music_original?>')" class="musicName"><?= $music_title[1] ?></a></td><td><?= $select['artist'] ?></td><td style="text-align: center;">
<?php
			if ($select['video']) {
?>
<a href="#" onclick="window.open('http://localhost/PHP_Shop/PlayList/VideoPlayer.php?video=<?=$video_name?>','window','width=660, height=600')"> <img src="../img/iconMuviMusic1.gif"></a></td>
<?php } ?>
<td style="text-align: center;">
<a href="#" onclick="javascript:ListAdd('<?=$idx?>', '<?=$userid?>', '<?=$music_original?>')"><img src="../img/iconMuviCart1.gif"></a>
</td>
<td style="text-align: center;">
<a href="javascript:music_down('<?=$select['music']?>')"><img src="../img/iconMuviDown1.gif"></a>
</td></tr>

<?php
		}
		else {
?>
<?
			if ($select['title'] == "1") {
?>
<img src="../img/iconTitle_2.gif">
<?php } ?>
<?= $music_name ?></td><td><?= $select['artist'] ?></td><td style="text-align: center;">

</td></tr>
<?php
		}
		$i++;
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

