package com.hornosg.hexagonaldddexample.customers.domain.exceptions;

import com.hornosg.hexagonaldddexample.shared.domain.exceptions.DomainNotFoundException;

public class CustomerDoesNotExistsException extends DomainNotFoundException
{
    public static final String ERROR_MESSAGE = "The Customer does not exists";

    public CustomerDoesNotExistsException(){
        super(ERROR_MESSAGE);
    }
}
