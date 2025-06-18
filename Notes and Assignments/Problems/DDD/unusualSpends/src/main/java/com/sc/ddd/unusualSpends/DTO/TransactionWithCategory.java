package com.sc.ddd.unusualSpends.DTO;

import com.sc.ddd.unusualSpends.domain.entity.Transaction;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;

public class TransactionWithCategory {
    private final Transaction transaction;
    private final SpendingCategory spendingCategory;

    public TransactionWithCategory(Transaction transaction, SpendingCategory spendingCategory) {
        this.transaction = transaction;
        this.spendingCategory = spendingCategory;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public SpendingCategory getSpendingCategory() {
        return spendingCategory;
    }
}
