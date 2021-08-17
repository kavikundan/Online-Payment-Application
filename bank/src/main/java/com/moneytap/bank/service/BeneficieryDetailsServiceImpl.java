package com.moneytap.bank.service;

import com.moneytap.bank.model.BeneficieryDetails;
import com.moneytap.bank.model.Wallet;
import com.moneytap.bank.repository.BeneficieryDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeneficieryDetailsServiceImpl implements BeneficieryDetailsService{
    @Autowired
    BeneficieryDetailsRepository beneficieryDetailsRepository;

    @Override
    public void addbenefecieryDetails(BeneficieryDetails beneficieryDetails) {
        beneficieryDetailsRepository.save(beneficieryDetails);
    }

    @Override
    public List<BeneficieryDetails> getAllBeneficiery() {
        List<BeneficieryDetails> beneficieryDetailsList = new ArrayList<>();
        beneficieryDetailsRepository.findAll().forEach(beneficieryDetailsList::add);
        return beneficieryDetailsList;
    }

    @Override
    public BeneficieryDetails getBeneficieryDetails(Wallet walletId) {
        BeneficieryDetails beneficieryDetails =  beneficieryDetailsRepository.findByWalletId(walletId);
        return beneficieryDetails;
    }

    @Override
    public void deleteBeneficieryDetails(Wallet walletId) {
        int beneficieryId =  beneficieryDetailsRepository.findByWalletId(walletId).getBeneficieryId();
        beneficieryDetailsRepository.deleteById(beneficieryId);
    }
}
