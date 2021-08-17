package com.moneytap.bank.controller;

import com.moneytap.bank.exception.BeneficieryNotFoundException;
import com.moneytap.bank.exception.InsufficientAccountBalanceException;
import com.moneytap.bank.model.BankAccount;
import com.moneytap.bank.model.Transaction;
import com.moneytap.bank.model.Wallet;
import com.moneytap.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {
    @Autowired
    BankAccountService bankAccountService;

    @Autowired
    RestTemplate restTemplate;
    String transactionUrl = "http://transaction-service/transactions/";


    @GetMapping("/")
    public List<BankAccount> getAllAccounts(){
        return bankAccountService.getAllAccounts();
    }
    @PostMapping("/addBankAccount")
    public void addBankAccount(@RequestBody BankAccount bankAccount){
        bankAccountService.addBankAccount(bankAccount);
    }
    @DeleteMapping("/{accNo}")
    public void deleteBankAccount(@PathVariable int accNo){
        bankAccountService.removeAccount(accNo);
    }
    @PutMapping("/fundTransfer/{senderWalletId}/{receiverWalletId}/{amount}")
    public void fundTransfer(@PathVariable int senderWalletId,@PathVariable int receiverWalletId,@PathVariable double amount) throws InsufficientAccountBalanceException, BeneficieryNotFoundException {
        bankAccountService.fundTransfer(senderWalletId,receiverWalletId,amount);
        int tid = (int) (Math.random()*10000);
        String tType = "WalletToBank";
        LocalDate tDate = java.time.LocalDate.now();
        String tdescription = "Adding Money to Bank from Wallet";
        Wallet wallet = new Wallet(senderWalletId);
        Transaction transaction = new Transaction(tid,tType,tDate,amount,tdescription,wallet);
        restTemplate.postForObject(transactionUrl+"add/",transaction,Transaction.class);
    }
}
