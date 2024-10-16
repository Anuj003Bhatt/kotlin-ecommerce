package com.order.ecommerce.repository

import com.order.ecommerce.model.OrderItem
import com.order.ecommerce.model.OrderItemPk
import org.springframework.data.repository.CrudRepository

interface OrderItemRepository : CrudRepository<OrderItem, OrderItemPk> {
}
