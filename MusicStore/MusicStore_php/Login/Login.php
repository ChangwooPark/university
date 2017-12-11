<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<link href="../SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet"
	type="text/css">
<script src="../SpryAssets/SpryMenuBar.js" type="text/javascript"></script>

</head>

<body>
	<div class="wrap">
		<header>
			<? include("../Template/Header.php") ?>
		</header>
		<div class="clear"></div>
		<h2 class="title">Login</h2>
		<hr class="title_hr" color="#59DA50">
		<section>

			<article>
				<div class="Login">
					<form action="LoginCheck.php" method="post">
						<input type="text" size="10" placeholder="ID" name="id"> <input
							type="password" size="10" placeholder="PW" name="pass"><br>
						<div class="clear"></div>
						<input type="submit" size="5" value="Login">
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
