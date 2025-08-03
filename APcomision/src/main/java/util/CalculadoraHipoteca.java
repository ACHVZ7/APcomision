package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraHipoteca {
    public static BigDecimal calcularCuota(BigDecimal capital, double interesAnual, int años) {
        BigDecimal interesMensual = BigDecimal.valueOf(interesAnual / 100 / 12);
        BigDecimal numeroPagos = BigDecimal.valueOf(años * 12);

        BigDecimal potencia = BigDecimal.ONE.add(interesMensual).pow(numeroPagos.intValue());
        return capital.multiply(interesMensual.multiply(potencia))
                .divide(potencia.subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);
    }
}