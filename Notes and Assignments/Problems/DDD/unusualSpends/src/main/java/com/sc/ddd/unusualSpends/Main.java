package com.sc.ddd.unusualSpends;

import com.sc.ddd.unusualSpends.DTO.SpendingByCategoryAndAmount;
import com.sc.ddd.unusualSpends.DTO.TransactionWithCategory;
import com.sc.ddd.unusualSpends.config.UnusualSpendsConfig;
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
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // System.out.println("Welcome to Unusual Spending Detection System");

        // CreditCards
        CreditCard cd1 = new CreditCard("101", "1234 5678 9012");
        CreditCard cd2 = new CreditCard("101", "1234 5678 9013");

        User user = new User("101", "Akash", "akashhedau65@gmail.com", "8308985621",
                List.of(cd1.getNumber(), cd2.getNumber()));

        // Merchants
        Merchant m1 = new Merchant("M1111", "VRL Travels", SpendingCategory.TRAVEL);
        Merchant m2 = new Merchant("M2222", "Aroma", SpendingCategory.FOOD);
        Merchant m3 = new Merchant("M2222", "HP Petroleum", SpendingCategory.FUEL);

        MerchantDB merchDb = new MerchantDB();
        MerchantRepository merchRepo = new MerchantRepository(merchDb);
        merchRepo.addMerchant(m1);
        merchRepo.addMerchant(m2);
        merchRepo.addMerchant(m3);

        // Transactions
        Transaction t1 = new Transaction("T1111", 5000, m1.getId(), cd1.getNumber(),
                LocalDateTime.of(2025, Month.JUNE, 15, 0, 0));
        Transaction t2 = new Transaction("T2222", 10000, m1.getId(), cd1.getNumber(),
                LocalDateTime.of(2025, Month.JULY, 16, 0, 0));
        Transaction t3 = new Transaction("T3333", 6000, m2.getId(), cd1.getNumber(),
                LocalDateTime.of(2025, Month.JUNE, 17, 0, 0));
        Transaction t4 = new Transaction("T4444", 12000, m2.getId(), cd2.getNumber(),
                LocalDateTime.of(2025, Month.JULY, 18, 0, 0));

        TransactionDB tranDb = new TransactionDB();
        TransactionRepository transactionRepository = new TransactionRepository(tranDb);
        transactionRepository.addTransaction(t1);
        transactionRepository.addTransaction(t2);
        transactionRepository.addTransaction(t3);
        transactionRepository.addTransaction(t4);


        UnusualSpendsConfig unusualSpendsConfig = new UnusualSpendsConfig(50.0);

        TransactionService tranService = new TransactionService(transactionRepository, merchRepo);

        List<TransactionWithCategory> transactionWithCategoryList = tranService.createAndAddTransactionWithCategory();

        List<SpendingByCategoryAndAmount> lastMontSpendingByCategoryAndAmount = tranService.getSpendingByCategoryAndAmount(Set.of(cd1.getNumber()),
                Month.JUNE.toString(), transactionWithCategoryList);
        List<SpendingByCategoryAndAmount> currentMontSpendingByCategoryAndAmount = tranService.getSpendingByCategoryAndAmount(Set.of(cd1.getNumber()),
                Month.JULY.toString(), transactionWithCategoryList);

        UnusualSpendsProcessor usp = new UnusualSpendsProcessor();

        System.out.println(usp.getUnusualSpending(
                lastMontSpendingByCategoryAndAmount,
                currentMontSpendingByCategoryAndAmount,
                unusualSpendsConfig));
    }
}