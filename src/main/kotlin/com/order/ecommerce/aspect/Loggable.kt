package com.order.ecommerce.aspect

import java.lang.annotation.ElementType

@Target(AnnotationTarget.FUNCTION)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class Loggable