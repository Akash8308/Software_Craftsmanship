package com.sc.ddd.unusualSpends.domain.Service;

import com.sc.ddd.unusualSpends.DTO.SpendingByCategoryAndAmount;
import com.sc.ddd.unusualSpends.DTO.UnusualSpend;
import com.sc.ddd.unusualSpends.config.UnusualSpendsConfig;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UnusualSpendsProcessor {

    public List<UnusualSpend> getUnusualSpending(
            List<SpendingByCategoryAndAmount> lastMonthSpendingByCategoryAndAmounts,
            List<SpendingByCategoryAndAmount> currentMonthSpendingByCategoryAndAmount,
            UnusualSpendsConfig unusualSpendsConfig
    ) {

        List<UnusualSpend> unusualSpends = new ArrayList<>();

        for (SpendingCategory category : SpendingCategory.values()){
            var currentMonthSpendingOptional = getSpendingByCategory(category, currentMonthSpendingByCategoryAndAmount);
            var lastMonthSpendingOptional = getSpendingByCategory(category, lastMonthSpendingByCategoryAndAmounts);

            if( currentMonthSpendingOptional.isPresent() && lastMonthSpendingOptional.isPresent()){
                var currentMonthSpending = currentMonthSpendingOptional.get();
                var lastMonthSpending = lastMonthSpendingOptional.get();

                var percentage = getPercentage(
                        currentMonthSpending.getAmount(),
                        lastMonthSpending.getAmount()
                );

                if(percentage >= unusualSpendsConfig.getPercentage()){
                    var unUsualSpend = new UnusualSpend(currentMonthSpending.getCategory(), currentMonthSpending.getAmount());
                    unusualSpends.add(unUsualSpend);
                }
            }
        }

        return unusualSpends;
    }

    private Optional<SpendingByCategoryAndAmount> getSpendingByCategory(SpendingCategory category, List<SpendingByCategoryAndAmount> spendingByCategoryAndAmounts) {
        return spendingByCategoryAndAmounts
                .stream()
                .filter(spendingByCateoryAndMonth -> category == spendingByCateoryAndMonth.getCategory())
                .findFirst();
    }

    private static double getPercentage(Double currentMonthSpendingAmount, Double lastMonthSpendingAmount) {
        return (currentMonthSpendingAmount - lastMonthSpendingAmount) * 100 / lastMonthSpendingAmount;
    }
}
