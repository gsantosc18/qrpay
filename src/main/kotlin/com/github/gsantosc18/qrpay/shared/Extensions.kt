package com.github.gsantosc18.qrpay.shared

import java.math.BigDecimal
import java.math.RoundingMode

fun String.length(): String =
    this.length.toString().padStart(2, '0')

fun BigDecimal.length(): String =
    this.value().length()

fun BigDecimal.value(): String =
    this.setScale(2, RoundingMode.HALF_UP).toString()
