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
function passcheck() {
	var pass1 = document.getElementById("pass1").value;
	var pass2 = document.getElementById("pass2").value;
	if(pass1 != pass2){
		alert("비밀번호를 다시 확인해주세요");
		document.getElementById("pass1").focus();
		return;
	}
	document.deleteform.submit();
	//window.location = "DeleteProcess.php";
}

</script>
</head>
<body>
<div class="wrap">
		<header>
			<? include("../Template/Header.php") ?>
		</header>
		<div class="clear"></div>
		<h2 class="title">Delete</h2>
		<hr class="title_hr" color="#59DA50">
		<section>

			<article>
				<div class="Login">
					<form action="DeleteProcess.php" method="post" id="deleteform">
						<input type="password" size="15" placeholder="PW" name="pass" id="pass1"> <input
							type="password" size="15" placeholder="PW 확인" id="pass2"><br>
						<div class="clear"></div>
						<input type="submit" size="5" value="회원탈퇴" onclick="passcheck();return false;">
					</form>
				</div>
			</article>
		</section>
		<footer>
		<? include("../Template/Footer.php") ?>
	</footer>
	</div>
	
</body>
</html>