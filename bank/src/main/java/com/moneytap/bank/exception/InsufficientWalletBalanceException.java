package com.moneytap.bank.exception;

public class InsufficientWalletBalanceException extends Exception{
   public InsufficientWalletBalanceException(String msg){
       super(msg);
   }
}
