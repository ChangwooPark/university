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
	if (form.title.value == "") {
		alert("제목을 작성해주세요.");
		form.title.focus();
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
		<h2 class="title">Story Modify</h2>
		<hr class="title_hr" color="#59DA50">
		<section>
<?
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_GET);
	$musicpicture = '../Story_Picture/';
	$picture = $_FILES['picture']['name'];
	$q = "select * from musicstory where idx = '$idx'";
	$result = $mysqli->query($q);
	$row = $result->fetch_array(MYSQL_ASSOC);
	$idx = $row['idx'];
?>
			<article>
				<div class="Login">
				<form method="post" name="writeform"
					action="StoryModifyProcess.php?idx=<?=$idx?>"
					enctype="multipart/form-data">
					<table class="Album" cellpadding=5px >
					<tr>
					<td>제목</td><td><input type="text" name = "title"  size = "35" value="<?=$row['title']?>"></td>
					</tr>
					<tr>
					<td>내용</td><td>
					<textarea rows="10" cols="30" name = "article" ><?= $row['article'] ?></textarea>
					</td>
					</tr>
					
					<tr>
					<td>앨범 사진</td><td style="text-align: left;padding-left: 20px;">
					선택된 사진: <?= $row['picture'] ?><br>
					<input type="file"  name="picture" size = "18"></td>
					</tr>
					
					<tr>
					<td colspan="2"><input type="button" value = "수정하기" onclick="Success_Write();">
					<input type="button" value = "취소하기" onclick="javascript:window.location='http://localhost/PHP_Shop/MusicStory/MusicStory.php'">
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
