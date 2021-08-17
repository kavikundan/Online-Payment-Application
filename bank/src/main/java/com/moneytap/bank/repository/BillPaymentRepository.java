package com.moneytap.bank.repository;

import com.moneytap.bank.model.BillPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillPaymentRepository extends CrudRepository<BillPayment,Integer> {
}
