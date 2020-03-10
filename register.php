<?php
    session_start();
if (isset($_SESSION['user'])) {
    header("Location:dashboard.php?status=Logged In");
}

 ?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link rel="stylesheet" href="st2.css">
  </head>
  <body>
    <div class="cnt">

      <div class="container">
        <div class="left_info">
          <h1>INFOMATION</h1>
          <p>
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
             Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
             Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
            Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
          </p>
        </div>

        <div class="reg_form">
          <h2>REGISTRATION FORM</h2>
          <form class="" action="includes/register.inc.php" method="post" enctype="multipart/form-data">
            <div class="row">
              <input type="text" name="fname" placeholder="First Name">
              <input type="text" name="lname" placeholder="Last Name">
            </div>
            <br>
            <input type="email" name="email" placeholder="email@domain.com">
            <br>
            <input type="tel" name="tell" placeholder="Phone Number">
            <br>
            <div class="row">
              <input type="password" name="pass1" placeholder="Password">
              <input type="Password" name="pass2" placeholder="Confirm Password">
            </div>
            <br>
            <input  type="file" name="profiles">
            <br>
            <input class="btn" type="submit" name="" value="REGISTER">
            <br>
          </form>
        </div>
      </div>
  </div>
  </body>
</html>
