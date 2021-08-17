package com.moneytap.transaction.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wallet {
    @Id
    private int walletId;
    private double balance;


    public Wallet() {
    }

    public Wallet(int walletId, double balance) {
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
