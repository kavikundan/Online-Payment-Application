package com.moneytap.bank.repository;

import com.moneytap.bank.model.BeneficieryDetails;
import com.moneytap.bank.model.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficieryDetailsRepository extends CrudRepository<BeneficieryDetails,Integer> {
        BeneficieryDetails findByWalletId(Wallet walletId);
        boolean existsByWalletId(Wallet walletId);
}
