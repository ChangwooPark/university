<!doctype html>
<html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="/resources/SpryAssets/SpryMenuBarHorizontal.css"
	rel="stylesheet" type="text/css">
<script src="/resources/SpryAssets/SpryMenuBar.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function playlist() {
		window.open('../playlist/PlayList.do', 'window', 'width=350, height=400');
	}
	//javascript:playlist()
</script>
</head>

<body style="height: auto;">
	<div class="clear">
		<a href="../"><img src="/resources/img/logo1.gif" width="300"
			height="200"> </a> <span class="Loginmenu"> <c:if
				test="${not empty sessionScope.name }">
				<div class="Loginsub">
					<a href="../Member/logout.do" class="musicName">로그아웃</a> <a
						href="../Member/Modify.do" class="musicName">회원정보수정</a> <a
						href="../playlist/PlayListMain.do" class="musicName">PlayList</a>
					<a href="../Member/Delete.do" class="musicName">회원탈퇴</a>
				</div>
			</c:if> <c:if test="${empty sessionScope.name }">
				<div class="Loginsub">

					<a href="../Member/login.do" class="musicName">로그인</a> <a
						href="../Member/NewMember.do" class="musicName">회원가입</a> <a
						href="#" class="musicName">ID/PW찾기</a>
				</div>
			</c:if>

		</span>
	</div>
	<nav id="topmenu">
		<div id="topmenu">
			<ul id="MenuBar1" class="MenuBarHorizontal">
				<li><a href="../music/NewAlbum.do">최신앨범</a></li>
				<li><a class="MenuBarItemSubmenu" href="#">차트</a>
					<ul>
						<li><a href="*">실시간 순위</a></li>
						<li><a href="#">TOP 100</a></li>
					</ul></li>
				<li><a href="#">뮤직비디오</a></li>
				<li><a href="*">뮤직스토리</a></li>
				<li><a class="#">게시판</a>
					<ul>
						<li><a href="#">자유 게시판</a></li>
						<li><a href="#">Q & A</a></li>
					</ul>
			</ul>
		</div>
		<script type="text/javascript">
			var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {
				imgDown : "SpryAssets/SpryMenuBarDownHover.gif",
				imgRight : "SpryAssets/SpryMenuBarRightHover.gif"
			});
		</script>
	</nav>
</body>
</html>
