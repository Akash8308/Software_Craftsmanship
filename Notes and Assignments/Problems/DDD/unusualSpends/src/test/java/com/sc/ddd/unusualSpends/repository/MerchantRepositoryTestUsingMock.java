package com.sc.ddd.unusualSpends.repository;

import com.sc.ddd.unusualSpends.database.MerchantDB;
import com.sc.ddd.unusualSpends.domain.entity.Merchant;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MerchantRepositoryTestUsingMock {

    @Mock
    private MerchantDB mockMerchantDB;

    @InjectMocks
    private MerchantRepository testSubject;

    @Test
    void shouldBeAbleToReturn0Merchant(){
        var actual = testSubject.getAllMerchants();

        assertTrue(actual.isEmpty());
    }

    @Test
    void shouldBeAbleToReturnAllMerchant(){
        List<Merchant> expected = List.of(
                new Merchant("1", "Mustafa", SpendingCategory.TRAVEL),
                new Merchant("2", "Akash", SpendingCategory.FOOD)
        );
    }

}