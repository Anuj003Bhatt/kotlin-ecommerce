package com.order.ecommerce.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.JoinPoint
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
@Aspect
class LoggingAspect {
    companion object {
        private val logger = LoggerFactory.getLogger(LoggingAspect::class.java)
    }

    @Pointcut("@annotation(Loggable)")
    fun executeLogging(){}

    @Before("executeLogging()")
    fun logMethodCall(jointPoint: JoinPoint) {
        val message = StringBuilder("Method: ")
        message.append(jointPoint.signature.name)
        val args = jointPoint.args
        if (args.isNotEmpty()) {
            message.append(" args [ | ")
                .append(args.joinToString { " | " })
                .append(" ]")
        }
        logger.info(message.toString())
    }

}