# QRPay

Biblioteca de geração de código de pix válido para pagamentos.

# Tecnologias

- Kotlin 1.8

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
import java.math.BigDecimal

fun main() {
    val pixDTO = PixDTO(
        key = "example@email.com",
        merchantName = "John Doel",
        merchantCity = "Sao Paulo",
        amount = BigDecimal("5.55")
    )

    val pixCode = PixCodeService.generate(pixDTO)
    println(pixCode)
}
```

## Referência

- [Documentação PIX - BACEN](https://www.bcb.gov.br/content/estabilidadefinanceira/pix/Regulamento_Pix/II_ManualdePadroesparaIniciacaodoPix.pdf)
- [Projeto de PIX - BACEN](https://github.com/bacen/pix-api)