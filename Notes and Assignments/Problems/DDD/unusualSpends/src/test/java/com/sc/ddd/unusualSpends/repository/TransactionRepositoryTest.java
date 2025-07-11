package com.sc.ddd.unusualSpends.repository;

import com.sc.ddd.unusualSpends.domain.entity.CreditCard;
import com.sc.ddd.unusualSpends.domain.entity.Merchant;
import com.sc.ddd.unusualSpends.domain.entity.Transaction;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRepositoryTest {

    @Test
    void shouldAddTransactionWithGivenValue(){

        var merchant = new Merchant("M01", "Akash", SpendingCategory.FOOD);
        var creditCard = new CreditCard("C01", "1234 5678 4682");
        var transaction = new Transaction("T01", 1000, merchant.getId(), creditCard.getNumber(), LocalDateTime.now());
        var transactionId = transaction.getId();
        var transactionAmount = transaction.getAmount();
        var transactionMerchantId = transaction.getMerchantId();
        var transactionCreditCardId = transaction.getCreditCardId();

        assertEquals("T01", transactionId);
        assertEquals(1000, transactionAmount);
        assertEquals("M01", transactionMerchantId);
        assertEquals("1234 5678 4682", transactionCreditCardId);

    }

}