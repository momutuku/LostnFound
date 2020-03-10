<?php
	session_start();

	$conn = mysqli_connect("localhost", "root", "", "id");
$fname = $_POST['fname'];
$lname = $_POST['lname'];
$pass1 = $_POST['pass1'];
$pass2 = $_POST['pass2'];
$email = $_POST['email'];
$tell = $_POST['tell'];

$currentloc = $_FILES["profiles"]['tmp_name'];
print_r($currentloc);

$target_dir = "../profiles/";
$tdir = "profiles/";
$extt = explode(".", $_FILES["profiles"]["name"]);
$target_file = $target_dir.$fname.time().".".$extt[1];
$loc = $tdir.$fname.time().".".$extt[1];
if ($_FILES["profiles"]["size"] <= 500000) {
  if($extt[1] == "jpg" || $extt[1] == "png" || $extt[1] == "jpeg" || $extt[1] == "gif" ) {
      move_uploaded_file($currentloc, $target_file);
  }
}


// TODO: Password Encryption

if ($pass1!=$pass2) {
  header("Location:../register.php stat=Passwords Do Not Match");
}


$sql2 = "INSERT INTO users (email,password,fname,lname,phone,imgloc) VALUES ('$email','$pass1','$fname','$lname','$tell','$loc')";
if ( $conn->query($sql2)) {
  $_SESSION['user']=$email;
  $_SESSION['fname']=$fname;
  $_SESSION['lname']=$lname;
  $_SESSION['prof']=$loc;
  header("Location:../dashboard.php");
}
