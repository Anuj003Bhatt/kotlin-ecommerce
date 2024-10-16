package com.order.ecommerce.repository

import com.order.ecommerce.model.Payment
import org.springframework.data.repository.CrudRepository

interface PaymentRepository : CrudRepository<Payment, String> {
}
