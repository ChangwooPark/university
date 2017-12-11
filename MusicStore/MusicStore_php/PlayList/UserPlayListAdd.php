<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function Success(){
	history.back();
}
</script>
</head>
<body>
<?
	session_start();

	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_GET);

	$userid = $_SESSION['id'];
	$q = "insert into musiclist (user_id, idx, music) values('$userid','$idx', '$music')";
	$mysqli->query($q) or die(__FILE__.":Line".__LINE__."<p>Query:$q<br><br><br>".$mysqli->error);
	
	echo("<script language='javascript'>Success();</script>");
?>
</body>
</html>