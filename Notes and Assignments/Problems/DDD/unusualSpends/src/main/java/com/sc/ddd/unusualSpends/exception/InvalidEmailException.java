package com.sc.ddd.unusualSpends.exception;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String email) {

        super("Invalid email Id: "  + email);

    }
}
