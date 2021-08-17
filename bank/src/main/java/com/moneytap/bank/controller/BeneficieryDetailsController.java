package com.moneytap.bank.controller;

import com.moneytap.bank.model.BeneficieryDetails;
import com.moneytap.bank.model.Wallet;
import com.moneytap.bank.service.BeneficieryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficieryDetails")
public class BeneficieryDetailsController {
    @Autowired
    BeneficieryDetailsService beneficieryDetailsService;

    @PostMapping("/addbeneficieryDetails")
    public void addBeneficieryDetails(@RequestBody BeneficieryDetails beneficieryDetails){
        beneficieryDetailsService.addbenefecieryDetails(beneficieryDetails);
    }

    @GetMapping("/")
    public List<BeneficieryDetails> getAllBeneficieryDetails(){
        return beneficieryDetailsService.getAllBeneficiery();
    }

    @GetMapping("/{walletId}")
    public BeneficieryDetails getBeneficieryDetails(@PathVariable Wallet walletId){
        return beneficieryDetailsService.getBeneficieryDetails(walletId);
    }
    @DeleteMapping("/{walletId}")
    public void deleteBeneficieryDetails(@PathVariable Wallet walletId){
        beneficieryDetailsService.deleteBeneficieryDetails(walletId);
    }

}
