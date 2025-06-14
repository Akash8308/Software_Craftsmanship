package com.sc.ddd.unusualSpends.exception;

public class InvalidMobileException extends RuntimeException {
    public InvalidMobileException(String number) {
        super("Invalid mobile number : " + number);
    }
}
