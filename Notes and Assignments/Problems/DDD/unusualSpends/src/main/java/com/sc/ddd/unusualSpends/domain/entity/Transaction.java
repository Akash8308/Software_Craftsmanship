package com.sc.ddd.unusualSpends.domain.entity;
import com.sc.ddd.unusualSpends.exception.*;

import java.time.LocalDate;

public class Transaction {

    private final String id;
    private final double amount;
    private final String merchantId;
    private final String creditCardId;
    private final LocalDate  timestamp;

    public Transaction(String id, double amount, String merchantId, String creditCardId) {

        if(id == null || id.isBlank())
            throw new InvalidIdException(id);
        if( amount <= 0 )
            throw new InvalidAmountException(amount);
        if(merchantId == null || merchantId.isBlank())
            throw new InvalidNameException(merchantId);
        if(creditCardId == null || creditCardId.isBlank())
            throw new InvalidCreditCardNumberException(creditCardId);

        this.id = id;
        this.amount = amount;
        this.merchantId = merchantId;
        this.creditCardId = creditCardId;
        this.timestamp = LocalDate.now();
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

    public String getMonth() {
        return timestamp.getMonth().toString();
    }
}
