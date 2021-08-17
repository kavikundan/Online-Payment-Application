package com.moneytap.transaction.repository;

import com.moneytap.transaction.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Integer> {
    public  List<Transaction> findAllByTransactionDate(LocalDate date);
    public  List<Transaction> findAllByTransactionType(String transactionType);
}
