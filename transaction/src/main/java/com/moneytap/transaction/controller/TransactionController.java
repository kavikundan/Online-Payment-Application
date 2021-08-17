package com.moneytap.transaction.controller;

import com.moneytap.transaction.model.Transaction;
import com.moneytap.transaction.model.TransactionList;
import com.moneytap.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/add")
    public void addTransaction(@RequestBody Transaction transaction){
        transactionService.addTransaction(transaction);
    }

    @GetMapping("/")
    public TransactionList viewAllTransactions(){
        TransactionList transactionList = new TransactionList();
        transactionList.setTransactionList(transactionService.viewAllTransactions());
        return transactionList;
    }
    @GetMapping("/date/{date}")
    public TransactionList  viewTransactionByDate(@PathVariable String date){
        LocalDate localDate = LocalDate.parse(date);
        TransactionList transactionList = new TransactionList();
        transactionList.setTransactionList(transactionService.viewTransactionByDate(localDate));
        return transactionList;
    }
    @GetMapping("/type/{type}")
    public TransactionList viewTransactionByType(@PathVariable String type){
        TransactionList transactionList = new TransactionList();
        transactionList.setTransactionList(transactionService.viewTransactionByType(type));
        return transactionList;
    }
}
