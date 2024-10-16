package com.order.ecommerce.service

import com.order.ecommerce.dto.OrderCreateResponse
import com.order.ecommerce.dto.OrderDto
import com.order.ecommerce.model.Order

/**
 * This is an interface segregation so that the application can have extensibility across multiple data source.
 * This can be very useful in large scale applications as well as where data migrations are required.
 */
interface OrderService {
    fun updateOrderStatus(orderId: String, orderStatus: String)
    fun findOrderById(orderId: String): Order
    fun createOrder(orderDto: OrderDto): OrderCreateResponse
    fun getAllOrders(): List<Order>
}
