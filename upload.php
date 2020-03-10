<?php
if (isset($_GET['msg'])) {
  $mssg = $_GET['msg'];
}


 ?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="st2.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>UPLOAD</title>
  </head>
  <?php include 'header.php'; ?>
  <body class="wr">
    <div class="msgs"id="msgs">
      <span id="spn">
      </span>
    </div>
    <form action="includes/upload.inc.php" method="post" enctype="multipart/form-data" class="lost_form">
      <input type="text" name="name" placeholder="Name of Owner" >
      <br>
      <input type="text" name="inst" placeholder="Institution" >
      <br>
      <input type="text" name="regno" placeholder="Registration Number" >
      <br>

    Select image to upload:
    <input type="file" name="fileToUpload" id="fileToUpload">
    <br>
    <input type="submit" value="Upload Image" name="submit">
</form>

<script type="text/javascript">
var msgs = document.getElementById('spn');
var ms = document.getElementById('msgs');

  function disp(){
    msgs.style.visibility="visible";
    msgs.innerHTML= <?php echo $mssg; ?>;
  }

window.setTimeout(disp, 3000);

</script>
  </body>

</html>
