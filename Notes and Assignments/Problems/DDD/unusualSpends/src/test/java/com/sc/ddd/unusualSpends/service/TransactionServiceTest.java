package com.sc.ddd.unusualSpends.service;

import com.sc.ddd.unusualSpends.DTO.TransactionWithCategory;
import com.sc.ddd.unusualSpends.database.MerchantDB;
import com.sc.ddd.unusualSpends.database.TransactionDB;
import com.sc.ddd.unusualSpends.domain.entity.Merchant;
import com.sc.ddd.unusualSpends.domain.entity.Transaction;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;
import com.sc.ddd.unusualSpends.repository.MerchantRepository;
import com.sc.ddd.unusualSpends.repository.TransactionRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    // TODO: complete shouldCreateAndAddTransactionWithCategory test
    @Test
    void shouldCreateAndAddTransactionWithCategory(){
        var merchant1 = new Merchant("M01", "Akash", SpendingCategory.FOOD);
        var merchant2 = new Merchant("M02", "Akash2", SpendingCategory.TRAVEL);
        var merchant3 = new Merchant("M03", "Akash3", SpendingCategory.FUEL);
        var merchant4 = new Merchant("M04", "Akash4", SpendingCategory.FOOD);

        var tran1 = new Transaction("T01", 100, merchant1.getId(), "C01", LocalDateTime.now());
        var tran2 = new Transaction("T02", 200, merchant2.getId(), "C01", LocalDateTime.now());
        var tran3 = new Transaction("T03", 300, merchant3.getId(), "C01", LocalDateTime.now());
        var tran4 = new Transaction("T04", 400, merchant4.getId(), "C01", LocalDateTime.now());

        TransactionDB tranDB = new TransactionDB();
        TransactionRepository tranRepo = new TransactionRepository(tranDB);

        tranRepo.addTransaction(tran1);
        tranRepo.addTransaction(tran2);
        tranRepo.addTransaction(tran3);
        tranRepo.addTransaction(tran4);

        MerchantDB merchDB = new MerchantDB();
        MerchantRepository merchRepo = new MerchantRepository(merchDB);

        merchRepo.addMerchant(merchant1);
        merchRepo.addMerchant(merchant2);
        merchRepo.addMerchant(merchant3);
        merchRepo.addMerchant(merchant4);

        TransactionService tranService = new TransactionService(tranRepo, merchRepo);

        List<TransactionWithCategory> transactionWithCategoryList = tranService.createAndAddTransactionWithCategory();

        TransactionWithCategory tranWithCategory1 = new TransactionWithCategory(tran1, SpendingCategory.FOOD);
        TransactionWithCategory tranWithCategory2 = new TransactionWithCategory(tran2, SpendingCategory.TRAVEL);
        TransactionWithCategory tranWithCategory3 = new TransactionWithCategory(tran3, SpendingCategory.FUEL);
        TransactionWithCategory tranWithCategory4 = new TransactionWithCategory(tran4, SpendingCategory.FOOD);
        List<TransactionWithCategory> expectedTransactionWithCategoryList = List.of(
                tranWithCategory1,
                tranWithCategory2,
                tranWithCategory3,
                tranWithCategory4
        );

//        assertEquals(expectedTransactionWithCategoryList, transactionWithCategoryList);
//        assertEquals(expectedTransactionWithCategoryList, transactionWithCategoryList);
        assertTrue(expectedTransactionWithCategoryList.containsAll(transactionWithCategoryList));
    }
}