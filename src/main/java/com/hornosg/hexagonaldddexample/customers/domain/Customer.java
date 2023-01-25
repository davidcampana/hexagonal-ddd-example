package com.hornosg.hexagonaldddexample.customers.domain;

import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerAddress;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerEmail;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerId;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerName;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerPhone;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerSurname;

public class
Customer {
    private CustomerId id;
    private CustomerName name;
    private CustomerSurname surname;
    private CustomerEmail email;
    private CustomerAddress address;
    private CustomerPhone phone;

    public Customer(
            CustomerId id,
            CustomerName name,
            CustomerSurname surname,
            CustomerEmail email,
            CustomerAddress address,
            CustomerPhone phone
    ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public CustomerId getId() {
        return id;
    }

    public CustomerName getName() {
        return name;
    }

    public CustomerSurname getSurname() {
        return surname;
    }

    public CustomerEmail getEmail() {
        return email;
    }

    public CustomerAddress getAddress() {
        return address;
    }

    public CustomerPhone getPhone() {
        return phone;
    }

}
