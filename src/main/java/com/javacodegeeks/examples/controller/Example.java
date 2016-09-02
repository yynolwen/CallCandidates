package com.javacodegeeks.examples.controller;

/**
 * Created by YongYanOspiea on 26/08/2016.
 */

public class Example {

    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC932b5204845dcdf377b37839af8b2d75";
    public static final String AUTH_TOKEN = "a353247bc35c4cf2cd87e96b672ffe2a";
/*
    public static void main(String[] args) throws TwilioRestException {
            TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        // Build a filter for the MessageList
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Body", "Hello from Java"));
        params.add(new BasicNameValuePair("To", "0788212380"));
        params.add(new BasicNameValuePair("From", "975182833"));

        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        Message message = messageFactory.create(params);
        System.out.println(message.getSid());
    }*/
}
