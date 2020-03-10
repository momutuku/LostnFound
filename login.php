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

    <video autoplay muted loop id="myVideo">
  <source src="images/v2.mp4" type="video/mp4">
</video>
<div class="body">

<div class="wr">
    <div class="wrapper">
      <div class="left_img">
          <img src="images/logo.jpeg" alt="">
      </div>
      <div class="right_form">
          <form class="login_form" action="includes/login.inc.php" method="post">
            <input type="email" name="email" placeholder="example@mail.com">
            <br>
            <input type="password" name="password" value="" placeholder="Password">
            <br>
            <input class="log_in" type="submit" name="" value="LOG-IN">
          </form>
      </div>
    </div>
  </div>

</div>
  </body>
</html>
