<?php

    // tell the caller that they should listen to their howl
    // and play the recording back, using the URL that Twilio posted
    header("content-type: text/xml");
    echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
?>
<Response>
    <Say>Thanks for howling... take a listen to what you howled.</Say>
    <Say><?php echo $_REQUEST['TranscriptionText']; ?></Say>
    <Say>Goodbye.</Say>
</Response>
