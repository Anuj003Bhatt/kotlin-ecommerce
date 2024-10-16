package com.order.ecommerce.dto

import lombok.NonNull

data class ProductDto(
    @NonNull val productId: String,
    @NonNull val sku: String,
    @NonNull val title: String,
    @NonNull val description: String,
    @NonNull val price: Double,
)
