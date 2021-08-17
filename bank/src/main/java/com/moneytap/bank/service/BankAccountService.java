package com.moneytap.bank.service;

import com.moneytap.bank.exception.BeneficieryNotFoundException;
import com.moneytap.bank.exception.InsufficientAccountBalanceException;
import com.moneytap.bank.model.BankAccount;

import java.util.List;

public interface BankAccountService {
    List<BankAccount> getAllAccounts();
    void addBankAccount(BankAccount bankAccount);
    void removeAccount(int account);
    void fundTransfer(int senderWalletId,int receiverWalletId,double amount) throws InsufficientAccountBalanceException, BeneficieryNotFoundException;

}
