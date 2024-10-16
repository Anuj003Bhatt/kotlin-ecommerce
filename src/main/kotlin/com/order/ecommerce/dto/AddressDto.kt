package com.order.ecommerce.dto

import lombok.NonNull

data class AddressDto(

    @NonNull val address1: String,
    @NonNull val address2: String,
    @NonNull val city: String,
    @NonNull val state: String,
    @NonNull val zip: String,
    @NonNull val email: String,
    @NonNull val phone: String

)
