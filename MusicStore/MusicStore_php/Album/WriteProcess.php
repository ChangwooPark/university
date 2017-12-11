<script type="text/javascript">
function is_music(){
	alert("음악이 이미 존재합니다.");
	history.back();
}
function Success(){
	alert("등록이 완료 되었습니다.");
	location = "http://localhost/PHP_Shop/Album/NewAlbum.php";
}
function title_check(){
	alert("이미 타이틀곡이 등록되어있습니다.");
	history.back();
}
</script>

<?
	include_once('../config.php');
	$mysqli = new mysqli($DB['host'], $DB['id'], $DB['pw'], $DB['db']);
	if (mysqli_connect_error()) {
		exit('Connect Error('.mysqli_connect_errno().')'.mysqli_connect_error());
	}
	extract($_POST);
	if ($title == "on") {
		$titlecheck = 1;
	}
	else {
		$titlecheck = 0;
	}
	$titlecheck = "select title from music where album = '$album'";

	$titleresult = $mysqli->query($titlecheck) or die($mysqli->error);
	$titlecount = $titleresult->fetch_array(MYSQL_ASSOC);
	if ($titlecount->num_rows >= 0) {
		if (($titlecount['title'] == "1") && ($title == "on")) {
			echo("<script language='javascript'>title_check();</script>");

		}
		else {
			if (($_FILES['album_picture']['error'] > 0) && ($_FILES['music']['error'] > 0)) {
				echo $_FILES['album_picture']['error']."<br>";
				echo $_FILES['music']['error'];
			}
			else {
				$uploadmusic = '../Upload_music/';
				$uploadpicture = '../Upload_picture/';
				$uploadvideo = '../Upload_video/';

				$picture = $_FILES['album_picture']['name'];
				$music = $_FILES['music']['name'];
				$video = $_FILES['video']['name'];

				if (file_exists($uploadmusic.$_FILES['music']['name'])) {
					echo("<script language='javascript'>is_music();</script>");
				}
				else {
					if ($title == "on") {
						$titlecheck = 1;
					}
					else {
						$titlecheck = 0;
					}

					$insert = "insert into music (album, artist, title, regis_date, agency, genre, album_picture, music, video, hits) values('$album', '$artist', '$titlecheck', '$regis_date', '$agency', '$genre', '$picture', '$music', '$video',  '0')";

					$result = $mysqli->query($insert) or die(__FILE__.":Line".__LINE__."<p>Query:$result<br><br><br>".$mysqli->error);

					move_uploaded_file($_FILES['music']['tmp_name'], $uploadmusic.$_FILES['music']['name']);

					move_uploaded_file($_FILES['album_picture']['tmp_name'], $uploadpicture.$_FILES['album_picture']['name']);
					move_uploaded_file($_FILES['video']['tmp_name'], $uploadvideo.$_FILES['video']['name']);
					echo("<script language='javascript'>Success();</script>");
				}

			}
		}
	}
	//$uploadfile = $uploaddir. basename($path)

	/*$q_check = "select * from music where album = '$album'";
	 $result = $mysqli->query($q_check);
	 
	 if ($result->num_rows == 0) {
	 $q_check_reg = "select * from users  where register = '$register'";
	 $result_reg = $mysqli->query($q_check_reg);
	 if ($result_reg->num_rows == 0) {
	 
	 $q = "insert into users (id, pass,register, name, address,e_mail,phone) values('$id', '$pass', '$register', '$name', '$address', '$e_mail', '$phone')";
	 $mysqli->query($q);
	 }
	 }*/
?>