package com.order.ecommerce.model

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "ecommerce_product")
class Product(

    @Id
    @Column(name = "product_id", nullable = false, unique = true) var productId: String,

    @Column(name = "sku", nullable = false) var sku: String,

    @Column(name = "title", nullable = false) var title: String,

    @Column(name = "description", nullable = false) var description: String,

    @Column(name = "price", nullable = false) var price: Double,

    @Column(name = "createdAt", nullable = false) var createdAt: LocalDate,

    @OneToMany(targetEntity = OrderItem::class, fetch = FetchType.LAZY, mappedBy = "product")
    private var orderItems: List<OrderItem>?

) : Serializable
