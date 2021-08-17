package com.moneytap.bank.service;

import com.moneytap.bank.exception.InsufficientAccountBalanceException;
import com.moneytap.bank.exception.InsufficientWalletBalanceException;
import com.moneytap.bank.model.Wallet;

public interface WalletService {
    void createWallet(Wallet wallet);
    double getBalance(int walletId);
    void addMoney(double money,int walletId) throws InsufficientAccountBalanceException;
    void depositeAmount(double amount,int walletId) throws InsufficientWalletBalanceException;
    void billPayment(double amount,int walletId) throws InsufficientWalletBalanceException;

}
