package com.github.gsantosc18.qrpay.service

import com.github.gsantosc18.qrpay.domain.Merchant
import com.github.gsantosc18.qrpay.domain.Transaction
import com.github.gsantosc18.qrpay.dto.PixDTO
import com.github.gsantosc18.qrpay.shared.ADDITIONAL_CONTENT
import com.github.gsantosc18.qrpay.shared.COUNTRY_CONTENT
import com.github.gsantosc18.qrpay.shared.CRC
import com.github.gsantosc18.qrpay.shared.CRC16_ID
import com.github.gsantosc18.qrpay.shared.CRC16_LENGTH
import com.github.gsantosc18.qrpay.shared.MERCHANT_ACCOUNT_GUI_CONTENT
import com.github.gsantosc18.qrpay.shared.MERCHANT_ACCOUNT_INFORMATION_ID
import com.github.gsantosc18.qrpay.shared.MERCHANT_ACCOUNT_INFORMATION_KEY_ID
import com.github.gsantosc18.qrpay.shared.MERCHANT_CATEGORY_CONTENT
import com.github.gsantosc18.qrpay.shared.MERCHANT_CITY_ID
import com.github.gsantosc18.qrpay.shared.MERCHANT_NAME_ID
import com.github.gsantosc18.qrpay.shared.PAYLOAD_FORMAT_CONTENT
import com.github.gsantosc18.qrpay.shared.TRANSACTION_AMOUNT_ID
import com.github.gsantosc18.qrpay.shared.TRANSACTION_CONTENT
import com.github.gsantosc18.qrpay.shared.length
import com.github.gsantosc18.qrpay.shared.value

object PixCodeService: PixCode {
    override fun generate(pixDTO: PixDTO): String {
        val merchant = Merchant(
            key = pixDTO.key,
            name = pixDTO.merchantName,
            city = pixDTO.merchantCity
        )
        val transaction = Transaction(pixDTO.amount)

        val merchantAccountContent = merchant.accountValue()
        val merchantInformationContent = merchant.merchantInformationValue()
        val transactionAmountContent = transaction.transactionAmountValue()

        val payload = """
            $PAYLOAD_FORMAT_CONTENT
            $MERCHANT_ACCOUNT_INFORMATION_ID${merchantAccountContent.length()}
            $merchantAccountContent
            $MERCHANT_CATEGORY_CONTENT
            $TRANSACTION_CONTENT
            $transactionAmountContent
            $COUNTRY_CONTENT
            $merchantInformationContent
            $ADDITIONAL_CONTENT
            $CRC16_ID$CRC16_LENGTH
        """.trimIndent()
            .replace("\n","")

        val crc = CRC.calculate(payload)

        return "$payload$crc"
    }

    private fun Merchant.accountValue(): String =
        "$MERCHANT_ACCOUNT_GUI_CONTENT$MERCHANT_ACCOUNT_INFORMATION_KEY_ID${key.length()}${key}"

    private fun Merchant.merchantInformationValue(): String =
        "$MERCHANT_NAME_ID${name.length()}$name$MERCHANT_CITY_ID${city.length()}$city"

    private fun Transaction.transactionAmountValue(): String =
        "$TRANSACTION_AMOUNT_ID${amount.length()}${amount.value()}"
}