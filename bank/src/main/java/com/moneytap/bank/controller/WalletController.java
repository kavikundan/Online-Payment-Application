package com.moneytap.bank.controller;

import com.moneytap.bank.exception.InsufficientAccountBalanceException;
import com.moneytap.bank.exception.InsufficientWalletBalanceException;
import com.moneytap.bank.model.*;
import com.moneytap.bank.repository.JwtRepository;
import com.moneytap.bank.service.BillPaymentService;
import com.moneytap.bank.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    WalletService walletService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    BillPaymentService billPaymentService;
    @Autowired
    JwtRepository jwtRepository;

    String registerUrl = "http://customer-service/customer/register/";
    String transactionUrl = "http://transaction-service/transactions/";



    @PostMapping("/register")
    public void registerCustomer(@RequestBody Customer customer){
        restTemplate.postForObject(registerUrl,customer,Customer.class);
    }

    @PostMapping("/")
    public void createWallet(@RequestBody Wallet wallet){
        walletService.createWallet(wallet);
    }

    @GetMapping("/getBalance/{walletId}")
    public double getBalance(@PathVariable int walletId){
        return walletService.getBalance(walletId);
    }
    @PutMapping("/addMoney/{walletId}/{money}")
    public void addMoney(@PathVariable int walletId,@PathVariable int money) throws InsufficientAccountBalanceException {
        walletService.addMoney(money,walletId);
        int tid = (int) (Math.random()*10000);
        String tType = "BankToWallet";
        LocalDate tDate = java.time.LocalDate.now();
        String tdescription = "Adding Money to Wallet from Bank";
        Wallet wallet = new Wallet(walletId);
        Transaction transaction = new Transaction(tid,tType,tDate,money,tdescription,wallet);
        restTemplate.postForObject(transactionUrl+"add/",transaction,Transaction.class);
    }
    @PutMapping("/depositeAmount/{walletId}/{amount}")
    public void depositeAmount(@PathVariable int walletId,@PathVariable int amount) throws InsufficientWalletBalanceException {
        walletService.depositeAmount(amount,walletId);
        int tid = (int) (Math.random()*10000);
        String tType = "WalletToBank";
        LocalDate tDate = java.time.LocalDate.now();
        String tdescription = "Adding Money to Bank from Wallet";
        Wallet wallet = new Wallet(walletId);
        Transaction transaction = new Transaction(tid,tType,tDate,amount,tdescription,wallet);
        restTemplate.postForObject(transactionUrl+"add/",transaction,Transaction.class);
    }

    @GetMapping("/viewTransaction")
    public List<Transaction> viwAllTransaction(){
       TransactionList transactionList= restTemplate.getForObject(transactionUrl, TransactionList.class);
        return transactionList.getTransactionList();
    }
    @GetMapping("/date/{date}")
    public List<Transaction> viewtransactionByDate(@PathVariable String date){
        TransactionList transactionList = restTemplate.getForObject(transactionUrl+"date/"+date,TransactionList.class);
        return transactionList.getTransactionList();
    }
    @GetMapping("/type/{type}")
    public List<Transaction> viewtransactionByType(@PathVariable String type){
        TransactionList transactionList = restTemplate.getForObject(transactionUrl+"type/"+type,TransactionList.class);
        return transactionList.getTransactionList();
    }
    @PutMapping("/billPayment/{walletId}/{amount}/{billType}")
    public void billPayment(@PathVariable int walletId,@PathVariable double amount,@PathVariable String billType) throws InsufficientWalletBalanceException {
       walletService.billPayment(amount,walletId);
       int billId = (int) (Math.random()*10000);
       LocalDate localDate =java.time.LocalDate.now();
       Wallet wallet = new Wallet(walletId);
       BillPayment billPayment = new BillPayment(billId,billType,amount,localDate,wallet);
       billPaymentService.addBillPayment(billPayment);
    }

    @GetMapping("/walletLogOut")
    public String logOutWallet(){
        jwtRepository.deleteAll();
       return "Log-Out";
    }

}
