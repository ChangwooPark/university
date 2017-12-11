<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="/resources/SpryAssets/SpryMenuBarHorizontal.css"
	rel="stylesheet" type="text/css">
<script src="/resources/SpryAssets/SpryMenuBar.js"
	type="text/javascript"></script>
</head>
<body>
	<div class="wrap">
		<header>
			<jsp:include page="../Template/Header.jsp"></jsp:include>
		</header>
		<div class="clear"></div>
		<h2 class="title">MusicView</h2>
		<hr class="title_hr" color="#59DA50">
		<section>
			<article>
				<div class="clear"></div>
				<div class="Album">
					
					<table class="Album">
						<colgroup>
							<col width="15%">
							<col width="30%">
							<col width="7%">
							<col width="7%">
						</colgroup>

						<tr>
							<td><img class="AlbumPicture"
						src="/resources/Upload_picture/${music.getPicture() }"></td>
							<td></td>
							<td><a href="#"
								onclick="javascript:window.open('../playlist/PlayList.do?music=${music.getMusic()}', 'window', 'width=350, height=400'); return false;">
									<img src="/resources/img/iconMuviCart1.gif">
							</a></td>
							<td><a href="#"
								onclick="window.open('../playlist/VideoPlayer.do?video=${music.getVideo()}','window','width=660, height=600')"><img
									src="/resources/img/iconMuviMusic1.gif"></a></td>
						</tr>

						<tr>
							<td>제목</td>
							<td>${music.getName()}</td>
						</tr>
						<tr>
							<td>가수</td>
							<td>${music.getArtist()}</td>
						</tr>
						<tr>
							<td>앨범</td>
							<td>${music.getAlbum()}</td>
						</tr>
						<tr>
							<td>장르</td>
							<td>${music.getGenre()}</td>
						</tr>
						<tr>
							<td>등록일</td>
							<td>${music.getRegis_date()}</td>
						</tr>

					</table>
				</div>




			</article>
		</section>
		<footer>
			<jsp:include page="../Template/Footer.jsp"></jsp:include>
		</footer>
	</div>
</body>
</html>