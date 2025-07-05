package com.sc.ddd.unusualSpends.exception;

public class InvalidNameException extends RuntimeException {
    public InvalidNameException(String name) {
        super("Invalid name: " + (name.isBlank() ? "Blank" : name));
    }
}
