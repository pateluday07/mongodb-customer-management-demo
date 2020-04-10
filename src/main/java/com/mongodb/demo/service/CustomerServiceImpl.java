package com.mongodb.demo.service;

import com.mongodb.demo.dto.CustomerDto;
import com.mongodb.demo.entity.Customer;
import com.mongodb.demo.mapper.CustomerMapper;
import com.mongodb.demo.repository.CustomerRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author patel
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        if (StringUtils.isNotBlank(customerDto.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return customerMapper
                .toDto(customerRepository
                        .save(customerMapper.toEntity(customerDto)));
    }

    @Override
    public CustomerDto update(CustomerDto customerDto) {
        Optional<Customer> customer = customerRepository
                .findById(validateId(customerDto.getId()));
        if (customer.isPresent()) {
            return customerMapper.toDto(customerRepository
                    .save(customerMapper
                            .toEntity(customerDto)));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    public CustomerDto getById(String id) {
        return customerMapper.toDto(customerRepository
                .findById(validateId(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public List<CustomerDto> getAll() {
        return customerRepository
                .findAll()
                .stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        customerRepository
                .delete(customerRepository
                        .findById(validateId(id))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    private String validateId(String id) {
        if (StringUtils.isBlank(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return id.trim();
    }

    @Override
    public List<CustomerDto> getByFirstName(String firstName) {
        return customerRepository
                .findByFirstName(firstName)
                .stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getByLastName(String lastName) {
        return customerRepository
                .findByLastName(lastName)
                .stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }
}
