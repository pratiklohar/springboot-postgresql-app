package com.project.app.springboot_postgresql_app.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long orderId;
    private Long customerId;
    private LocalDate orderDate;
}
