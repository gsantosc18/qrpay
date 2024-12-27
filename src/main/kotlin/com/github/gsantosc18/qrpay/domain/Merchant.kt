package com.github.gsantosc18.qrpay.domain

data class Merchant(
    val key: String,
    val name: String,
    val city: String
) {
    init {
        if (key.length > MAX_SIZE) {
            throw IllegalArgumentException("Key not be great than 25")
        }

        if (name.length > MAX_SIZE) {
            throw IllegalArgumentException("Name not be great than 25")
        }
    }

    companion object {
        private const val MAX_SIZE = 25
    }
}
