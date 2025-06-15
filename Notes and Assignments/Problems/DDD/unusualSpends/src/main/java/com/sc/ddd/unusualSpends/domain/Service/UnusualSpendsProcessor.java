package com.sc.ddd.unusualSpends.domain.Service;

import com.sc.ddd.unusualSpends.DTO.SpendingByCategoryAndAmount;
import com.sc.ddd.unusualSpends.DTO.UnusualSpend;
import com.sc.ddd.unusualSpends.config.UnusualSpendsConfig;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;

import java.util.ArrayList;
import java.util.List;

public class UnusualSpendsProcessor {

    public List<UnusualSpend> getUnusualSpending(
            List<SpendingByCategoryAndAmount> lastMonthSpendingByCategoryAndAmounts,
            List<SpendingByCategoryAndAmount> currentMonthSpendingByCategoryAndAmount,
            UnusualSpendsConfig unusualSpendsConfig
    ) {

        List<UnusualSpend> unusualSpends = new ArrayList<>();

        for (SpendingByCategoryAndAmount currentMonthSpending: currentMonthSpendingByCategoryAndAmount) {

            for (SpendingByCategoryAndAmount lastMonthSpending: lastMonthSpendingByCategoryAndAmounts) {

                if (currentMonthSpending.getCategory() == lastMonthSpending.getCategory()) {

                    var percentage = getPercentage(
                            currentMonthSpending.getAmount(),
                            lastMonthSpending.getAmount()
                    );

                    if (percentage >= unusualSpendsConfig.getPercentage()) {
                        UnusualSpend unusualSpend = new UnusualSpend(currentMonthSpending.getCategory(), currentMonthSpending.getAmount());
                        unusualSpends.add(unusualSpend);
                    }
                }
            }
        }

        int i = 0;
        for(SpendingCategory sc : SpendingCategory.values() )
        {
            lastMonthSpendingByCategoryAndAmounts.indexOf(sc);
        }

        return unusualSpends;
    }

    private static double getPercentage(Double currentMonthSpendingAmount, Double lastMonthSpendingAmount) {
        return (currentMonthSpendingAmount - lastMonthSpendingAmount) * 100 / lastMonthSpendingAmount;
    }
}
