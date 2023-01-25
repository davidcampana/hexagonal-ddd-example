package com.hornosg.hexagonaldddexample.shared.domain.vo;

public class StringDomainNotNull extends StringDomain{

    public StringDomainNotNull(String value)
    {
        super(value);
        if (isNull(value)){
            throw new NullPointerException();
        }
    }

    private Boolean isNull(String value){
        return value.isBlank() && value.isEmpty();
    }
}
