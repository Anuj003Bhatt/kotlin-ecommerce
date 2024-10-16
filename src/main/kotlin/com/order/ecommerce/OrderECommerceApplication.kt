package com.order.ecommerce

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
@EnableAspectJAutoProxy
class OrderECommerceApplication

fun main(args: Array<String>) {
    runApplication<OrderECommerceApplication>(*args)
}
