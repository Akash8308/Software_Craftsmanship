package com.sc.ddd.unusualSpends.domain.entity;

import com.sc.ddd.unusualSpends.exception.*;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

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
        if(!isValidEmail(email))
            throw new InvalidEmailException(email);
        if(!isValidMobile(mobile))
            throw new InvalidMobileException(mobile);
        if(card == null || card.get(0).isBlank())
            throw new InvalidCreditCardNumberException(card.get(0));

        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.card = card;
    }

    public boolean isValidEmail(String email) {
        String EMAIL_REGEX =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

        Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        if (email == null || email.isBlank()) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidMobile(String mobile) {
        String MOBILE_REGEX = "^[6-9]\\d{9}$";
        Pattern MOBILE_PATTERN = Pattern.compile(MOBILE_REGEX);

        if (mobile == null || mobile.isBlank()) return false;
        return MOBILE_PATTERN.matcher(mobile).matches();
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

    public void spend(double amount, Merchant merch, User user){
        Transaction tran1 = new Transaction("T101", amount, merch.id, user.getCard());
    }
}
