package com.order.ecommerce.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.order.ecommerce.exception.BadRequestException
import java.time.LocalDate

data class ProductDto(
    val productId: String,
    val sku: String,
    val title: String,
    val description: String,
    val price: Double,
    @JsonIgnore
    val createdAt: LocalDate = LocalDate.now(),
    @JsonIgnore
    val productOrders: List<ProductOrderDto>? = null
) {
    fun validate() {
        if (productId.isBlank()) {
            throw BadRequestException("Invalid payload for product. ID cannot be blank")
        }
        if (title.isBlank()) {
            throw BadRequestException("Invalid payload for product. title cannot be blank")
        }

        if (price <= 0) {
            throw BadRequestException("Invalid payload for product. Price must be greater than 0")
        }
    }
}
