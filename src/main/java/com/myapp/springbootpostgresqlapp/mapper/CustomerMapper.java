package com.myapp.springbootpostgresqlapp.mapper;

import com.myapp.springbootpostgresqlapp.dto.CustomerDto;
import com.myapp.springbootpostgresqlapp.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerDto customerDto);
    CustomerDto toDto(Customer customer);
    List<CustomerDto> toDtoList(List<Customer> customerList);
}