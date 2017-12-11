<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Music Play List</title>
<link href="http://localhost/PHP_Shop/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">

	
	//musiclist = document.getElementById('musiclist');
	 pointer = 0;
	function next(){
		
		 playlists = new Array();
			num  = document.getElementById('num').value;
		 for(var i = 0; i < num ; i++){
				playlists[i] = "http://localhost/PHP_Shop/Upload_music/" + document.getElementById('musiclist'+i).value;
			}
	
		var source = document.getElementById('source');
		var player = document.getElementById('player');
		pointer++;
		if(pointer >= num){
			pointer = 0;
		}
		source.src = playlists[pointer];
		
		player.load();
		player.play();
	}	
</script>
</head>
<body bgcolor="#F3F3F3">
<?
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_GET);
	$q = "select * from musiclist where user_id = '$userid'";
	$result = $mysqli->query($q);
	$music_row = $result->fetch_array(MYSQL_ASSOC);
	$music = $music_row['music'];
	$music_list = $mysqli->query($q);
	$playmusiclist = $mysqli->query($q);
	$musiclist = array(100);
	$listnum = 0;
	while ($list = $playmusiclist->fetch_array(MYSQL_ASSOC)) {

		$musiclist[$listnum] = $list['music'];
		$listnum = $listnum + 1;
	}
?>
<input type="hidden" value = "<?=$listnum?>" id = "num">
<?php
	for ($i = 0; $i < $listnum; $i++) {
?>
  <input type="hidden" value="<?=$musiclist[$i]?>" id = "musiclist<?=$i?>">
<?php } ?>
<!-- <input type="hidden" value="<?=$musiclist[i]?>" id = "musiclist">-->

<div class="PlayListTitle">
<span class="PlayListTitle"><h3 class="PlayListTitle1" >User Music Play List</h3></span> 
</div>
<div class="clear"></div>
<hr class="title_hr" color="#59DA50" style="margin-left: 0; margin-bottom: 20px;">

<div class="clear"></div>

<div>

<audio controls="controls" preload="auto"   id = "player" onended="next();">
<source src="http://localhost/PHP_Shop/Upload_music/<?=$musiclist[0]?>" id="source"> </source>
</audio>


</div>
<table class="PlayTable" style="width: 360px;">
<colgroup>
<col width="8%">
<col width="52%">
<col width="25%">
<col width="10%">
</colgroup>
<tr><th>No.</th><th>곡명</th><th>아티스트</th>
<?php
	$i = 1;
	while ($row = $music_list->fetch_array(MYSQL_ASSOC)) {
		$idx = $row['idx'];
		$musicq = "select * from music where idx ='$idx'";
		$musicresult = $mysqli->query($musicq);
		$musicrow = $musicresult->fetch_array(MYSQL_ASSOC);

		$playmusic = str_replace(".mp3", "", $musicrow['music']);
		$music_title = explode("-", $playmusic);
?>
		<tr><td><?= $i ?></td><td><?= $music_title[1] ?></td><td><?= $musicrow['artist'] ?></td><td><a href="http://localhost/PHP_Shop/PlayList/listdelete.php?idx=<?=$idx?>"> <input type="button" value = "삭제"></a> </td></tr>
		<?
		$i++;
	}
?>
</table>
</body>
</html>