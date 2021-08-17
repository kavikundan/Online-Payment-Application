package com.moneytap.bank.service;

import com.moneytap.bank.exception.BeneficieryNotFoundException;
import com.moneytap.bank.exception.InsufficientAccountBalanceException;
import com.moneytap.bank.model.BankAccount;
import com.moneytap.bank.model.Wallet;
import com.moneytap.bank.repository.BankAccountRepository;
import com.moneytap.bank.repository.BeneficieryDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class BankAccountServiceImpl implements BankAccountService{
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    BeneficieryDetailsRepository beneficieryDetailsRepository;

    @Override
    public List<BankAccount> getAllAccounts() {
        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountRepository.findAll().forEach(bankAccountList::add);
        return bankAccountList;
    }

    @Override
    public void addBankAccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public void removeAccount(int account) {
        bankAccountRepository.deleteById(account);
    }

    @Override
    public void fundTransfer(int senderWalletId, int receiverWalletId, double amount) throws InsufficientAccountBalanceException, BeneficieryNotFoundException {
        Wallet swallet = new Wallet(senderWalletId);
        Wallet rwallet = new Wallet(receiverWalletId);
        if(beneficieryDetailsRepository.existsByWalletId(rwallet)) {
            BankAccount senderAccount = bankAccountRepository.findByWalletId(swallet);
            BankAccount receiverAccount = bankAccountRepository.findByWalletId(rwallet);
            if (senderAccount.getBalance() >= amount) {
                senderAccount.setBalance(senderAccount.getBalance() - amount);
                receiverAccount.setBalance(receiverAccount.getBalance() + amount);
                bankAccountRepository.save(senderAccount);
                bankAccountRepository.save(receiverAccount);
            } else {
                throw new InsufficientAccountBalanceException("Account Balance is not sufficient");
            }
        }
        else{
            throw new BeneficieryNotFoundException("Beneficiary not added yet!");
        }
    }
}
