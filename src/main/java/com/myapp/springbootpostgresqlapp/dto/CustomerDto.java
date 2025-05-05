package com.myapp.springbootpostgresqlapp.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CustomerDto(
        UUID customerId,
        @NotBlank(message = "First name is required")
        String firstName,
        @NotBlank(message = "Last name is required")
        String lastName,
        String address,
        String city,
        String postalCode,
        String country,
        String state,
        @NotBlank(message = "Mobile number is required")
        String mobileNumber
) {
}