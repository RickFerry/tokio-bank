package com.tokio.bank.model.enums;

import com.tokio.bank.excepion.TaxaInvalidaException;

import java.math.BigDecimal;
import java.util.Arrays;

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

    public BigDecimal calcularTaxa(BigDecimal valor) {
        return taxaFixa.add(valor.multiply(taxaPercentual));
    }

    public static TaxaEnum obterPorDias(long dias) {
        return Arrays.stream(values())
                .filter(taxa -> dias >= taxa.diasMin && dias <= taxa.diasMax)
                .findFirst()
                .orElseThrow(() -> new TaxaInvalidaException("Taxa não aplicável para essa data de transferência"));
    }
}