package com.sc.ddd.unusualSpends.database;

import com.sc.ddd.unusualSpends.domain.entity.Merchant;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;
import com.sc.ddd.unusualSpends.repository.MerchantRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MerchantDBTest {

    @Test
    void shouldCreateEmptyDB(){
        var merchDB = new MerchantDB();

        assertTrue(merchDB.getMerchants().isEmpty());
    }

    @Test
    void shouldAddMerchant(){
        var merchDB = new MerchantDB();
        Merchant merchant1 = new Merchant("M01", "Akash", SpendingCategory.FOOD);
        Merchant merchant2 = new Merchant("M02", "Vidhi", SpendingCategory.FOOD);
        merchDB.addMerchant(merchant1);
        merchDB.addMerchant(merchant2);

        var allMerchant = merchDB.getMerchants();

        assertFalse(allMerchant.isEmpty());

    }

    @Test
    void shouldAddAllMerchants(){
        var merchDB = new MerchantDB();
        Merchant merchant1 = new Merchant("M01", "Akash", SpendingCategory.FOOD);
        Merchant merchant2 = new Merchant("M02", "Vidhi", SpendingCategory.FOOD);
        merchDB.addMerchant(merchant1);
        merchDB.addMerchant(merchant2);

        var allMerchant = merchDB.getMerchants();

        assertFalse(allMerchant.isEmpty());
        assertTrue(allMerchant.size() == 2);

    }

    @Test
    void shouldFindAndReturnMerchantById(){
        var merchDB = new MerchantDB();
        Merchant merchant1 = new Merchant("M01", "Akash", SpendingCategory.FOOD);
        Merchant merchant2 = new Merchant("M02", "Vidhi", SpendingCategory.FOOD);
        merchDB.addMerchant(merchant1);
        merchDB.addMerchant(merchant2);

        var expectedMerchant1 = merchDB.getMerchantById("M01");
        var expectedMerchant2 = merchDB.getMerchantById("M02");

        assertEquals(merchant1, expectedMerchant1);
        assertEquals(merchant2, expectedMerchant2);

    }

    @Test
    void getMerchantSpendingCategoryById(){
        var merchDB = new MerchantDB();
        Merchant merchant1 = new Merchant("M01", "Akash", SpendingCategory.FOOD);
        Merchant merchant2 = new Merchant("M02", "Vidhi", SpendingCategory.TRAVEL);
        merchDB.addMerchant(merchant1);
        merchDB.addMerchant(merchant2);

        var merch1SpendingCategory = merchDB.getMerchantSpendingCategoryById("M01");
        var merch2SpendingCategory = merchDB.getMerchantSpendingCategoryById("M02");

        assertEquals(merch1SpendingCategory, SpendingCategory.FOOD);
        assertEquals(merch2SpendingCategory, SpendingCategory.TRAVEL);
    }
}