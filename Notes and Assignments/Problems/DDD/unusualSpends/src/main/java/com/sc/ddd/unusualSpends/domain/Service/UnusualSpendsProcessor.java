package com.sc.ddd.unusualSpends.domain.Service;

import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;

public class UnusualSpendsProcessor {
    private boolean getUnusualSpending(double lastMonthSpendingAmount, SpendingCategory lastMonthSpendingCategory, double currentMonthSpendingAmount, SpendingCategory currentMonthSpendingCategory){
        if (currentMonthSpendingAmount > lastMonthSpendingAmount)
            return true;
        else
            return false;
    }
}
