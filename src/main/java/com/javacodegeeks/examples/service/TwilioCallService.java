package com.javacodegeeks.examples.service;

import com.javacodegeeks.examples.object.Candidate;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;
import org.springframework.stereotype.Service;

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
    private String Url = "http://ospieafrpf.cluster006.ovh.net/twilio/record1.xml";

    TwilioRestClient client = new TwilioRestClient(AccountSid, AuthToken, null);

    public void call(Candidate candidate) {

        Map params = new HashMap();
        params.put("From", CallerID);
        params.put("To", candidate.getPhone());
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
            //System.out.println(recording.getDuration());
        }

        TranscriptionList transcriptions = client.getAccount().getTranscriptions();
        int i = 0;
        // Loop over transcriptions and print out a property for each one.
        for (Transcription transcription : transcriptions) {
            i++;
            System.out.println(transcription.getTranscriptionText());
        }
        //System.out.println(i);*/
    }
}
