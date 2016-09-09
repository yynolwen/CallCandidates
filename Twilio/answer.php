<?php

header('Content-type: text/xml');

echo '<!--?xml version="1.0" encoding="UTF-8"?-->'; echo '';

switch($_POST['AnsweredBy']){
    case 'machine':
        echo "We're sorry you're not there. We will leave a message.";
        break;
    case 'human':
        echo "So nice to talk to a real human!";
        break;
}

echo '';

?>