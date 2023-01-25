package com.hornosg.hexagonaldddexample.customers.application;

public class NewCustomerCommand {
    public String tenantId;
    public String name;
    public String surname;
    public String email;
    public String address;
    public String phone;

    public NewCustomerCommand(
            String tenantId,
            String name,
            String surname,
            String email,
            String address,
            String phone) {
        this.tenantId = tenantId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
}
