package com.order.ecommerce.dto

// @NotNull not required as kotlin is already imposing the same.
data class OrderDto(

    val customerId: String,
    val subTotal: Double,
    val totalAmt: Double,
    val tax: Double,
    val shippingCharges: Double,
    val title: String,
    val shippingMode: String,

    var amount: Double,
    val paymentMode: String,

    val billingAddress: AddressDto,
    val shippingAddress: AddressDto,

    val orderItems: List<OrderItemDto>
)
