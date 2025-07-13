package com.sc.ddd.unusualSpends.repository;

import com.sc.ddd.unusualSpends.database.MerchantDB;
import com.sc.ddd.unusualSpends.domain.entity.Merchant;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MerchantRepositoryTest {
    @Test
    void shouldAddMerchant(){
        var merchDB = new MerchantDB();
        MerchantRepository merchRepo = new MerchantRepository(merchDB);
        Merchant merchant1 = new Merchant("M01", "Akash", SpendingCategory.FOOD);
        Merchant merchant2 = new Merchant("M02", "Vidhi", SpendingCategory.FOOD);
        merchRepo.addMerchant(merchant1);
        merchRepo.addMerchant(merchant2);

        var allMerchant = merchRepo.getAllMerchants();


    }

}