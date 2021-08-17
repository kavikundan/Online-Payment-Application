package com.moneytap.customer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerTocken {
    @Id
    private long mobileNo;
    private String token;

    public CustomerTocken() {
    }

    public CustomerTocken(long mobileNo, String token) {
        this.mobileNo = mobileNo;
        this.token = token;
    }

    @Override
    public String toString() {
        return "CustomerTocken{" +
                "mobileNo=" + mobileNo +
                ", token='" + token + '\'' +
                '}';
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
