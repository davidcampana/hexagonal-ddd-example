package com.hornosg.hexagonaldddexample.customers.application;

import com.hornosg.hexagonaldddexample.customers.domain.Customer;
import com.hornosg.hexagonaldddexample.customers.domain.CustomerFinder;
import com.hornosg.hexagonaldddexample.customers.domain.CustomerRepository;
import com.hornosg.hexagonaldddexample.customers.domain.exceptions.CustomerDoesNotExistsException;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerId;

public class CustomerReader {
    private final CustomerFinder finder;

    CustomerReader(CustomerRepository repository){
        this.finder = new CustomerFinder(repository);
    }

    public Customer invoke(CustomerId id){
        Customer customer = finder.invoke(id);
        if (customer == null) {
            throw new CustomerDoesNotExistsException();
        }
        return customer;
    }

}
