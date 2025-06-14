package com.sc.ddd.unusualSpends.domain.entity;
import com.sc.ddd.unusualSpends.exception.*;

import java.time.LocalDate;

public class Transaction {

    private final String id;
    private final double amount;
    private final String merchantId;
    private final String creditCardId;
    private final LocalDate  timestamp;

    public Transaction(String id, double amount, String merchantId, String creditCardId, LocalDate  timestamp) {

        if(id == null || id.isBlank())
            throw new InvalidIdException(id);
        if(merchantId == null || merchantId.isBlank())
            throw new InvalidNameException(merchantId);
        if(timestamp == null)
            throw new InvalidTimestampException(timestamp);
        if(creditCardId == null || creditCardId.isBlank())
            throw new InvalidCreditCardNumberException(creditCardId);

        this.id = id;
        this.amount = amount;
        this.merchantId = merchantId;
        this.creditCardId = creditCardId;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public double getAmount() {
        return amount;
    }

    public String getCreditCardId() {
        return creditCardId;
    }
}
