package com.myapp.springbootpostgresqlapp.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Integer orderId;
    private Integer customerId;
    private LocalDate orderDate;
}
