package com.hornosg.hexagonaldddexample.customers.domain.vo;

import com.hornosg.hexagonaldddexample.customers.domain.exceptions.CustomerSurnameRequiredException;
import com.hornosg.hexagonaldddexample.shared.domain.vo.StringDomainNotNull;

public class CustomerSurname extends StringDomainNotNull {

    public CustomerSurname(String value) throws CustomerSurnameRequiredException
    {
        super(value);
    }
}
