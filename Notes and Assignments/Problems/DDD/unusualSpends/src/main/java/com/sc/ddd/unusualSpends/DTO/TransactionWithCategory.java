package com.sc.ddd.unusualSpends.DTO;

import com.sc.ddd.unusualSpends.domain.entity.Transaction;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TransactionWithCategory that = (TransactionWithCategory) o;
        return Objects.equals(transaction, that.transaction) && spendingCategory == that.spendingCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction, spendingCategory);
    }
}
