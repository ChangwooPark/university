<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<script src="../SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<script type="text/javascript">
	function playlist(userid){
		window.open('http://localhost/PHP_Shop/PlayList/UserPlayList.php?userid='+userid,+'window','width=350, height=400');
		
	}
</script>
</head>

<body style="height: auto;">
	<div class="clear">
		<a href="http://localhost/PHP_Shop/index.php"><img
			src="http://localhost/PHP_Shop/img/logo1.gif" width="300" height="200"> </a> <span
			class="Loginmenu">
			<div class="Loginsub">
			<?php
	session_start();
	$login = $_SESSION['login'];
	$name = $_SESSION['name'];
	$userid = $_SESSION['id'];
	if ($login == 'YES') {
		echo $name;
?>님 안녕하세요.
				<a href="http://localhost/PHP_Shop/Login/Logout.php" class="musicName">로그아웃</a>
				<a href="http://localhost/PHP_Shop/Login/Modify.php" class="musicName">회원정보수정</a>
				<a href="#" onclick="javascript:playlist('<?=$userid?>')" class="musicName">PlayList</a>
				<a href="http://localhost/PHP_Shop/Login/Delete.php" class="musicName">회원탈퇴</a>
				<?php }
	else {
?>
				
				<a href="http://localhost/PHP_Shop/Login/Login.php" class="musicName">로그인</a> <a
					href="http://localhost/PHP_Shop/Login/NewMember.php" class="musicName">회원가입</a> <a
					href="http://localhost/PHP_Shop/Login/Find.php" class="musicName">ID/PW찾기</a>
					<?php } ?>
			</div>
		</span>
	</div>
	<nav id="topmenu">
		<div id="topmenu">
			<ul id="MenuBar1" class="MenuBarHorizontal">
				<li><a href="http://localhost/PHP_Shop/Album/NewAlbum.php">최신앨범</a>
				</li>
				<li><a class="MenuBarItemSubmenu" href="#">차트</a>
					<ul>
						<li><a href="http://localhost/PHP_Shop/Chart/Time_Chart.php">실시간 순위</a></li>
						<li><a href="#">TOP 100</a></li>
					</ul>
				</li>
				<li><a href="#">뮤직비디오</a></li>
				<li><a href="http://localhost/PHP_Shop/MusicStory/MusicStory.php">뮤직스토리</a>
				</li>
				<li><a class="#">게시판</a>
					<ul>
						<li><a href="#">자유 게시판</a></li>
						<li><a href="#">Q & A</a></li>
					</ul>
			
			</ul>
		</div>
		<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
</script>
	</nav>
</body>
</html>
