package com.sc.ddd.unusualSpends.service;

public interface Communicator {
    boolean communicate(String recipientContact, String subject, String message);
}
