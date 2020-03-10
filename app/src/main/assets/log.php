<?php
	$conn = mysqli_connect("localhost", "id12816412_mo", "qwertyuiop", "id12816412_id");

	if (!$conn) {
		die("Error connecting to database: " . mysqli_connect_error());
	}

$email = $_POST['email'];
$password = $_POST['pass'];
// TODO: Password Encryption
$info =[];
$res ="";


$sql2 = "SELECT * FROM users WHERE email='$email' LIMIT 1";
$result = $conn->query($sql2);

if ($result ) {
	if (($result->num_rows)>0) {
		while($row = $result->fetch_assoc()) {
				$correctpass = $row['password'];
				$fname = $row['fname'];
				$lname = $row['lname'];

				if ($password==$correctpass) {

					$_SESSION['user']=$email;
					$_SESSION['fname']=$fname;
					$_SESSION['lname']=$lname;
					$res .=$email;
					$res .="-";
					$res .=$fname;
					$res .="-";
					$res .=$lname;
					echo $email.".".$fname;
				// 	echo "Login Done";


				// 	$info = arraypush($email,$fname);


				}else{
					echo "Wrong Password";
				}
		 }
	}else{
		echo "No Such user";
	}

}
else{
	echo "Error";
}


 ?>
