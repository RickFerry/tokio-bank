package com.tokio.bank.model.enums;

import java.math.BigDecimal;

public enum TaxaEnum {
    A(0, 0, new BigDecimal("3.00"), new BigDecimal("0.025")),
    B(1, 10, new BigDecimal("12.00"), BigDecimal.ZERO),
    C(11, 20, BigDecimal.ZERO, new BigDecimal("0.082")),
    D(21, 30, BigDecimal.ZERO, new BigDecimal("0.069")),
    E(31, 40, BigDecimal.ZERO, new BigDecimal("0.047")),
    F(41, 50, BigDecimal.ZERO, new BigDecimal("0.017"));

    private final int diasMin;
    private final int diasMax;
    private final BigDecimal taxaFixa;
    private final BigDecimal taxaPercentual;

    TaxaEnum(int diasMin, int diasMax, BigDecimal taxaFixa, BigDecimal taxaPercentual) {
        this.diasMin = diasMin;
        this.diasMax = diasMax;
        this.taxaFixa = taxaFixa;
        this.taxaPercentual = taxaPercentual;
    }
}
