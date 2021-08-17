package com.moneytap.bank.repository;

import com.moneytap.bank.model.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends CrudRepository<Wallet,Integer> {
}
