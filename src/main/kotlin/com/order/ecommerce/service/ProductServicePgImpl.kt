package com.order.ecommerce.service

import com.order.ecommerce.aspect.Loggable
import com.order.ecommerce.dto.ProductDto
import com.order.ecommerce.exception.BadRequestException
import com.order.ecommerce.model.Product
import com.order.ecommerce.repository.ProductRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ProductServicePgImpl(private val productRepository: ProductRepository): ProductService {

    companion object {
        val log: Logger = LoggerFactory.getLogger(ProductService::class.java)
    }

    @Loggable
    override fun createProduct(productDto: ProductDto): ProductDto {
        log.info("Creating Product with productId {}", productDto.productId)
        // add validations layer before saving anything in the data store
        productDto.validate()
        return productRepository.save(productDto.toProductEntity()).toProductDto()

    }

    @Loggable
    override fun getProduct(productId: String): ProductDto {
        log.info("Get Product by productId {}", productId)
        return productRepository.findById(productId).orElseThrow().toProductDto()

    }

    @Loggable
    override fun listProducts(): List<ProductDto>{
        log.info("Listing all products")
        return productRepository.findAll().map { it.toProductDto()}
    }

    @Loggable
    override fun listProductsByTitle(title: String): List<ProductDto>{
        log.info("Listing all products")
        return productRepository.findProductByTitle(title).map { it.toProductDto()}
    }

    fun ProductDto.toProductEntity() = Product(
        productId = productId,
        sku = sku,
        title = title,
        description = description,
        price = price,
        createdAt = LocalDate.now(),
        orderItems = null
    )

}