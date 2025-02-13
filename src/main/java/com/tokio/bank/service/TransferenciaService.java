package com.tokio.bank.service;

import com.tokio.bank.excepion.TaxaInvalidaException;
import com.tokio.bank.model.Transferencia;
import com.tokio.bank.repository.TransferenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferenciaService {
    private final TransferenciaRepository repository;

    public Transferencia agendarTransferencia(Transferencia transferencia) {
        long dias = ChronoUnit.DAYS.between(LocalDate.now(), transferencia.getDataTransferencia());
        BigDecimal taxa = calcularTaxa(transferencia.getValor(), dias);
        transferencia.setTaxa(taxa);
        return repository.save(transferencia);
    }

    public List<Transferencia> listarAgendamentos() {
        return repository.findAll();
    }

    private BigDecimal calcularTaxa(BigDecimal valor, long dias) {
        if (dias == 0) return valor.multiply(BigDecimal.valueOf(0.025)).add(BigDecimal.valueOf(3));
        if (dias <= 10) return BigDecimal.valueOf(12);
        if (dias <= 20) return valor.multiply(BigDecimal.valueOf(0.082));
        if (dias <= 30) return valor.multiply(BigDecimal.valueOf(0.069));
        if (dias <= 40) return valor.multiply(BigDecimal.valueOf(0.047));
        if (dias <= 50) return valor.multiply(BigDecimal.valueOf(0.017));
        throw new TaxaInvalidaException("Taxa não aplicável para essa data de transferência");
    }
}
