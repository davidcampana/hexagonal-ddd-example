package com.hornosg.hexagonaldddexample.shared.domain.exceptions;

public class DomainNotFoundException extends RuntimeException {
    public DomainNotFoundException(String error_message){
        super(error_message);
    }
}
