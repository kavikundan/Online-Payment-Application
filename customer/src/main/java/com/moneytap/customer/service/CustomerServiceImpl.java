package com.moneytap.customer.service;

import com.moneytap.customer.model.Customer;
import com.moneytap.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void registerCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
