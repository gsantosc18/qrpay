package com.github.gsantosc18.qrpay

import com.github.gsantosc18.qrpay.dto.PixDTO
import com.github.gsantosc18.qrpay.service.PixCodeService
import com.github.gsantosc18.qrpay.service.QRCodeService
import java.io.File
import java.math.BigDecimal
import javax.imageio.ImageIO


fun main() {
    val pixDTO = PixDTO(
        key = "example@email.com",
        merchantName = "John Doel",
        merchantCity = "Sao Paulo",
        amount = BigDecimal("5.55")
    )

    val code = PixCodeService.generate(pixDTO)
    val qrCode = QRCodeService.generate(code = code, width = 300, height = 300)
    println("QRCode:")
    ImageIO.write(qrCode, "png", File("qrcode.png"))
}
