package com.github.gsantosc18.qrpay.service

import java.awt.image.BufferedImage

interface QRCode {
    fun generate(code: String, width: Int, height: Int): BufferedImage
}