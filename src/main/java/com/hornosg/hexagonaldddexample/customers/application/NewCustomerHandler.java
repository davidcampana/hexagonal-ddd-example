package com.hornosg.hexagonaldddexample.customers.application;

import com.hornosg.hexagonaldddexample.customers.domain.Customer;
import com.hornosg.hexagonaldddexample.customers.domain.CustomerRepository;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerAddress;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerEmail;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerId;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerName;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerPhone;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerSurname;

public class NewCustomerHandler {
    private final CustomerCreator creator;

    public NewCustomerHandler(CustomerRepository repository){
        this.creator = new CustomerCreator(repository);
    }

    public void invoke(NewCustomerCommand cmd) {
        Customer customer;

        customer = new Customer(
            new CustomerId(),
            new CustomerName(cmd.name),
            new CustomerSurname(cmd.surname),
            new CustomerEmail(cmd.email),
            cmd.address != null ? new CustomerAddress(cmd.address) : null,
            cmd.phone != null ? new CustomerPhone(cmd.phone) : null
        );

        creator.invoke(customer);
    }
}
