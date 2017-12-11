<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="/resources/SpryAsserts/SpryMenuBarHorizontal.css"
	rel="stylesheet" type="text/css">
<script src="/resourcesSpryAssets/SpryMenuBar.js" type="text/javascript"></script>
</head>
<body bgcolor="#F3F3F3">

	<div class="PlayListTitle">
		<span class="PlayListTitle"><h3 class="PlayListTitle1">MusicVideo
				Player</h3></span>
	</div>
	<div class="clear"></div>
	<hr class="title_hr" color="#59DA50"
		style="margin-left: 0; margin-bottom: 20px;">

	<div class="clear"></div>
	<div>
		<video src="/resources/Upload_video/${video }" controls="controls"
			height="300" width="640" autoplay="autoplay">
		</video>
	</div>
	<table class="PlayTable"
		style="text-align: left; width: 500px; margin-left: 20px;">
		<c:forEach items="${musiclist }" var="musiclist" varStatus="status">
			<tr>
				<td colspan="2" style="padding-bottom: 10px; padding-top: 5px;"><b
					style="color: #2d2d2d;"> ${musiclist.getName() } </b></td>
			</tr>
			<tr>
				<td style="padding-bottom: 5px; padding-top: 5px;">가수명</td>
				<td>${musiclist.getArtist() }</td>
			<tr>
				<td style="padding-bottom: 5px; padding-top: 5px;">앨범</td>
				<td>${musiclist.getAlbum() }</td>
			<tr>
				<td style="padding-bottom: 5px; padding-top: 5px;">장르</td>
				<td>${musiclist.getGenre() }</td>
		</c:forEach>
	</table>
</body>
</html>