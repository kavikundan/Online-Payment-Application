package com.moneytap.bank.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {
    @Id
    private int CustomerId;
    private String name;
    private long mobileNumbar;
    private String password;
    @OneToOne
    @JoinColumn(name = "walletId")
    @JsonIgnore
    private Wallet walletId;

    public Customer() {
    }

    public Customer(int customerId, String name, long mobileNumbar, String password, Wallet walletId) {
        CustomerId = customerId;
        this.name = name;
        this.mobileNumbar = mobileNumbar;
        this.password = password;
        this.walletId=walletId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerId='" + CustomerId + '\'' +
                ", name='" + name + '\'' +
                ", mobileNumbar=" + mobileNumbar +
                ", password='" + password + '\'' +
                ", walletId='" + walletId + '\'' +
                '}';
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNumbar() {
        return mobileNumbar;
    }

    public void setMobileNumbar(long mobileNumbar) {
        this.mobileNumbar = mobileNumbar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Wallet getWalletId() {
        return walletId;
    }

    public void setWalletId(Wallet walletId) {
        this.walletId = walletId;
    }
}
