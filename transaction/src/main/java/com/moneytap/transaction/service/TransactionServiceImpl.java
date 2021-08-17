package com.moneytap.transaction.service;

import com.moneytap.transaction.model.Transaction;
import com.moneytap.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> viewAllTransactions() {
        List<Transaction> transactionList=new ArrayList<>();
        transactionRepository.findAll().forEach(transactionList::add);
        return transactionList;
    }

    @Override
    public List<Transaction> viewTransactionByDate(LocalDate date) {
        List<Transaction> transactionList=new ArrayList<>();
        transactionRepository.findAllByTransactionDate(date).forEach(transactionList::add);
        return transactionList;
    }

    @Override
    public List<Transaction> viewTransactionByType(String transactionType) {
        List<Transaction> transactionList=new ArrayList<>();
        transactionRepository.findAllByTransactionType(transactionType).forEach(transactionList::add);
        return transactionList;
    }
}
