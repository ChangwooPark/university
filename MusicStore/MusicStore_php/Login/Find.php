<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<link href="../SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet"
	type="text/css">
<script src="../SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<script type="text/javascript">
function name() {
	
}

</script>

</head>
<body>
<div class="wrap">
		<header>
			<? include("../Template/Header.php") ?>
		</header>
		<div class="clear"></div>
		<h2 class="title">Find ID & Password</h2>
		<hr class="title_hr" color="#59DA50">
		<section>
		<article>
		<div class="Login">
		<form action = "FindProcess.php" method="post">
		<table style="margin: auto;">
		<tr>
		<td>이름 </td>
		<td>
		<input type="text" name = name size=17 required>
		</td></tr>
		<tr>
		<td>주민등록번호</td>
		<td>
		<input type="text" name = register1 size = 5 maxlength="6" pattern="\d{6}" required>-<input type="password" name = register2 size = 5 maxlength="7" pattern="\d{7}" required>
		</td></tr>
		<tr>
		<td colspan="2" style="margin-top: 15px;">
		<input type="submit" value = "찾기" ><input type="button" value="돌아가기" onclick="javascript:history.back();">
		</td></tr>
				
		</table>
		</form>
		</div>
		
		</article>
<? ?>
</section>
<footer>
		<? include("../Template/Footer.php") ?>
	</footer>
	</div>
	
</body>
</html>