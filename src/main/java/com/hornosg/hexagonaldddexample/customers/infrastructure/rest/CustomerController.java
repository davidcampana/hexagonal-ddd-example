package com.hornosg.hexagonaldddexample.customers.infrastructure.rest;

import com.hornosg.hexagonaldddexample.customers.application.DeleteCustomerCommand;
import com.hornosg.hexagonaldddexample.customers.application.DeleteCustomerHandler;
import com.hornosg.hexagonaldddexample.customers.application.FindCustomerHandler;
import com.hornosg.hexagonaldddexample.customers.application.FindCustomerQuery;
import com.hornosg.hexagonaldddexample.customers.application.NewCustomerCommand;
import com.hornosg.hexagonaldddexample.customers.application.NewCustomerHandler;
import com.hornosg.hexagonaldddexample.customers.infrastructure.persistence.CustomerMongoRepository;
import com.hornosg.hexagonaldddexample.shared.infrastructure.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(BaseController.BASE_URI)
public class CustomerController extends BaseController
{
    private final CustomerMongoRepository repository = new CustomerMongoRepository();

    @PostMapping("/v1/customer")
    public ResponseEntity<Object> createCustomer(@RequestBody Map<String, Object> requestBody) {
        if (emptyBody(requestBody)){
            throw new IllegalArgumentException(MESSAGE_REQUEST_WITHOUT_BODY);
        };

        NewCustomerHandler handler = new NewCustomerHandler(repository);
        handler.invoke(
            new NewCustomerCommand(
                requestBody.get("tenantId") != null ? requestBody.get("tenantId").toString() : "",
                requestBody.get("name") != null ? requestBody.get("name").toString() : "",
                requestBody.get("surname") != null ? requestBody.get("surname").toString() : "",
                requestBody.get("email") != null ? requestBody.get("email").toString() : "",
                requestBody.get("address") != null ? requestBody.get("address").toString() : "",
                requestBody.get("phone") != null ? requestBody.get("phone").toString() :  ""
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/v1/customer/{id}")
    public ResponseEntity<Map> findCustomer(@PathVariable String id){
        FindCustomerHandler handler = new FindCustomerHandler(repository);
        Map<String, String> response = handler.invoke(new FindCustomerQuery(id));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/v1/customer/{id}")
    public ResponseEntity<Map> deleteCustomer(@PathVariable String id){
        DeleteCustomerHandler handler = new DeleteCustomerHandler(repository);
        handler.invoke(new DeleteCustomerCommand(id));

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}