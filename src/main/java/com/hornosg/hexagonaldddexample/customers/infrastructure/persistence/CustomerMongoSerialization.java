package com.hornosg.hexagonaldddexample.customers.infrastructure.persistence;

import com.hornosg.hexagonaldddexample.customers.domain.Customer;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerAddress;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerEmail;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerId;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerName;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerPhone;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerSurname;
import org.bson.Document;

public class CustomerMongoSerialization {

    public Document customerToDocument(Customer customer)
    {
        Document customerDocument = new Document("_id", customer.getId().getValue())
                .append("name", customer.getName().getValue())
                .append("surname", customer.getSurname().getValue())
                .append("email", customer.getEmail().getValue());

        if(customer.getAddress() != null){
            customerDocument.append("address", customer.getAddress().getValue());
        }

        if(customer.getPhone() != null){
            customerDocument.append("phone", customer.getPhone().getValue());
        }

        return customerDocument;
    }


    public Customer documentToCustomer(Document document)
    {
        return new Customer(
                new CustomerId(document.get("_id").toString()),
                new CustomerName(document.get("name").toString()),
                new CustomerSurname(document.get("surname").toString()),
                new CustomerEmail(document.get("email").toString()),
                document.get("address") != null ?
                    new CustomerAddress(document.get("address").toString()) : null,
                document.get("phone") != null ?
                    new CustomerPhone(document.get("phone").toString()) : null
        );
    }
}
