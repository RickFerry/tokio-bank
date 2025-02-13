package com.tokio.bank.service;

import com.tokio.bank.model.Transferencia;
import com.tokio.bank.model.enums.TaxaEnum;
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
        TaxaEnum taxaEnum = TaxaEnum.obterPorDias(dias);
        BigDecimal taxa = taxaEnum.calcularTaxa(transferencia.getValor());

        transferencia.setTaxa(taxa);
        return repository.save(transferencia);
    }

    public List<Transferencia> listarAgendamentos() {
        return repository.findAll();
    }
}
