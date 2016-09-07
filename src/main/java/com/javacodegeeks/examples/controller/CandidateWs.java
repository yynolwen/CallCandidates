package com.javacodegeeks.examples.controller;

import org.springframework.web.bind.annotation.RestController;
/**
 * Created by YongYanOspiea on 31/08/2016.
 */
@RestController
public class CandidateWs {
/*
    public static void main(String[] args) {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //CandidateDao dao = (CandidateDao) ctx.getBean("candidateDao");
        //int status = dao.saveCandidate(can);
        //System.out.println("abcd");
        //Candidate candidate = new Candidate(104, "Amit", "Smith", 788212380, "AngularJS",0);
        //dao.saveCandidate(candidate);

        //System.out.println(dao.findAllCandidate());


    /*int status=dao.updateEmployee(new Employee(102,"Sonoo",15000));
    System.out.println(status);


    /*Employee e=new Employee();
    e.setId(102);
    int status=dao.deleteEmployee(e);
    System.out.println(status);

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("try.xml", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println("<Response>");
        writer.println("<Say voice='alice' language='fr-FR'>Bonjour, " + "Luffy," + " votre profil JAVA nous intéresse</Say>");
        writer.println("</Response>");
        writer.close();


        FTPClient client = new FTPClient();
        FileInputStream fis = null;

        try {
            client.connect("ftp.cluster006.hosting.ovh.net");
            client.login("ospieafrpf", "JjGh5HdHHqB9");

            boolean success = client.changeWorkingDirectory("/www/twilio");
            //
            // Create an InputStream of the file to be uploaded
            //
            String filename = "try.xml";
            fis = new FileInputStream(filename);

            //
            // Store file to server
            //
            client.storeFile(filename, fis);
            client.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }*/
}

