  <?php
require 'vendor/autoload.php';
use AfricasTalking\SDK\AfricasTalking;

// Set your app credentials
$username   = "founditlost";
$apiKey     = "fd6ab3dc269638f39d3684440a9e8c7dc4ac5a599de52b69e996280b58a76df0";

// Initialize the SDK
$AT         = new AfricasTalking($username, $apiKey);

// Get the SMS service
$sms        = $AT->sms();

// Set the numbers you want to send to in international format
$recipients = "+254721360823";

// Set your message
$message    = uniqid();

// Set your shortCode or senderId
$from       = "";

try {
    // Thats it, hit send and we'll take care of the rest
    $result = $sms->send([
        'to'      => $recipients,
        'message' => $message,
        'from'    => $from
    ]);

    print_r($result);
} catch (Exception $e) {
    echo "Error: ".$e->getMessage();
    echo "string";
}
