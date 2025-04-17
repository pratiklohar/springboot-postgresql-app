package com.project.app.springboot_postgresql_app.mapper;

import com.project.app.springboot_postgresql_app.dto.CustomerDto;
import com.project.app.springboot_postgresql_app.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerDto customerDto);
    CustomerDto toDto(Customer customer);
    List<CustomerDto> toDtoList(List<Customer> customerList);
}