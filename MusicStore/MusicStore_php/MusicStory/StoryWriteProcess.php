<script type="text/javascript">

function Success(){
	alert("등록이 완료 되었습니다.");
	location = "http://localhost/PHP_Shop/MusicStory/MusicStory.php";
}
</script>

<?
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_POST);
	$musicpicture = '../Story_Picture/';
	$picture = $_FILES['picture']['name'];
	
	
	$insert = "insert into musicstory (title, article,picture) values('$title', '$article', '$picture')";

	$result = $mysqli->query($insert) or die(__FILE__.":Line".__LINE__."<p>Query:$result<br><br><br>".$mysqli->error);

	move_uploaded_file($_FILES['picture']['tmp_name'], $musicpicture.$_FILES['picture']['name']);
	echo("<script language='javascript'>Success();</script>");
?>