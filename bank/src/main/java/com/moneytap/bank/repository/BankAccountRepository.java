package com.moneytap.bank.repository;

import com.moneytap.bank.model.BankAccount;
import com.moneytap.bank.model.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount,Integer> {
    BankAccount findByWalletId(Wallet walletId);
}
