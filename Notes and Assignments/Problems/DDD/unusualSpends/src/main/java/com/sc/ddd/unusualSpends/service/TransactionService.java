package com.sc.ddd.unusualSpends.service;

import com.sc.ddd.unusualSpends.DTO.SpendingByCategoryAndAmount;
import com.sc.ddd.unusualSpends.DTO.TransactionWithCategory;
import com.sc.ddd.unusualSpends.domain.entity.Transaction;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;
import com.sc.ddd.unusualSpends.repository.MerchantRepo;
import com.sc.ddd.unusualSpends.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TransactionService {

    public final TransactionRepository transactionRepo;
    public final MerchantRepo merchantRepo;
    public final List<TransactionWithCategory> transactionWithCategoryList;


    public TransactionService(TransactionRepository transactionRepo, MerchantRepo merchantRepo) {
        this.transactionRepo = transactionRepo;
        this.merchantRepo = merchantRepo;
        this.transactionWithCategoryList = new ArrayList<>();
    }

    public List<TransactionWithCategory> createAndAddTransactionWithCategory(){
        for(Transaction transaction : transactionRepo.getAllTransactions()){
            var category = merchantRepo.getMerchantCategoryByID(transaction.getMerchantId());
            var transactionWithCategory = new TransactionWithCategory(transaction, category);
            transactionWithCategoryList.add(transactionWithCategory);
        }

        return  transactionWithCategoryList;
    }

    public List<TransactionWithCategory> getAllTransactionWithCategory(){
        return this.transactionWithCategoryList;
    }

    public List<SpendingByCategoryAndAmount> getSpendingByCategoryAndAmount(
            Set<String> creditCardIds,
            String month,
            List<TransactionWithCategory> transactionWithCategoriesList){

        return transactionWithCategoryList.stream()
                .filter( transactionWithCategory ->
                        Objects.equals(month, transactionWithCategory.getTransaction().getMonth()) &&
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
