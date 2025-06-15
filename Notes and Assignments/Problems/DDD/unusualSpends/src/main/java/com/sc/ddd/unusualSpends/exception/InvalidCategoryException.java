package com.sc.ddd.unusualSpends.exception;

public class InvalidCategoryException extends RuntimeException {
    public InvalidCategoryException(String category) {
        super("Invalid Spending Category: " + category);
    }
}
