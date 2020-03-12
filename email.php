<?php

$name = "Mosse";
$email = "mokikata@gmail.com";
$msg = "Test Mail";
$to = "cephasmarquis2000@gmail.com";
$subject = "Enquiry";
$header = "From:".$email;
$dne = mail($to, $subject, $message, $header);
if ($dne) {
  echo "done";
}
