<?php
	ob_start();
	extract($_GET);
	$downpath = "../Upload_music/".$musicname;

	if (is_file($downpath)) {
		header("Content-Type: application/octet-stream");
		header("Content-Disposition: attachment; filename=$musicname");
		header("Content-type:file/unknown");
		header("Content-Description: PHP4 Generated Data");
		header("Content-Transfer-Encoding: binary");
		header("Content-Length: ".filesize($downpath));
		header("Cache-Control: cache, must-revalidate");
		header("Pragma: no-cache");
		header("Expires: 0");
	}

	$fp = fopen($downpath, "rb");
	if (!fpassthru($fp)) {
		fclose($fp);
	}
	else {
		echo "<script>alert('존재하지 않는 파일입니다.');</script>";
	}
?>