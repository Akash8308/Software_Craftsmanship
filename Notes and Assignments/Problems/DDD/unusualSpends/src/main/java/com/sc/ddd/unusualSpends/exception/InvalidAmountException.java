package com.sc.ddd.unusualSpends.exception;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(double amount) {

        super("Invalid Amount: " + amount);
    }
}
