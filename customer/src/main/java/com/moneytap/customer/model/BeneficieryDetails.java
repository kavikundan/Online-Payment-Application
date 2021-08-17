package com.moneytap.customer.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BeneficieryDetails {
    @Id
    private int beneficieryId;
    private String name;
    private long mobileNumber;
    @ManyToOne
    @JoinColumn(name = "walletId")
    @JsonIgnore
    private Wallet walletId;

    public BeneficieryDetails() {
    }

    public BeneficieryDetails(int beneficieryId, String name, long mobileNumber) {
        this.beneficieryId = beneficieryId;
        this.name = name;
        this.mobileNumber = mobileNumber;

    }

    @Override
    public String toString() {
        return "BeneficieryDetails{" +
                "beneficieryId=" + beneficieryId +
                ", name='" + name + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", walletId=" + walletId +
                '}';
    }

    public int getBeneficieryId() {
        return beneficieryId;
    }

    public void setBeneficieryId(int beneficieryId) {
        this.beneficieryId = beneficieryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Wallet getWalletId() {
        return walletId;
    }

    public void setWalletId(Wallet walletId) {
        this.walletId = walletId;
    }
}
