<?php
	session_start();
if (!isset($_SESSION['user'])) {
	$conn = mysqli_connect("localhost", "root", "", "id");

	if (!$conn) {
		die("Error connecting to database: " . mysqli_connect_error());
	}

$email = $_POST['email'];
$password = $_POST['password'];
// TODO: Password Encryption


$sql2 = "SELECT * FROM users WHERE email='$email' LIMIT 1";
$result = $conn->query($sql2);

if ($result ) {
	if (($result->num_rows)>0) {
		while($row = $result->fetch_assoc()) {
				$correctpass = $row['password'];
				$fname = $row['fname'];
				$lname = $row['lname'];
				$prof = $row['imgloc'];

				if ($password==$correctpass) {
					// TODO: Password compare
					// session_start();
					$_SESSION['user']=$email;
					$_SESSION['fname']=$fname;
					$_SESSION['lname']=$lname;
					$_SESSION['prof']=$prof;

					header("Location:../dashboard.php");
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


}
else{
	session_destroy();
	header("Location:../index.php");
}
 ?>
