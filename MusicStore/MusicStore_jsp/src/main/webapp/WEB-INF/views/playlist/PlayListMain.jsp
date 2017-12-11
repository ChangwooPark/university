<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Login</title>
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
		<h2 class="title">PlayList</h2>
		<hr class="title_hr" color="#59DA50">
		<section>
			<article>
				<c:if test="${Is_playlist == true }">
					<div style="text-align: center; margin-top: 20%;">
						<b> PlayList가 존재하지 않습니다.</b>
					</div>
				</c:if>
				<c:if test="${Is_playlist == false }">

					<table class="Album" cellpadding=5px style="text-align: center;">
						<thead>
							<tr>
								<th>PlayList Name</th>

								<th></th>
							</tr>
							<c:forEach items="${playlist }" var="playlist" varStatus="status">
								<tr>
									<td>${playlist.getPlaylist_idx()}</td>
									<td><input type="button" value="삭제하기"
										onclick="javascript:location='../playlist/Delete.do?playlist_idx='+${playlist.getPlaylist_idx()}"></td>
								</tr>
							</c:forEach>
					</table>
	</div>
	</c:if>
	<div style="float: right; margin-right: 20%; margin-top: 40px;">
		<input type="button" value="추가하기"
			onclick="javascript:location='../playlist/Add.do'">
	</div>
	</article>
	</section>
	<footer>
		<jsp:include page="../Template/Footer.jsp"></jsp:include>
	</footer>
	</div>
</body>