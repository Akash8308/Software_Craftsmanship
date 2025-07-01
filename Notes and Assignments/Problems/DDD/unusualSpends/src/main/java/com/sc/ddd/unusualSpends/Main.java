package com.sc.ddd.unusualSpends;

import com.sc.ddd.unusualSpends.DTO.SpendingByCategoryAndAmount;
import com.sc.ddd.unusualSpends.DTO.TransactionWithCategory;
import com.sc.ddd.unusualSpends.DTO.UnusualSpend;
import com.sc.ddd.unusualSpends.config.UnusualSpendsConfig;
import com.sc.ddd.unusualSpends.database.MerchantDB;
import com.sc.ddd.unusualSpends.database.TransactionDB;
import com.sc.ddd.unusualSpends.database.UserDB;
import com.sc.ddd.unusualSpends.domain.Service.UnusualSpendsProcessor;
import com.sc.ddd.unusualSpends.domain.entity.CreditCard;
import com.sc.ddd.unusualSpends.domain.entity.Merchant;
import com.sc.ddd.unusualSpends.domain.entity.Transaction;
import com.sc.ddd.unusualSpends.domain.entity.User;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;
import com.sc.ddd.unusualSpends.repository.MerchantRepository;
import com.sc.ddd.unusualSpends.repository.TransactionRepository;
import com.sc.ddd.unusualSpends.repository.UserRepository;
import com.sc.ddd.unusualSpends.service.Formatter;
import com.sc.ddd.unusualSpends.service.Impl.EmailCommunicator;
import com.sc.ddd.unusualSpends.service.Impl.EmailFormatter;
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
        CreditCard cred_1 = new CreditCard("Cred_1", "1234 5678 9012");
        CreditCard cred_2 = new CreditCard("Cred_2", "1234 5678 9013");

        UserDB userDB = new UserDB();
        UserRepository userRepository = new UserRepository(userDB);

        User user = new User("101", "Akash", "akashhedau65@gmail.com", "8308985621",
                List.of(cred_1.getNumber(), cred_2.getNumber()));

        userRepository.addUser(user);

        // Merchants
        Merchant merch1 = new Merchant("merch1", "VRL Travels", SpendingCategory.TRAVEL);
        Merchant merch_2 = new Merchant("merch_2", "Aroma", SpendingCategory.FOOD);
        Merchant merch_3 = new Merchant("merch_3", "HP Petroleum", SpendingCategory.FUEL);

        MerchantDB merchDb = new MerchantDB();
        MerchantRepository merchRepo = new MerchantRepository(merchDb);
        merchRepo.addMerchant(merch1);
        merchRepo.addMerchant(merch_2);
        merchRepo.addMerchant(merch_3);

        // Transactions
        Transaction t1 = new Transaction("1", 500, merch1.getId(), cred_1.getNumber(),
                LocalDateTime.of(2025, Month.JUNE, 15, 0, 0));
        Transaction t2 = new Transaction("2", 100, merch_2.getId(), cred_1.getNumber(),
                LocalDateTime.of(2025, Month.JUNE, 16, 0, 0));
        Transaction t3 = new Transaction("3", 200, merch_3.getId(), cred_1.getNumber(),
                LocalDateTime.of(2025, Month.JUNE, 17, 0, 0));
        Transaction t4 = new Transaction("4", 5000, merch1.getId(), cred_1.getNumber(),
                LocalDateTime.of(2025, Month.JULY, 18, 0, 0));
        Transaction t5 = new Transaction("5", 10000, merch_2.getId(), cred_1.getNumber(),
                LocalDateTime.of(2025, Month.JULY, 18, 0, 0));
        Transaction t6 = new Transaction("6", 20000, merch_3.getId(), cred_1.getNumber(),
                LocalDateTime.of(2025, Month.JULY, 18, 0, 0));

        TransactionDB tranDb = new TransactionDB();
        TransactionRepository transactionRepository = new TransactionRepository(tranDb);
        transactionRepository.addTransaction(t1);
        transactionRepository.addTransaction(t2);
        transactionRepository.addTransaction(t3);
        transactionRepository.addTransaction(t4);
        transactionRepository.addTransaction(t5);
        transactionRepository.addTransaction(t6);


        UnusualSpendsConfig unusualSpendsConfig = new UnusualSpendsConfig(50.0);

        TransactionService tranService = new TransactionService(transactionRepository, merchRepo);

        List<TransactionWithCategory> transactionWithCategoryList = tranService.createAndAddTransactionWithCategory();

        List<SpendingByCategoryAndAmount> lastMontSpendingByCategoryAndAmount = tranService.getSpendingByCategoryAndAmount(
                Set.of(cred_1.getNumber()),
                Month.JUNE,
                transactionWithCategoryList
        );

        List<SpendingByCategoryAndAmount> currentMontSpendingByCategoryAndAmount = tranService.getSpendingByCategoryAndAmount(
                Set.of(cred_1.getNumber()),
                Month.JULY,
                transactionWithCategoryList
        );

        UnusualSpendsProcessor usp = new UnusualSpendsProcessor();

        List<UnusualSpend> unusualSpends = usp.getUnusualSpending(
                lastMontSpendingByCategoryAndAmount,
                currentMontSpendingByCategoryAndAmount,
                unusualSpendsConfig);

        System.out.println(unusualSpends);

        if(unusualSpends != null){

            EmailFormatter emailFormatter = new EmailFormatter();
            String formattedMessage = emailFormatter.formatMessage(unusualSpends, userRepository.getUserNameById(user.getId()));

            EmailCommunicator emailCommunicator = new EmailCommunicator();
            emailCommunicator.communicate(userRepository.getUserContactById(user.getId()), "Unusual spending of" + unusualSpends.get(0).getAmount() +"detected!",formattedMessage);

        }
    }
}