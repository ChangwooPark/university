<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="/resources/SpryAssets/SpryMenuBarHorizontal.css"
	rel="stylesheet" type="text/css">
<script src="/resources/SpryAssets/SpryMenuBar.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function playlist(music) {
		//alert(music);
		window.open(music, 'window', 'width=350, height=400');
	}
</script>
</head>
<body>
	<div class="wrap">
		<header>
			<jsp:include page="../Template/Header.jsp"></jsp:include>
		</header>
		<div class="clear"></div>
		<h2 class="title">New Album</h2>
		<hr class="title_hr" color="#59DA50">
		<section>
			<article>
				<c:if test="${is_List == true}">
					<div style="text-align: center; margin-top: 20%;">
						<b> 곡이 존재하지 않습니다.</b>
					</div>
				</c:if>
				<div class="clear"></div>
				<c:if test="${is_List == false }">
					<div class="Album">
						<table class="Album">
							<colgroup>
								<col width="10%">
								<col width="30%">
								<col width="20%">
								<col width="7%">
								<col width="7%">
								<col width="7%">
								<col width="21%">

							</colgroup>
							<tr>
								<td>앨범사진</td>
								<td>제목</td>
								<td>가수</td>
								<td>듣기</td>
								<td>뮤비</td>
								<td>다운</td>
							</tr>
							<c:forEach var="albumlist" items="${albumList }"
								varStatus="status">
								<tr>
									<td><img class="AlbumPicture"
										src="/resources/Upload_picture/${albumlist.getPicture() }"></td>
									<td><a
										href="../music/musicview.do?music_idx=${albumlist.getMusic_idx()}"
										class="musicName">${albumlist.getName()}</a></td>
									<td>${albumlist.getArtist() }</td>
									<td><a href="#"
										onclick="javascript:window.open('../playlist/PlayList.do?music=${albumlist.getMusic()}', 'window', 'width=350, height=400'); return false;">
											<img src="/resources/img/iconMuviCart1.gif">
									</a></td>
									<c:if test="${albumlist.getVideo() != null}">
										<td><a href="#"
											onclick="window.open('../playlist/VideoPlayer.do?video=${albumlist.getVideo()}','window','width=660, height=600')"><img
												src="/resources/img/iconMuviMusic1.gif"></a></td>
									</c:if>
									<c:if test="${albumlist.getVideo() == null }">
										<td></td>
									</c:if>
									<td><a
										onclick="window.open('../playlist/playlistSelect.do?music_idx=${albumlist.getMusic_idx()}','window','width=250, height=250')"><img
											src="/resources/img/iconMuviDown1.gif"></a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</c:if>
				<div style="float: right; margin-right: 20%; margin-top: 40px;">
					<input type="button" value="글쓰기"
						onclick="javascript:location='/music/Write.do'"> <input
						type="button" value="삭제하기"
						onclick="javascript:location='Delete.php'">
				</div>
			</article>
		</section>
		<footer>
			<jsp:include page="../Template/Footer.jsp"></jsp:include>
		</footer>
	</div>

</body>

</html>