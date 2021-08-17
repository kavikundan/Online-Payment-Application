package com.moneytap.bank.exception;

public class InsufficientAccountBalanceException extends Exception{
    public InsufficientAccountBalanceException(String msg) {
        super(msg);
    }
}
