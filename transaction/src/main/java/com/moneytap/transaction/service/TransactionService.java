package com.moneytap.transaction.service;

import com.moneytap.transaction.model.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
    void addTransaction(Transaction transaction);
    List<Transaction> viewAllTransactions();
    List<Transaction> viewTransactionByDate(LocalDate date);
    List<Transaction> viewTransactionByType(String transactionType);
}
