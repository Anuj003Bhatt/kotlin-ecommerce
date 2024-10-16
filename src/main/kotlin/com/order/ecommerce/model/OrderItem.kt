package com.order.ecommerce.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "ecommerce_order_item")
class OrderItem(

    @EmbeddedId
    private var orderItemPk: OrderItemPk,

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private var product: Product?,

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private var order: Order?,

    @Column(name = "quantity", nullable = false)
    private var quantity: String

) : Serializable
