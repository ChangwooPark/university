<!doctype html>
<html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<head>
<meta charset="utf-8">
<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="/resources/SpryAssets/SpryMenuBarHorizontal.css"
	rel="stylesheet" type="text/css">
<script src="/resources/SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
	<title>UntitledDocument</title>
</head>

<body>
	<section style="min-height: 400px;">
		<article class="main">
			<div class="clear">
				<span class="NewAlbum"> <jsp:include page="MainNewAlbum.jsp"></jsp:include>
				</span> <span class="TimeChart"> <jsp:include page="MainTimeChart.jsp"></jsp:include>
				</span>
			</div>
			<div class="clear"></div>
			<span class="MusicStory"> <jsp:include page="MainMusicStory.jsp"></jsp:include>

			</span>

		</article>
	</section>

</body>
</html>
