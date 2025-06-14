package com.sc.ddd.unusualSpends.domain.entity;

import com.sc.ddd.unusualSpends.exception.*;

import java.time.LocalDate;
import java.util.List;

public class User {
    private final String id;
    private final String name;
    private final String email;
    private final String mobile;
    private final List<String> card;

    public User(String id, String name, String email, String mobile, List<String> card) {

        if(id == null || id.isBlank())
            throw new InvalidIdException(id);
        if(name == null || name.isBlank())
            throw new InvalidNameException(name);
        if(email == null || email.isBlank())
            throw new InvalidEmailException(email);
        if(mobile == null || mobile.isBlank())
            throw new InvalidMobileException(mobile);
        if(card == null || card.get(0).isBlank())
            throw new InvalidCreditCardNumberException(card.get(0));

        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.card = card;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public List<String> getCard() {
        return card;
    }

    public void spend(double amount){
//        Transaction(String id, double amount, String merchantId, String creditCardId, LocalDate timestamp)
        
    }
}
