package com.sc.ddd.unusualSpends.exception;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String id) {

//        super("Invalid id: " + (id.isBlank() ? "Blank" : id));

        super("Invalid id: " + (id == null ? "null" : "Blank"));
    }
}
