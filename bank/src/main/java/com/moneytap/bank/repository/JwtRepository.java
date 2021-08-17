package com.moneytap.bank.repository;

import com.moneytap.bank.model.JwtResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtRepository extends CrudRepository<JwtResponse,String> {
}
