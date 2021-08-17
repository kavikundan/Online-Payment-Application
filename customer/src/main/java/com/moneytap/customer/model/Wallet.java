package com.moneytap.customer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wallet {
    @Id
    private int walletId;
    private double balance=0;


    public Wallet() {
    }

    public Wallet(int walletId) {
        this.walletId = walletId;
        this.balance = balance;

    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
