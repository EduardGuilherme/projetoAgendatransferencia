package br.com.exchange.trasferencia.Controller;

import br.com.exchange.trasferencia.Models.Transfer;
import br.com.exchange.trasferencia.Services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/transferencias")
public class TransferController {
    @Autowired
    private TransferService transferService;

    @PostMapping
    public ResponseEntity<?> agendarTransferencia(@RequestBody Transfer transfer) {
        try {
            Transfer agendada = transferService.agendarTransferencia(transfer);
            return ResponseEntity.ok(agendada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Transfer> listarTransferencias() {
        return transferService.listarTransferencias();
    }
}
