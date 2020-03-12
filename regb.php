<?php
	$conn = mysqli_connect("localhost", "id12816412_mo", "qwertyuiop", "id12816412_id");

	if (!$conn) {
		die("Error connecting to database: " . mysqli_connect_error());
	}

$email = $_POST['email'];
$name = $_POST['name'];
$phone = $_POST['phone'];
//$phone = "0765439876";
$password = $_POST['password'];
// TODO: Password Encryption


$sql2 = "INSERT INTO users (email,password,fname,lname,phone,imgloc,baseimg) VALUES('$email','$password','$name','$name','$phone','$name','$name')";
if(mysqli_query($conn,$sql2)){
    // echo $email;
    echo $email.":".$name.":".$name.":".$phone;
}
else{
    echo $conn->error."Error:Error:Error:Error";
}


 ?>
