package com.sc.ddd.unusualSpends.exception;

import java.time.LocalDate;

public class InvalidTimestampException extends RuntimeException {
    public InvalidTimestampException(LocalDate timestamp) {
        super("Invalid TimeStamp: " + timestamp);
    }
}
