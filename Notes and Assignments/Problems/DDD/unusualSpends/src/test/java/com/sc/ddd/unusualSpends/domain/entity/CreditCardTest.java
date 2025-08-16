package com.sc.ddd.unusualSpends.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    @Test
    void shouldCreateObjectWithGivenValues(){
        var userId = "101";
        var creaditcardID = "1234 5678 1234";

        var creaditCard = new CreditCard(userId, creaditcardID);

        assertEquals(userId, creaditCard.getUserId());
        assertEquals(creaditcardID, creaditCard.getNumber());
    }

    @Test
    void shouldCreateObjectWithEmptyTransactionList(){
        var userId = "101";
        var creaditcardID = "1234 5678 1234";

        var creaditCard = new CreditCard(userId, creaditcardID);

        var transactions = creaditCard.getTransactionIds();
        assertTrue(transactions.isEmpty());
    }

}