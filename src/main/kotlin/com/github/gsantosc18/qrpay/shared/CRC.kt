package com.github.gsantosc18.qrpay.shared

import java.util.Locale

object CRC {
    fun calculate(value: String): String {
        val polynomial = 0x1021
        var result = 0xFFFF
        for (b in value.toByteArray()) {
            for (i in 0..7) {
                val bit = b.toInt() shr 7 - i and 1 == 1
                val c15 = result shr 15 and 1 == 1
                result = result shl 1
                if (c15 xor bit) {
                    result = result xor polynomial
                }
            }
        }
        result = result and 0xffff
        return esc(Integer.toHexString(result).uppercase(Locale.getDefault()))
    }

    private fun esc(valor: String?): String {
        val valorBuilder = StringBuilder(valor)
        while (valorBuilder.length < 4) {
            valorBuilder.insert(0, "0")
        }
        return valorBuilder.toString()
    }
}