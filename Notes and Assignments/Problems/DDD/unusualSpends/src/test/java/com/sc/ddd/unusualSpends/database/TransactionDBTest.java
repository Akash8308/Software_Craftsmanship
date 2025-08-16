package com.sc.ddd.unusualSpends.database;

import com.sc.ddd.unusualSpends.domain.entity.CreditCard;
import com.sc.ddd.unusualSpends.domain.entity.Transaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionDBTest {

    @Test
    void shouldCreateEmptyTransactionDB(){
        TransactionDB transDb = new TransactionDB();

        var transactions = transDb.getTransactions();

        assertTrue(transactions.isEmpty());
    }

    @Test
    void shouldReturnAllTransactionDB(){
        TransactionDB transDb = new TransactionDB();

        Transaction t1 = new Transaction("T01", 100, "M01", "C01", LocalDateTime.now());
        Transaction t2 = new Transaction("T02", 200, "M01", "C01", LocalDateTime.now());
        Transaction t3 = new Transaction("T03", 300, "M01", "C01", LocalDateTime.now());

        var expectedTransactions = List.of(t1,t2,t3);
        transDb.addTransaction(t1);
        transDb.addTransaction(t2);
        transDb.addTransaction(t3);

        var transactions = transDb.getTransactions();

        assertTrue(transactions.containsAll(expectedTransactions));
    }


}