package com.hornosg.hexagonaldddexample.customers.application;

import com.hornosg.hexagonaldddexample.customers.domain.Customer;
import com.hornosg.hexagonaldddexample.customers.domain.CustomerRepository;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerId;

import java.util.Map;

public class FindCustomerHandler {
    private static final CustomerResponse customerResponse = new CustomerResponse();
    private final CustomerReader reader;

    public FindCustomerHandler(CustomerRepository repository){
        this.reader = new CustomerReader(repository);
    }

    public Map<String, String> invoke(FindCustomerQuery cmd)
    {
        Customer customer = reader.invoke(new CustomerId(cmd.id));

        return customerResponse.response(customer);
    }
}
