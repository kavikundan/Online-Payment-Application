package com.moneytap.transaction.model;

import java.util.List;

public class TransactionList {
    List<Transaction> transactionList;

    public TransactionList() {
    }

    @Override
    public String toString() {
        return "TransactionList{" +
                "transactionList=" + transactionList +
                '}';
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
