package com.moneytap.bank.service;

import com.moneytap.bank.model.BillPayment;
import com.moneytap.bank.repository.BankAccountRepository;
import com.moneytap.bank.repository.BillPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillPaymentServiceImpl implements BillPaymentService{
    @Autowired
    BillPaymentRepository billPaymentRepository;

    @Override
    public void addBillPayment(BillPayment billPayment) {
        billPaymentRepository.save(billPayment);
    }
}
