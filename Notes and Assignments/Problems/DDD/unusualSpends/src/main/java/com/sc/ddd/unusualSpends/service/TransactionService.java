package com.sc.ddd.unusualSpends.service;

import com.sc.ddd.unusualSpends.DTO.SpendingByCategoryAndAmount;
import com.sc.ddd.unusualSpends.DTO.TransactionWithCategory;
import com.sc.ddd.unusualSpends.domain.entity.Transaction;
import com.sc.ddd.unusualSpends.repository.MerchantRepository;
import com.sc.ddd.unusualSpends.repository.TransactionRepository;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TransactionService {

    public final TransactionRepository transactionRepo;
    public final MerchantRepository merchantRepository;


    public TransactionService(TransactionRepository transactionRepo, MerchantRepository merchantRepository) {
        this.transactionRepo = transactionRepo;
        this.merchantRepository = merchantRepository;
    }

    public List<TransactionWithCategory> createAndAddTransactionWithCategory(){
        List<TransactionWithCategory> transactionWithCategoryList = new ArrayList<>();

        for(Transaction transaction : transactionRepo.getAllTransactions()){
            var category = merchantRepository.getMerchantCategoryByID(transaction.getMerchantId());
            var transactionWithCategory = new TransactionWithCategory(transaction, category);
            transactionWithCategoryList.add(transactionWithCategory);
        }

        return  transactionWithCategoryList;
    }

    public List<SpendingByCategoryAndAmount> getSpendingByCategoryAndAmount(
            Set<String> creditCardIds,
            Month month,
            List<TransactionWithCategory> transactionWithCategoriesList){

        return transactionWithCategoriesList.stream()
                .filter( transactionWithCategory ->
                        month == transactionWithCategory.getTransaction().getMonth() &&
                                creditCardIds.contains(transactionWithCategory.getTransaction().getCreditCardId())
                )
                .map( validTransaction ->
                        new SpendingByCategoryAndAmount(
                                validTransaction.getSpendingCategory(),
                                validTransaction.getTransaction().getAmount()
                        )
                ).toList();
    }

}
