package com.sc.ddd.unusualSpends.exception;

public class MerchantNotFound extends RuntimeException {
    public MerchantNotFound(String merchantId) {
        super("Merchant not found for ID: " + merchantId);
    }
}
