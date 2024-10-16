package com.order.ecommerce.controller

import com.order.ecommerce.aspect.Loggable
import com.order.ecommerce.dto.OrderCreateResponse
import com.order.ecommerce.dto.OrderDto
import com.order.ecommerce.model.Order
import com.order.ecommerce.service.OrderService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/orders")
// orders should be at the top, as all the services belong to orders resource, this would modularize the code better.
class OrderController(private val orderService: OrderService) {

    @PostMapping
    @Operation(summary = "Create an order", description = "Create an order")
    @Loggable
    fun createOrder(@RequestBody orderDto: OrderDto): OrderCreateResponse {
        return orderService.createOrder(orderDto)
    }

    @GetMapping("{orderId}")
    @Loggable
    @Operation(summary = "Get order by id", description = "Get order by id")
    fun findOrderById(@PathVariable(name = "orderId") orderId: String): Order {
        orderId.let { UUID.fromString(orderId) }
        return orderService.findOrderById(orderId)
    }

    @GetMapping
    @Loggable
    @Operation(summary = "Get order by id", description = "Get order by id")
    fun listAllOrders(): List<Order> {
        return orderService.getAllOrders()
    }

    @PatchMapping("{orderId}")
    @Loggable
    @Operation(summary = "Update status of order", description = "Update the status of an order")
    fun updateOrderStatus(
        @PathVariable("orderId") orderId: String,
        @RequestParam(name = "orderStatus") orderStatus: String
    ) {
        orderService.updateOrderStatus(orderId, orderStatus)
    }
}
