package com.github.gsantosc18.qrpay

import com.github.gsantosc18.qrpay.dto.PixDTO
import com.github.gsantosc18.qrpay.service.PixCodeService
import java.math.BigDecimal

fun main() {
    val pixDTO = PixDTO(
        key = "example@email.com",
        merchantName = "John Doel",
        merchantCity = "Sao Paulo",
        amount = BigDecimal("5.55")
    )

    val pixCode = PixCodeService.generate(pixDTO)
    println(pixCode)
}
