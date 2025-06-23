package com.sc.ddd.unusualSpends.service.Impl;

import com.sc.ddd.unusualSpends.service.Communicator;

public class EmailCommunicator implements Communicator {
    @Override
    public boolean communicate(String recipientContact, String subject, String message) {
        try {
            System.out.println("\nTo: " + recipientContact);
            System.out.println("\nSubject: " + subject);
            System.out.println("\nMessage: \n");
            System.out.println(message + "\n");
            System.out.println("Sent\n");
            return true;
        } catch (Exception ex) {
            System.out.println("Exception caught: " +  ex.getMessage());
            ex.fillInStackTrace();
            return false;
        }
    }
}
