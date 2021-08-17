package com.moneytap.bank.service;

import com.moneytap.bank.model.BeneficieryDetails;
import com.moneytap.bank.model.Wallet;

import java.util.List;
import java.util.Optional;

public interface BeneficieryDetailsService {
    void addbenefecieryDetails(BeneficieryDetails beneficieryDetails);
    List<BeneficieryDetails> getAllBeneficiery();
    BeneficieryDetails getBeneficieryDetails(Wallet walletId);
    void deleteBeneficieryDetails(Wallet walletId);


}
