package com.myapp.springbootpostgresqlapp.dto;

import java.time.LocalDate;

public record OrderDto(
        Integer orderId,
        Integer customerId,
        LocalDate orderDate
) {
}
