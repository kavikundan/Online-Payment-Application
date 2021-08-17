package com.moneytap.customer.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BankAccount {
    @Id
    private int accno;
    private String ifscCode;
    private String bankName;
    private double balance;
    @OneToOne
    @JoinColumn(name = "walletId")
    @JsonIgnore
    private Wallet walletId;

    public BankAccount() {
    }

    public BankAccount(int accno, String ifscCode, String bankName, double balance,Wallet walletId) {
        this.accno = accno;
        this.ifscCode = ifscCode;
        this.bankName = bankName;
        this.balance = balance;
        this.walletId=walletId;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accno=" + accno +
                ", ifscCode='" + ifscCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Wallet getWalletId() {
        return walletId;
    }

    public void setWalletId(Wallet walletId) {
        this.walletId = walletId;
    }
}
