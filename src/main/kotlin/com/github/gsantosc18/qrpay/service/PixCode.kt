package com.github.gsantosc18.qrpay.service

import com.github.gsantosc18.qrpay.dto.PixDTO

interface PixCode {
    fun generate(pixDTO: PixDTO): String
}
