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
function Success_Write() {
	var form = document.writeform;



	if (form.album.value == "") {
		alert("앨범 이름을 확인해주세요.");
		form.album.focus();
		return;
	}
	if (form.artist.value == "") {
		alert("아티스트를 확인해주세요.");
		form.artist.focus();
		return;
	}

	if (form.regis_date.value == "") {
		alert("발매일을 입력해주세요.");
		form.regis_date.focus();
		return;
	}
	if (form.agency.value == "") {
		alert("기획사을 확인해주세요.");
		form.agency.focus();
		return;
	}

	if (form.genre.value == "") {
		alert("장르를 확인해주세요.");
		form.genre.focus();
		return;
	}
	if (form.album_picture.value == "") {
		alert("앨범 사진을 선택해주세요.");
		form.album_picture.focus();
		return;
	}
	if (form.music.value == "") {
		alert("노래를 선택해주세요.");
		form.music.focus();
		return;
	}
	
	form.submit();
}
</script>
</head>

<body>
	<div class="wrap">
		<header>
			<? include("../Template/Header.php") ?>
		</header>
		<div class="clear"></div>
		<h2 class="title">Music Write</h2>
		<hr class="title_hr" color="#59DA50">
		<section>

			<article>
				<div class="Login">
				<form method="post" name="writeform"
					action="WriteProcess.php"
					enctype="multipart/form-data">
					<table class="Album" cellpadding=5px >
					<tr>
					<td>앨범 이름</td><td><input type="text" name = "album"  size = "18"></td>
					</tr>
					<tr>
					<td>아티스트</td><td><input type="text"  name = "artist" size = "18"></td>
					</tr>
					<tr>
					<td>발매일</td><td><input type="date"  name="regis_date"  ></td>
					</tr>
					<tr>
					<td>기획사</td><td><input type="text"  name="agency" size = "18"></td>
					</tr>
					<tr>
					<td>장르</td><td><input type="text"  name="genre" size = "18"></td>
					</tr>
					<tr>
					<td>앨범 사진</td><td><input type="file"  name="album_picture" size = "18"></td>
					</tr>
					<tr>
					<td>음악</td><td><input type="file" name = "music" size = "18"></td>
					</tr>
					<tr>
					<td>뮤직비디오</td><td><input type="file" name = "video" size = "18"></td>
					</tr>
					<tr>			
					<td >타이틀</td><td style="text-align: left;"><input type="checkbox" checked="checked" name="title" size = "18" style="margin-left: 60px;"></td>
					</tr>
					<tr>
					<td colspan="2"><input type="button" value = "등록하기" onclick="Success_Write();">
					<input type="button" value = "취소하기" onclick="javascript:window.location='http://localhost/PHP_Shop/index.php'">
					 </td>
					</tr>
					</table>
					</form>
				</div>
			</article>
		</section>
		<footer>
		<? include("../Template/Footer.php") ?>
	</footer>
	</div>
</body>
</html>
