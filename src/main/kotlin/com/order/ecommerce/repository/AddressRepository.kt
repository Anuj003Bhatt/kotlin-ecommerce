package com.order.ecommerce.repository

import com.order.ecommerce.model.Address
import org.springframework.data.repository.CrudRepository

interface AddressRepository : CrudRepository<Address, String> {
}
