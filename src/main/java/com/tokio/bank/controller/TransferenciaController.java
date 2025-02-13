package com.tokio.bank.controller;

import com.tokio.bank.model.Transferencia;
import com.tokio.bank.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transferencias")
public class TransferenciaController {
    private final TransferenciaService service;

    @PostMapping
    public ResponseEntity<Transferencia> agendar(@RequestBody Transferencia transferencia) {
        return ResponseEntity.ok(service.agendarTransferencia(transferencia));
    }

    @GetMapping
    public ResponseEntity<List<Transferencia>> listar() {
        return ResponseEntity.ok(service.listarAgendamentos());
    }
}

