package com.sc.ddd.unusualSpends.service;

import com.sc.ddd.unusualSpends.DTO.SpendingByCategoryAndAmount;
import com.sc.ddd.unusualSpends.DTO.TransactionWithCategory;
import com.sc.ddd.unusualSpends.domain.entity.Transaction;
import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;
import com.sc.ddd.unusualSpends.repository.MerchantRepo;
import com.sc.ddd.unusualSpends.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;
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

        List<SpendingByCategoryAndAmount> spendingByCategoryAndAmountList = new ArrayList<>();
        List<TransactionWithCategory> validTransactions = new ArrayList<>();

        for(TransactionWithCategory transactionWithCategory : transactionWithCategoriesList){
            String transactionMonth = transactionWithCategory.getTransaction().getMonth();
            if ( transactionMonth == month){

                String creditCardFromTransaction = transactionWithCategory.getTransaction().getCreditCardId();
                if(creditCardIds.contains(creditCardFromTransaction)){
                    validTransactions.add(transactionWithCategory);
                }
            }
        }

        for(TransactionWithCategory transactionWithCategory : validTransactions){
            SpendingCategory spendingCategory = transactionWithCategory.getSpendingCategory();
            Double amount = transactionWithCategory.getTransaction().getAmount();

            var spendingByCategoryAndAmount = new SpendingByCategoryAndAmount(spendingCategory, amount);

            spendingByCategoryAndAmountList.add(spendingByCategoryAndAmount);
        }

        return spendingByCategoryAndAmountList;
    }

}
