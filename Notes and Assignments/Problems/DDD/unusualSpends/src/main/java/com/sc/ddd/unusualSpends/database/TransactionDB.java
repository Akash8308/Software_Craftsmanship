package com.sc.ddd.unusualSpends.database;

import com.sc.ddd.unusualSpends.domain.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionDB {

    private final List<Transaction> transactions;


    public TransactionDB(List<Transaction> transactions) {
        this.transactions = new ArrayList<>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }
}
