package com.moneytap.bank.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class BillPayment {
    @Id
    private int bilId;
    private String billType;
    private double amount;
    private LocalDate paymentDate;
    @ManyToOne
    @JoinColumn(name = "walletId")
    @JsonIgnore
    private Wallet walletId;

    public BillPayment() {
    }

    public BillPayment(int bilId, String billType, double amount, LocalDate paymentDate, Wallet walletId) {
        this.bilId = bilId;
        this.billType = billType;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.walletId = walletId;
    }

    public int getBilId() {
        return bilId;
    }

    public void setBilId(int bilId) {
        this.bilId = bilId;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Wallet getWalletId() {
        return walletId;
    }

    public void setWalletId(Wallet walletId) {
        this.walletId = walletId;
    }
}
