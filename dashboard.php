<?php
    session_start();
if (!isset($_SESSION['user'])) {
    header("Location:login.php?status=Login");
}
$email = $_SESSION['user'];
$fname = $_SESSION['fname'];
$lname = $_SESSION['lname'];
 ?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>DASHBOARD</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="images/logo.jpeg" type="image/jpeg">
    <link rel="stylesheet" href="styledash.css">
  </head>
  <body>
  <?php //include 'header.php'; ?>

<div class="drawer">
  <div class="user_details">
    <div class="user_img">
        <img src=" <?php echo $_SESSION['prof']; ?> " alt="">
    </div>

<div class="user_name">
  <span><?php echo $fname;echo " ";echo $lname; ?></span>
  <br>
<p><?php echo $email; ?></p>
</div>

<label class="button">
      Update Profile
</label>
  </div>
  <div class="dash_navs_main">


  <div class="dash_navs">
    <a href="index.php">
    <div class="dash_link">
      <div class="imgdash">
      <img  src="images/home.png" alt="">
      </div>
      <div class="link_name">HOME</div>

    </div>
    </a>
  </div>
  <div class="dash_navs">
    <a href="#">
    <div class="dash_link">
      <div class="imgdash">
      <img  src="images/dash2.png" alt="">
      </div>
      <div class="link_name">DASHBOARD</div>

    </div>
    </a>
  </div>
  <div class="dash_navs">
    <a href="#">
    <div class="dash_link">
      <div class="imgdash">
      <img  src="images/envelope.png" alt="">
      </div>
      <div class="link_name">MESSAGE</div>

    </div>
    </a>
  </div>

  <div class="dash_navs">
    <a href="#">
    <div class="dash_link">
      <div class="imgdash">
      <img  src="images/news.png" alt="">
      </div>
      <div class="link_name">NEWS</div>

    </div>
    </a>
  </div>
</div>
</div>


<div class="wrapper">

<div class="strength">

  <div class="holder">
<h4>Completeness</h4>
<div class="holder_img">
  <img src="images/Donut1.png" alt="">

</div>

  </div>
  <div class="holder">
<h4>Completeness</h4>
<div class="holder_img">
  <img src="images/Donut1.png" alt="">

</div>

  </div>
  <div class="holder">
<h4>Completeness</h4>
<div class="holder_img">
  <img src="images/Donut1.png" alt="">

</div>

  </div>

</div>

<!-- Two -->

<div class="strength">

  <div class="holder">
<h4>Completeness</h4>
<div class="holder_img">
  <img src="images/Donut1.png" alt="">

</div>

  </div>
  <div class="holder">
<h4>Completeness</h4>
<div class="holder_img">
  <img src="images/Donut1.png" alt="">

</div>

  </div>
  <div class="holder">
<h4>Completeness</h4>
<div class="holder_img">
  <img src="images/Donut1.png" alt="">

</div>

  </div>

</div>

<!-- Three -->

<div class="strength">


</div>

































</div>
<script type="text/javascript">

var logger = document.getElementById('logger');
var logger1 = document.getElementById('logout');

logger.style.display="none";
logger1.style.display="block";

</script>
</body>
</html>
