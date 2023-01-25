package com.hornosg.hexagonaldddexample.customers.application;

import com.hornosg.hexagonaldddexample.customers.domain.Customer;
import java.util.LinkedHashMap;

public class CustomerResponse {

    public LinkedHashMap<String, String> response(Customer customer)
    {

        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("id", customer.getId().getValue());
        response.put("name", customer.getName().getValue());
        response.put("surname", customer.getSurname().getValue());
        response.put("email", customer.getEmail().getValue());
        response.put("address", customer.getAddress() != null ?
                customer.getAddress().getValue() : null);
        response.put("phone", customer.getPhone() != null ?
                customer.getPhone().getValue() : null);

        return response;
    }
}
