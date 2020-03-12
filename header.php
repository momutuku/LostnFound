 <!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="icon" href="images/logo.jpeg" type="image/jpeg">
    <link rel="stylesheet" href="style.css">

  </head>
  <body>
    <header class="header">
      <div class="logo">
        <img src="images/logo.jpeg" alt="Logo">
      </div>

       <ul  class="show_menu" id="show">
          <li class="dot"></li>
          <li class="dot"></li>
          <li class="dot"></li>

      </ul>

      <ul class="header_links" id="header_links">

        <li><a href="index.php">Home</a></li>
        <li><a href="">Lost ID</a></li>
        <li><a href="">Found ID</a></li>
        <li><a href="login.php" id="logger">Login</a></li>
        <li id="logout"><a href="includes/login.inc.php" >Log Out</a></li>
        <li class="profile_img">
          <a href="#">
            <img src=" <?php echo $_SESSION['prof']; ?>" alt="">
          </a>
        </li>


      </ul>
    </header>

    <?php

    if (isset($_SESSION['user'])):?>
    <script type="text/javascript">

    var logger = document.getElementById('logger');
    var logger1 = document.getElementById('logout');
    logger.style.display="none";
    logger1.style.display="block";


    </script>
    <?php endif; ?>




    <script type="text/javascript">
    var show = document.getElementById('show');
    var links = document.getElementById('header_links');
    var stat = 0;

    show.addEventListener('click', function(){
      if (stat==0) {
        links.style.display="flex";
        stat = stat+1;
      }
      else{
        links.style.display="none";
        stat = stat-1;
      }
    });




    </script>
  </body>
</html>
