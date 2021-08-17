package com.moneytap.bank.exception;

public class BankAccountNotFoundException extends Exception{
    public BankAccountNotFoundException(String msg){
        super(msg);
    }
}
