package com.myapp.springbootpostgresqlapp.dto;

import java.util.UUID;

public record OrderDetailDto(
        UUID orderDetailId,
        UUID orderId,
        UUID productId,
        Integer quantity
) {
}
