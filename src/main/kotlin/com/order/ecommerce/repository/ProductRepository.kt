package com.order.ecommerce.repository

import com.order.ecommerce.model.Product
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, String> {
    @Query("FROM Product ep WHERE ep.title LIKE %:title%")
    fun findProductByTitle(title: String): Iterable<Product>
}
