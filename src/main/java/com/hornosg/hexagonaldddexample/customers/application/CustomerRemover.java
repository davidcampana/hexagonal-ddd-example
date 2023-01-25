package com.hornosg.hexagonaldddexample.customers.application;

import com.hornosg.hexagonaldddexample.customers.domain.Customer;
import com.hornosg.hexagonaldddexample.customers.domain.CustomerFinder;
import com.hornosg.hexagonaldddexample.customers.domain.CustomerRepository;
import com.hornosg.hexagonaldddexample.customers.domain.exceptions.CustomerDoesNotExistsException;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerId;

public class CustomerRemover {
    private final CustomerFinder finder;
    private final CustomerRepository repository;

    CustomerRemover(CustomerRepository repository){
        this.repository = repository;
        this.finder = new CustomerFinder(repository);
    }

    public void invoke(CustomerId id){
        Customer customer = finder.invoke(id);
        if (customer == null) {
            throw new CustomerDoesNotExistsException();
        }
        repository.delete(id);
    }

}
