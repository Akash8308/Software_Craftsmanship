package com.sc.ddd.unusualSpends.DTO;

import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;

import java.util.Objects;

public class UnusualSpend {
    private final SpendingCategory category;
    private final Double amount;

    public UnusualSpend(SpendingCategory category, Double amount) {
        this.category = category;
        this.amount = amount;
    }

    public SpendingCategory getCategory() {
            return category;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UnusualSpend that = (UnusualSpend) o;
        return category == that.category && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, amount);
    }
}
