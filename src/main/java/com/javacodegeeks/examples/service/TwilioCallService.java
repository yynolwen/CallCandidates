package com.javacodegeeks.examples.service;

import com.javacodegeeks.examples.object.Candidate;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;
import com.twilio.sdk.resource.instance.Transcription;
import com.twilio.sdk.resource.list.TranscriptionList;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YongYanOspiea on 02/09/2016.
 */
@Service
public class TwilioCallService {

    /* Twilio REST API version */
    public static final String APIVERSION = "2010-04-01";
    private String AccountSid = "AC932b5204845dcdf377b37839af8b2d75";
    private String AuthToken = "a353247bc35c4cf2cd87e96b672ffe2a";
    // Outgoing Caller ID previously validated with Twilio
    private String CallerID = "+33975182833";
    private String Url1 = "http://ospieafrpf.cluster006.ovh.net/twilio/record1.xml";
    private String Url2 = "http://twimlets.com/message?Message%5B0%5D=Hello%2C%20"+"YongYan"+"&Message%5B1%5D=http%3A%2F%2Fospieafrpf.cluster006.ovh.net%2Ftwilio%2Frecord1.xml&";

    TwilioRestClient client = new TwilioRestClient(AccountSid, AuthToken, null);

    public void call(Candidate candidate) {

        Map params = new HashMap();
        params.put("From", CallerID);
        params.put("To", candidate.getPhone());
        params.put("IfMachine","Continue");


        PrintWriter writer = null;
        try {
            writer = new PrintWriter("try.xml", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println("<?xml version='1.0' encoding='UTF-8'?>");
        writer.println("<Response>");
        writer.println("<Say voice='alice' language='fr-FR'>Bonjour," + candidate.getPrenom() /*+ " " + candidate.getPrenom() */+ ", votre profil " + candidate.getSpecialiste() + " nous a tiré notre attention. </Say> ~");
//        writer.println("Veuillez laisser vortre message après un beep. Appuyer sur le bouton étoile quand vous avez fini.</Say>");
//        writer.println("<Record action='http://ospieafrpf.cluster006.ovh.net/twilio/wtRecord.php' maxLength='8' transcribe='true' transcribeCallback='http://ospieafrpf.cluster006.ovh.net/twilio/callback.php'/>");
        writer.println("<Gather numDigits='1' action='http://ospieafrpf.cluster006.ovh.net/twilio/dialOspiea.php' method='POST'> " +
                        "<Say voice='alice' language='fr-FR'>" +
                        "Nous somme la société Ospiea, si vous voulez nous discuter, appuyer sur 1." +
                        "</Say>" +
                        "</Gather>");
        writer.println("<Say voice='alice' language='fr-FR'>Merci," + candidate.getNom() + " " + candidate.getPrenom() + ", Au revoir !</Say>");
        writer.println("</Response>");
        writer.close();


        FTPClient ftpClient = new FTPClient();
        FileInputStream fis = null;

        try {
            ftpClient.connect("ftp.cluster006.hosting.ovh.net");
                ftpClient.login("ospieafrpf", "JjGh5HdHHqB9");

            boolean success = ftpClient.changeWorkingDirectory("/www/twilio");
            //
            // Create an InputStream of the file to be uploaded
            //
            String filename = "try.xml";
            fis = new FileInputStream(filename);

            //
            // Store file to server
            //
            ftpClient.storeFile(filename, fis);
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




        String Url = "http://ospieafrpf.cluster006.ovh.net/twilio/answeredBy.php?name="+candidate.getPrenom()+"&specialiste="+candidate.getSpecialiste();

        params.put("Url", Url);

        TwilioRestResponse response;


        try {
            response = client.request("/" + APIVERSION + "/Accounts/" + client.getAccountSid() + "/Calls", "POST", params);
            if (response.isError())
                System.out.println("Error making outgoing call: " + response.getHttpStatus() + "n" + response.getResponseText());
            else {
                System.out.println(response.getResponseText());
            }
        } catch (TwilioRestException e) {
            e.printStackTrace();
        }

/*
        RecordingList recordings = client.getAccount().getRecordings();

        // Loop over recordings and print out a property for each one.
        for (Recording recording : recordings) {
            System.out.println(recording.getDuration());
        }
*/
        TranscriptionList transcriptions = client.getAccount().getTranscriptions();
        int i = 0;
        // Loop over transcriptions and print out a property for each one.
        for (Transcription transcription : transcriptions) {
            i++;
            System.out.println(transcription.getTranscriptionText());
        }
        System.out.println(i);
    }


    public void playback(){

        System.out.println("call back successed");
        System.out.println("call back successed");
        System.out.println("call back successed");
        System.out.println("call back successed");
        System.out.println("call back successed");


    }



}
