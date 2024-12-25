package com.github.gsantosc18.qrpay.dto

import java.math.BigDecimal

data class PixDTO(
    val key: String,
    val amount: BigDecimal,
    val merchantName: String,
    val merchantCity: String
)
