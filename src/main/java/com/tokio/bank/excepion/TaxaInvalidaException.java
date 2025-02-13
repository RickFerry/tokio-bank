package com.tokio.bank.excepion;

public class TaxaInvalidaException extends RuntimeException {
    public TaxaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
