package com.mongodb.demo.controller;

import com.mongodb.demo.dto.CustomerDto;
import com.mongodb.demo.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author patel
 */
@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public CustomerDto saveCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return customerService.save(customerDto);
    }

    @PutMapping("/customers")
    public CustomerDto updateCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return customerService.update(customerDto);
    }

    @GetMapping("/customers/{id}")
    public CustomerDto getCustomerById(@PathVariable String id) {
        return customerService.getById(id);
    }

    @GetMapping("/customers")
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAll();
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        customerService.deleteById(id);
        return ResponseEntity.ok("Customer Deleted");
    }

    @GetMapping("/customers/first-name/{firstName}")
    public List<CustomerDto> getCustomerByFirstName(@PathVariable String firstName) {
        return customerService.getByFirstName(firstName);
    }

    @GetMapping("/customers/last-name/{lastName}")
    public List<CustomerDto> getCustomerByLastName(@PathVariable String lastName) {
        return customerService.getByLastName(lastName);
    }

}
