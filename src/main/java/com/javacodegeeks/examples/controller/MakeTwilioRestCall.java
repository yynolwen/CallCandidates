package com.javacodegeeks.examples.controller;

/**
 * Created by YongYanOspiea on 26/08/2016.
 */

public class MakeTwilioRestCall {
    /* Twilio REST API version */
    public static final String APIVERSION = "2010-04-01";
/*
    public static void main(String[] args){
// Twilio AccountSid and AuthToken
        String AccountSid = "AC932b5204845dcdf377b37839af8b2d75";
        String AuthToken = "a353247bc35c4cf2cd87e96b672ffe2a";
// Outgoing Caller ID previously validated with Twilio
        String CallerID = "+33975182833 ";
        String ToCall = "+33788212380";
        String Url="http://ospieafrpf.cluster006.ovh.net/twilio/record1.xml";
// Instantiate a new Twilio Rest Client
        TwilioRestClient client = new TwilioRestClient(AccountSid, AuthToken, null);
//build map of post parameters

        Map params = new HashMap();
        params.put("From", CallerID);
        params.put("To", ToCall);
        params.put("Url", Url);
        TwilioRestResponse response;


        try {
            response = client.request("/"+APIVERSION+"/Accounts/"+client.getAccountSid()+"/Calls", "POST", params);
            if(response.isError())
                System.out.println("Error making outgoing call: "+response.getHttpStatus()+"n"+response.getResponseText());
            else {
                System.out.println(response.getResponseText());
            }
        } catch (TwilioRestException e) {
            e.printStackTrace();
        }


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
        //System.out.println(i);
    }*/

}
