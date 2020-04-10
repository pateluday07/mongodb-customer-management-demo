package com.mongodb.demo.service;

import com.mongodb.demo.dto.CustomerDto;

import java.util.List;

/**
 * @author patel
 */
public interface CustomerService {

    CustomerDto save(CustomerDto customerDto);

    CustomerDto update(CustomerDto customerDto);

    CustomerDto getById(String id);

    List<CustomerDto> getAll();

    void deleteById(String id);

    List<CustomerDto> getByFirstName(String firstName);

    List<CustomerDto> getByLastName(String lastName);
}
