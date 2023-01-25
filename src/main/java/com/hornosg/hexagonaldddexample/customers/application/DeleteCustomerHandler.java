package com.hornosg.hexagonaldddexample.customers.application;

import com.hornosg.hexagonaldddexample.customers.domain.CustomerRepository;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerId;

public class DeleteCustomerHandler {
    private final CustomerRemover remover;

    public DeleteCustomerHandler(CustomerRepository repository){
        this.remover = new CustomerRemover(repository);
    }

    public void invoke(DeleteCustomerCommand cmd)
    {
        CustomerId id = new CustomerId(cmd.id);
        remover.invoke(id);
    }
}
