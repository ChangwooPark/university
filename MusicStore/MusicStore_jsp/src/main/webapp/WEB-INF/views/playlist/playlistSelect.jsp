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
		<span class="PlayListTitle"><h3 class="PlayListTitle1">Music
				PlayList Select</h3></span>
	</div>
	<div class="clear"></div>
	<hr class="title_hr" color="#59DA50"
		style="margin-left: 0; margin-bottom: 20px;">

	<div class="clear"></div>
	<div class="playmusicdiv">
		<b class="playmusic"> </b>
	</div>

	<table class="PlayTable" style="text-align: center;">
		<colgroup>
			<col width="8%">
			<col width="62%">
			<col width="30%">
		</colgroup>
		<tr>PlayList
		</tr>
		<c:forEach items="${playlist }" var="playlist" varStatus="status">
			<tr>
				<td>${playlist.getPlaylist_idx() }</td>
				<td><input type="button" value="선택하기"
					onclick="javascript:location='../playlist/musicAdd.do?playlist_idx=${playlist.getPlaylist_idx()}&music_idx=${music_idx}'" /></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>