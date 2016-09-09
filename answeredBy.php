<?php
header('Content-type: text/xml');
echo '<?xml version="1.0" encoding="UTF-8"?>'; echo '';

switch($_POST['AnsweredBy']){
    case 'machine':
        echo "<Response><Say voice='alice' language='fr-FR'>Bonjour" . $_GET[name] . ", Nous somme de la société Ospiea, votre profil ". $_POST[specialiste] ." nous a tiré notre attention. Si vous voulez discuter avec nous, merci de rapeller au 06 59 16 97 13, merci, au revoir !</Say></Response>";
        break;
    case 'human':
        echo "<Response><Say voice='alice' language='fr-FR'>Bonjour " . $_GET[name] . ", Nous somme de la société Ospiea, votre profil ". $_POST[specialiste] ."nous a tiré notre attention. </Say> <Gather numDigits='1' action='http://ospieafrpf.cluster006.ovh.net/twilio/dialOspiea.php' method='POST'>
                        <Say voice='alice' language='fr-FR'>
                        Si vous voulez nous discuter, appuyer sur 1.
                        </Say>
                        </Gather></Response>";
        break;
}

echo '';

?>