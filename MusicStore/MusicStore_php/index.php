<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>listen to</title>
<link href="style.css" rel="stylesheet" type="text/css">
<link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet"
	type="text/css">
<script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<script type="text/javascript">
function Search() {
	var form = document.searchform;
	if (form.search.value == "") {
		alert("단어를 입력해주세요");
		form.search.focus();
		return;
	}

	form.submit();
}
</script>
</head>
<body>
	<div class="wrap">
		<header>
			<? include("Template/Header.php") ?>
		</header>
		<div class="clear"></div>
		<div style="margin-top: 20px; margin-bottom: 20px; margin-left: 40px;">
		<form action="http://localhost/PHP_Shop/search.php" method="post" name = "searchform">
			<select name = "search_cate">
				<option value="1">아티스트</option>
				<option value="2">곡</option>
				</select>
				<input type="text" name = "search" id = "search">
				<input type="button" value="검색" onclick="Search();">
			</form>
		</div>
		<div class="clear"></div>
		<iframe src="Main/MainFrame.php" class="MainFrame" id="MainIframe"></iframe>
		<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
</script>
		<footer>
		<?include("Template/Footer.php") ?>
	</footer>
	</div>
	

</html>
