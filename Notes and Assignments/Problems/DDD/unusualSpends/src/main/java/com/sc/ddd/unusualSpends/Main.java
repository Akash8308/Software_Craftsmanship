package com.sc.ddd.unusualSpends;

import com.sc.ddd.unusualSpends.DTO.TransactionWithCategory;
import com.sc.ddd.unusualSpends.database.MerchantDB;
import com.sc.ddd.unusualSpends.database.TransactionDB;
import com.sc.ddd.unusualSpends.domain.Service.UnusualSpendsProcessor;
import com.sc.ddd.unusualSpends.domain.entity.CreditCard;
import com.sc.ddd.unusualSpends.domain.entity.Merchant;
import com.sc.ddd.unusualSpends.domain.entity.Transaction;
import com.sc.ddd.unusualSpends.domain.entity.User;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;
import com.sc.ddd.unusualSpends.repository.MerchantRepository;
import com.sc.ddd.unusualSpends.repository.TransactionRepository;
import com.sc.ddd.unusualSpends.service.TransactionService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

                // System.out.println("Welcome to Unusual Spending Detection System");

                CreditCard cd1 = new CreditCard("101", "1234 5678 9012");
                CreditCard cd2 = new CreditCard("101", "1234 5678 9013");

                User user = new User("101", "Akash", "akashhedau65@gmail.com", "8308985621",
                                Collections.singletonList("1234 5678 9012"));

                Merchant m1 = new Merchant("M1111", "VRL Travels", SpendingCategory.TRAVEL);
                Merchant m2 = new Merchant("M2222", "Aroma", SpendingCategory.FOOD);
                Merchant m3 = new Merchant("M2222", "HP Petroleum", SpendingCategory.FUEL);
                List<Merchant> listOfMerchants = List.of(m1, m2, m3);
                MerchantDB merchDb = new MerchantDB(listOfMerchants);
                MerchantRepository merchRepo = new MerchantRepository(merchDb);

                Transaction t1 = new Transaction("T1111", 5000, m1.getId(), cd1.getNumber(),
                                LocalDateTime.now().minusMonths(1));
                Transaction t2 = new Transaction("T2222", 10000, m1.getId(), cd1.getNumber(),
                                LocalDateTime.now());
                Transaction t3 = new Transaction("T3333", 6000, m2.getId(), cd1.getNumber(),
                                LocalDateTime.now().minusMonths(1));
                Transaction t4 = new Transaction("T4444", 12000, m2.getId(), cd2.getNumber(),
                                LocalDateTime.now());

                List<Transaction> listOfTransactions = List.of(t1, t2, t3, t4);
                TransactionDB tranDb = new TransactionDB(listOfTransactions);

                cd1.addTransaction(t1.getId());
                cd1.addTransaction(t2.getId());
                cd1.addTransaction(t3.getId());
                cd1.addTransaction(t4.getId());

                UnusualSpendsProcessor usp = new UnusualSpendsProcessor();
                TransactionRepository tr = new TransactionRepository(tranDb);
                List<TransactionWithCategory> transactionWithCategoryList = List
                                .of(new TransactionWithCategory(t1, m1.getCategory()));
                TransactionService tranService = new TransactionService(tr, merchRepo);
                usp.getUnusualSpending(transactionWithCategoryList);

        }
}