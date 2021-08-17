package com.moneytap.bank.service;

import com.moneytap.bank.exception.InsufficientAccountBalanceException;
import com.moneytap.bank.exception.InsufficientWalletBalanceException;
import com.moneytap.bank.model.BankAccount;
import com.moneytap.bank.model.Wallet;
import com.moneytap.bank.repository.BankAccountRepository;
import com.moneytap.bank.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService{
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public void createWallet(Wallet wallet) {
        walletRepository.save(wallet);
    }

    @Override
    public double getBalance(int walletId) {
       Wallet wallet = walletRepository.findById(walletId).get();
       return wallet.getBalance();
    }

    @Override
    public void addMoney(double money,int walletId) throws InsufficientAccountBalanceException {
        Wallet wallet = walletRepository.findById(walletId).get();
        BankAccount bankAccount = bankAccountRepository.findByWalletId(wallet);
        if (bankAccount.getBalance()>=money) {
            bankAccount.setBalance(bankAccount.getBalance() - money);
            wallet.setBalance(wallet.getBalance() + money);
            bankAccountRepository.save(bankAccount);
            walletRepository.save(wallet);
        }
        else{
            throw new InsufficientAccountBalanceException("Account Balance is low!");
        }
    }

    @Override
    public void depositeAmount(double amount,int walletId) throws InsufficientWalletBalanceException {
        Wallet wallet = walletRepository.findById(walletId).get();
        BankAccount bankAccount = bankAccountRepository.findByWalletId(wallet);
        if(wallet.getBalance()>=amount){
            bankAccount.setBalance(bankAccount.getBalance()+amount);
            wallet.setBalance(wallet.getBalance()-amount);
            bankAccountRepository.save(bankAccount);
            walletRepository.save(wallet);
        }
        else{
            throw new InsufficientWalletBalanceException("Wallet Balance is less than amount");
        }
    }

    @Override
    public void billPayment(double amount, int walletId) throws InsufficientWalletBalanceException {
        Wallet wallet = walletRepository.findById(walletId).get();
        if(wallet.getBalance()>=amount) {
            wallet.setBalance(wallet.getBalance() - amount);
            walletRepository.save(wallet);
        }
        else{
            throw new InsufficientWalletBalanceException("Wallet Balance is low!");
        }
    }

}
