package com.sc.ddd.unusualSpends.database;

import com.sc.ddd.unusualSpends.domain.entity.Merchant;

import java.util.ArrayList;
import java.util.List;

public class MerchantDB {
    private final List<Merchant> merchants;

    public MerchantDB(List<Merchant> merchants) {
        this.merchants = new ArrayList<>();
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public void addMerchant( Merchant merchant){
        this.merchants.add(merchant);
    }
}
