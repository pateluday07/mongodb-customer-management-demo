package com.mongodb.demo.mapper;

import com.mongodb.demo.dto.CustomerDto;
import com.mongodb.demo.entity.Customer;
import org.mapstruct.Mapper;

/**
 * @author patel
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(Customer customer);

    Customer toEntity(CustomerDto customerDto);
}
