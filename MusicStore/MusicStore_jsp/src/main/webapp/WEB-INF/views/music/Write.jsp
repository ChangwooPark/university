<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<jsp:include page="../Template/Header.jsp"></jsp:include>
		</header>
		<div class="clear"></div>
		<h2 class="title">Music Write</h2>
		<hr class="title_hr" color="#59DA50">
		<section>

			<article>
				<div class="Login">
					<form:form method="post" enctype="multipart/form-data" commandName="Music"
						action="../music/Write_Process.do">
						<!--<form method="post" name="writeform" 
						action="../music/Write_Process.do"  enctype="multipart/form-data"> -->
						<table class="Album" cellpadding=5px>
							<tr>
								<td>앨범 이름</td>
								<td><input type="text" name="album" size="18"></td>
							</tr>
							<tr>
								<td>제목</td>
								<td><input type="text" name="name" size="18"></td>
							</tr>
							<tr>
								<td>아티스트</td>
								<td><input type="text" name="artist" size="18"></td>
							</tr>
							<tr>
								<td>발매일</td>
								<td><input type="date" name="regis_date"></td>
							</tr>
							
							<tr>
								<td>장르</td>
								<td><input type="text" name="genre" size="18"></td>
							</tr>
							<tr>
								<td>앨범 사진</td>
								<td><input type="file" name="picture" size="18"></td>
							</tr>
							<tr>
								<td>음악</td>
								<td><input type="file" name="music" size="18"></td>
							</tr>
							<tr>
								<td>뮤직비디오</td>
								<td><input type="file" name="video" size="18"></td>
							</tr>
							<tr>
								<td colspan="2"><input type=submit value="등록하기"
									height="30px;"> <input type="button" value="취소하기"
									onclick="javascript:window.location=../music/NewAlbum.do'">
								</td>
							</tr>
						</table>
					</form:form>
				</div>
			</article>
		</section>
		<footer>
			<jsp:include page="../Template/Footer.jsp"></jsp:include>
		</footer>
	</div>
</body>
</html>