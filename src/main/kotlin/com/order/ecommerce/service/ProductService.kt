package com.order.ecommerce.service

import com.order.ecommerce.dto.ProductDto
import com.order.ecommerce.model.Product

/**
 * This is to implement interface segregation.
 * The controller does not need to know about the direct internal implementations but
 * only the functionalities it exposes.
 *
 *
 * This is an interface segregation so that the application can have extensibility across multiple data source.
 * This can be very useful in large scale applications as well as where data migrations are required.
 */
interface ProductService {
    fun createProduct(productDto: ProductDto): ProductDto
    fun getProduct(productId: String): ProductDto
    fun listProducts(): List<ProductDto>
    fun listProductsByTitle(title: String): List<ProductDto>
}
