package com.order.ecommerce.exception

import com.order.ecommerce.aspect.Loggable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ServiceExceptionHandler {

    @ExceptionHandler(BadRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Loggable
    fun productControllerExceptionHandler(exception: BadRequestException): ResponseEntity<Map<String, String>> {
        return ResponseEntity<Map<String, String>>(mapOf("error" to exception.message), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(NoSuchElementException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun noEntityFound(exception: NoSuchElementException): ResponseEntity<Map<String, String>> {
        return ResponseEntity<Map<String, String>>(mapOf("error" to "Entity not found"), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun noEntityFound(exception: IllegalArgumentException): ResponseEntity<Map<String, String>> {
        return ResponseEntity<Map<String, String>>(mapOf("error" to "Invalid Id in input"), HttpStatus.BAD_REQUEST)
    }
}