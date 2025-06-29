package com.sc.ddd.unusualSpends.domain.entity;

import com.sc.ddd.unusualSpends.exception.InvalidCreditCardNumberException;
import com.sc.ddd.unusualSpends.exception.InvalidIdException;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private final String number;
    private final String userId;
    private final List<String> transactionIds;

    public CreditCard(String userId, String number) {
        if(userId == null || userId.isBlank())
            throw new InvalidCreditCardNumberException(number);
        if(number == null || number.isBlank())
            throw new InvalidIdException(userId);

        this.userId = userId;
        this.number = number;
        transactionIds = new ArrayList<>();
    }

    public String getNumber() {
        return number;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getTransactionIds() {
        return transactionIds;
    }

    public void addTransaction(String transactionId){
        transactionIds.add(transactionId);
    }
}
