package com.sc.ddd.unusualSpends.exception;

public class InvalidCreditCardNumberException extends RuntimeException {
    public InvalidCreditCardNumberException(String number) {

        super("Invalid Credit Card number: " + number);
    }
}
