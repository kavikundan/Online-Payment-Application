package com.moneytap.customer.controller;

import com.moneytap.customer.model.Customer;
import com.moneytap.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/register")
    public void registerCustomer(@RequestBody Customer customer){
        customerService.registerCustomer(customer);
    }

}
