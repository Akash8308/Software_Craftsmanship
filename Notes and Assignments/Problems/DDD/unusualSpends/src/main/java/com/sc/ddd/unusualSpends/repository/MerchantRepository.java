package com.sc.ddd.unusualSpends.repository;

import com.sc.ddd.unusualSpends.database.MerchantDB;
import com.sc.ddd.unusualSpends.domain.entity.Merchant;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;
import com.sc.ddd.unusualSpends.exception.MerchantNotFound;

import java.util.List;

public class MerchantRepository {

    private final MerchantDB merchantDB;

    public MerchantRepository(MerchantDB merchantDB) {
        this.merchantDB = merchantDB;
    }

    public List<Merchant> getAllMerchants(){
        return this.merchantDB.getMerchants();
    }

    public void addMerchant(Merchant merchant){
        this.merchantDB.addMerchant(merchant);
    }

    public Merchant getMerchanById(String merchantId){
        Merchant merchant = this.merchantDB.getMerchantById(merchantId);
        if(merchant != null)
            throw new MerchantNotFound(merchantId);
        else
            return merchant;
    }

    public SpendingCategory getMerchantCategoryByID(String merchantId){
        return this.merchantDB.getMerchantSpendingCategoryById(merchantId);
    }
}
