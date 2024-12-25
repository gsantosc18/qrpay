package com.github.gsantosc18.qrpay.service

import com.github.gsantosc18.qrpay.dto.PixDTO
import java.math.BigDecimal
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class PixCodeServiceTest {
    @Test
    fun `Generate pix code`() {
        val pixCodeTarget = "00020126390014br.gov.bcb.pix0117example@email.com52040000530398654045.555802BR5909John Doel6009Sao Paulo62070503***63046B05"
        val pixDTO = PixDTO(
            key = "example@email.com",
            amount = BigDecimal(5.55),
            merchantName = "John Doel",
            merchantCity = "Sao Paulo"
        )

        val pixCodeResult = PixCodeService.generate(pixDTO)
        assertEquals(pixCodeTarget, pixCodeResult)
    }
}