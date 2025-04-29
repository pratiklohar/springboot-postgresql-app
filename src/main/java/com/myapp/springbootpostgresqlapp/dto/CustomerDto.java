package com.myapp.springbootpostgresqlapp.dto;

public record CustomerDto(
        Integer customerId,
        String customerName,
        String address,
        String city,
        String postalCode,
        String country,
        String state
) {
}