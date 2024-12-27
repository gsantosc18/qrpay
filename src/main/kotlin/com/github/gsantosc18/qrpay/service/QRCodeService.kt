package com.github.gsantosc18.qrpay.service

import com.google.zxing.BarcodeFormat.QR_CODE
import com.google.zxing.client.j2se.MatrixToImageWriter.toBufferedImage
import com.google.zxing.qrcode.QRCodeWriter
import java.awt.image.BufferedImage

object QRCodeService: QRCode {
    override fun generate(code: String, width: Int, height: Int): BufferedImage {
        val bitMatrix = QRCodeWriter().encode(code, QR_CODE, width, height)
        return toBufferedImage(bitMatrix)
    }
}