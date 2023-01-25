package com.hornosg.hexagonaldddexample.customers.domain.vo;

import com.hornosg.hexagonaldddexample.customers.domain.exceptions.CustomerNameRequiredException;
import com.hornosg.hexagonaldddexample.shared.domain.vo.StringDomainNotNull;

public class CustomerName extends StringDomainNotNull {
    public CustomerName(String value) throws CustomerNameRequiredException
    {
        super(value);
    }
}
