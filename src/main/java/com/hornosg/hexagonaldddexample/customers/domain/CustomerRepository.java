package com.hornosg.hexagonaldddexample.customers.domain;

import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerId;

public interface CustomerRepository {
    void save(Customer customer);
    Customer find(CustomerId id);
    void delete(CustomerId id);
}
