package com.hornosg.hexagonaldddexample.customers.application;

import com.hornosg.hexagonaldddexample.customers.domain.Customer;
import com.hornosg.hexagonaldddexample.customers.domain.CustomerRepository;

public class CustomerCreator {

    private final CustomerRepository repository;

    CustomerCreator(CustomerRepository repository){
        this.repository = repository;
    }

    public void invoke(Customer customer){
        repository.save(customer);
    }

}
