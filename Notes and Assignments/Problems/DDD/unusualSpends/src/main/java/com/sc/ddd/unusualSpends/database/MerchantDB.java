package com.sc.ddd.unusualSpends.database;

import com.sc.ddd.unusualSpends.domain.entity.Merchant;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MerchantDB {
    private final List<Merchant> merchants;

    public MerchantDB() {
        this.merchants = new ArrayList<>();
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public void addMerchant( Merchant merchant){
        this.merchants.add(merchant);
    }

    public Merchant getMerchantById(String merchantID){
        return this.merchants
                .stream()
                .filter(merchant -> Objects.equals(merchantID, merchant.getId()))
                .findFirst().get();
    }

    public SpendingCategory getMerchantSpendingCategoryById(String merchantId){
        Merchant merchant = getMerchantById(merchantId);
        return merchant.getCategory();
    }
}
