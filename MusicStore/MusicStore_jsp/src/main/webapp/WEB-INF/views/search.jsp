<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="/resources/SpryAssets/SpryMenuBarHorizontal.css"
	rel="stylesheet" type="text/css">
<script src="/resources/SpryAssets/SpryMenuBar.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function music_down(music) {
		location.href = 'http://localhost/PHP_Shop/Album/Down_Load.php?musicname='
				+ music;
	}
	function hits(music) {
		location = 'http://localhost/PHP_Shop/Album/Hits.php?musicname='
				+ music;
	}
</script>
</head>

<body>
	<div class="wrap">
		<header>
			<jsp:include page="Template/Header.jsp"></jsp:include>
		</header>
		<div class="clear"></div>
		<h2 class="title">Search</h2>
		<hr class="title_hr" color="#59DA50">
		<section>

			<article>
				<div style="text-align: center; margin-top: 20%;">
					<b> 곡이 존재하지 않습니다.</b>
				</div>

				<table class="RealTime">
					<colgroup>
						<col width="5%">
						<col width="79%">
						<col width="8%">
						<col width="8%">
					</colgroup>
					<tr>
						<th>순위</th>
						<th>곡정보</th>
						<th>뮤비</th>
						<th>다운</th>
					</tr>

					<tr>
						<td style="text-align: center;">
							<?= $i ?>
						</td>
						<td class="title_intro"><img src="../img/iconTitle_2.gif">
							<a href="#" onclick="javascript:hits('<?=$music_original?>')"
							class="musicName"> <?= $music_title[1] ?>
						</a><br> <b class="artist_green"> <?= $row['artist'] ?>
						</b> <b class="album_color">I <?= $row['album'] ?></b></td>
						<td style="text-align: center;"><a href="#"
							onclick="window.open('http://localhost/PHP_Shop/PlayList/VideoPlayer.php?video=<?=$video_name?>','window','width=660, height=600')">
								<img src="img/iconMuviMusic1.gif">
						</a></td>
						<td style="text-align: center;"><a
							href="javascript:music_down('<?=$row['music']?>')"><img
								src="img/iconMuviDown1.gif"></a></td>
					</tr>

					<b class="musicName"> <?= $music_title[1] ?>
					</b>
					<br>
					<b class="artist_green"> <?= $row['artist'] ?>
					</b>
					<b class="album_color">I <?= $row['album'] ?></b>
					</td>
					<td style="text-align: center;"></td>
					</tr>
				</table>
	</div>

	</article>
	</section>
	<footer>
		<jsp:include page="Template/Footer.jsp"></jsp:include>
	</footer>
	</div>

</body>
</html>

