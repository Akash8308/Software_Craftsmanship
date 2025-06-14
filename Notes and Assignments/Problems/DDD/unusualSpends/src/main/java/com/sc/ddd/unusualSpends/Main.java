package com.sc.ddd.unusualSpends;

import com.sc.ddd.unusualSpends.domain.entity.CreditCard;
import com.sc.ddd.unusualSpends.domain.entity.User;

import java.util.Collections;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CreditCard cd = new CreditCard("101", "123456789012");
        User user = new User("101", "Akash", "Akashhedau65@gmail.com", "8308985621", Collections.singletonList("123456789012"));

    }
}