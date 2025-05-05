package com.myapp.springbootpostgresqlapp.dto;

import java.time.LocalDate;
import java.util.UUID;

public record OrderDto(
        UUID orderId,
        UUID customerId,
        LocalDate orderDate
) {
}
