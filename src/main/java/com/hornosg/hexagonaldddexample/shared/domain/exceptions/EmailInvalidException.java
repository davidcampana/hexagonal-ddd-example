package com.hornosg.hexagonaldddexample.shared.domain.exceptions;

public class EmailInvalidException extends IllegalArgumentException
{
    public static final String ERROR_MESSAGE = "Email is invalid";

    public EmailInvalidException(){
        super(ERROR_MESSAGE);
    }
}
