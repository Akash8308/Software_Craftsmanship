package com.sc.ddd.unusualSpends.repository;

import com.sc.ddd.unusualSpends.database.TransactionDB;
import com.sc.ddd.unusualSpends.domain.entity.Transaction;

import java.util.List;

public class TransactionRepository {
    private final TransactionDB transactionDB;

    public TransactionRepository(TransactionDB transactionDB) {
        this.transactionDB = transactionDB;
    }

    public void addTransaction(Transaction transaction) {
        this.transactionDB.addTransaction(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return this.transactionDB.getTransactions();
    }
}
