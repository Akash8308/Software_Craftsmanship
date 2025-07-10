package com.sc.ddd.unusualSpends.domain.Service;

import com.sc.ddd.unusualSpends.DTO.SpendingByCategoryAndAmount;
import com.sc.ddd.unusualSpends.DTO.UnusualSpend;
import com.sc.ddd.unusualSpends.config.UnusualSpendsConfig;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnusualSpendsProcessorTest {
    private final UnusualSpendsProcessor testSubject = new UnusualSpendsProcessor();

    private static List<SpendingByCategoryAndAmount> getSpendingByCategory(SpendingCategory category, Double amount) {
        return List.of(
                new SpendingByCategoryAndAmount(category, amount)
        );
    }

    @Test
    void shouldBeAbleToGetUnusualSpendsWhenExceedThreshold() {
        var lastMonthSpendingByCategoryAndAmountList = getSpendingByCategory(SpendingCategory.TRAVEL, 100.0);
        var currentMonthSpendingByCategoryAndAmountList = getSpendingByCategory(SpendingCategory.TRAVEL, 3000.0);
        var unusualSpendsConfig = new UnusualSpendsConfig(50.0);
        var expectedUnusualSpend1 = new UnusualSpend(SpendingCategory.TRAVEL, 3000.0);
        var expected = List.of(expectedUnusualSpend1);

        // Act
        var actual = testSubject.getUnusualSpending(
                lastMonthSpendingByCategoryAndAmountList,
                currentMonthSpendingByCategoryAndAmountList,
                unusualSpendsConfig
        );

        // Assert
        assertTrue(expected.containsAll(actual));
    }

    @Test
    void shouldBeAbleToReturnEmptyUnusualSpendsIfNotExceededThreshold() {
        // Arrange
        var lastMonthSpendingByCategoryAndAmountList = getSpendingByCategory(SpendingCategory.FOOD, 200.0);
        var currentMonthSpendingByCategoryAndAmountList = getSpendingByCategory(SpendingCategory.FOOD, 250.0);
        var unusualSpendsConfig = new UnusualSpendsConfig(50.0);

        // Act
        var actual = testSubject.getUnusualSpending(
                lastMonthSpendingByCategoryAndAmountList,
                currentMonthSpendingByCategoryAndAmountList,
                unusualSpendsConfig
        );

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    void shouldBeAbleToReturnUnusualSpendsIfMetThreshold() {
        // Arrange
        var lastMonthSpendingByCategoryAndAmountList = getSpendingByCategory(SpendingCategory.FOOD, 100.0);
        var currentMonthSpendingByCategoryAndAmountList = getSpendingByCategory(SpendingCategory.FOOD, 150.0);
        var unusualSpendsConfig = new UnusualSpendsConfig(50.0);
        var expected = List.of(
                new UnusualSpend(SpendingCategory.FOOD, 150.0)
        );

        // Act
        var actual = testSubject.getUnusualSpending(
                lastMonthSpendingByCategoryAndAmountList,
                currentMonthSpendingByCategoryAndAmountList,
                unusualSpendsConfig
        );

        // Assert
        assertTrue(actual.containsAll(expected));
    }


}