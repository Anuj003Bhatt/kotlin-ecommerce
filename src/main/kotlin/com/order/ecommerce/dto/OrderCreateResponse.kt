package com.order.ecommerce.dto

import lombok.NonNull

data class OrderCreateResponse(
    @NonNull val orderId: String,
    @NonNull val orderStatus: String
)
