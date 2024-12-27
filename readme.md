# QRPay

Biblioteca de geração de código de pix válido para pagamentos.

# Tecnologias

- Kotlin 1.9

# Dependência

```xml
<dependency>
    <artifactId>qrpay</artifactId>
    <groupId>com.github.gsantosc18</groupId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

# Modo de usar

```kotlin
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
```

## Referência

- [Documentação PIX - BACEN](https://www.bcb.gov.br/content/estabilidadefinanceira/pix/Regulamento_Pix/II_ManualdePadroesparaIniciacaodoPix.pdf)
- [Projeto de PIX - BACEN](https://github.com/bacen/pix-api)