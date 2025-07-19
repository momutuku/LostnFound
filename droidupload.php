<?php

$email = $_POST['email'];
$name = $_POST['name'];
$phone = $_POST['phone'];
$password = $_POST['password'];
$imginfo = $_FILES['img']['name'];
$conn = mysqli_connect("localhost", "id12816412_mo", "qwertyuiop", "id12816412_id");


$target_dir = "../uploads/";
$tdir = "uploads/";
$extt = explode(".", $_FILES["img"]["name"]);
$target_file = $target_dir.$phone.".".$extt[1];
$loc = $tdir.$phone.".".$extt[1];

if (!$conn) {
  die("Error connecting to database: " . mysqli_connect_error());
}


try {
    if (move_uploaded_file($_FILES["img"]["tmp_name"], $target_file)) {
      $sql2 = "INSERT INTO users (email,password,fname,lname,phone,imgloc,baseimg) VALUES('$email','$password','$name','$name','$phone','$loc','$name')";
    if(mysqli_query($conn,$sql2)){
        echo $email.":".$name.":".$name.":".$phone;
    }
    else{
        echo $conn->error."Error:Error:Error:Error";
    }
    } else {
        echo "Sorry, there was an error uploading your file.";
    }


} catch (Exception $e) {
      echo $e;
}











?>
