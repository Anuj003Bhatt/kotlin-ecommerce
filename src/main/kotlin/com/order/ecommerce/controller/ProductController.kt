package com.order.ecommerce.controller

import com.order.ecommerce.aspect.Loggable
import com.order.ecommerce.dto.ProductDto
import com.order.ecommerce.model.Product
import com.order.ecommerce.service.ProductService
import io.swagger.v3.oas.annotations.Operation
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
class ProductController(private val productService: ProductService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a product", description = "Create a product")
    @Loggable
    fun createOrder(@RequestBody productDto: ProductDto): ProductDto {
        return productService.createProduct(productDto)
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Update a product information", description = "Update a product information")
    @Loggable
    fun updateProduct(@RequestBody productDto: ProductDto){

    }

    @GetMapping("/{productId}")
    @Operation(summary = "Get a product", description = "Get a product")
    @Loggable
    fun getProduct(@PathVariable(name = "productId") productId: String): ProductDto {
        return productService.getProduct(productId)
    }

    @GetMapping
    @Loggable
    @Operation(summary = "Get list of products", description = "Get list of products")
    fun listProducts(@RequestParam(value = "title", required = false) title: String?): List<ProductDto> {
        return if (title?.isBlank() != true) {
            productService.listProducts()
        } else {
            productService.listProductsByTitle(title)
        }
    }

}
