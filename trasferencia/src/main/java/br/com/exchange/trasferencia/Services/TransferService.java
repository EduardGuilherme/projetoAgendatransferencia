package br.com.exchange.trasferencia.Services;

import br.com.exchange.trasferencia.Models.Transfer;
import br.com.exchange.trasferencia.Repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
@Service
public class TransferService {
    @Autowired
    private TransferRepository transferRepository;

    public Transfer agendarTransferencia(Transfer transfer) {
        transfer.setDataAgendamento(LocalDate.now());
        BigDecimal taxaCalculada = calcularTaxa(transfer.getValorTransferencia(), transfer.getDataTransferencia());
        if(taxaCalculada == null) {
            throw new IllegalArgumentException("Não há taxa aplicável para a data de transferência informada.");
        }
        transfer.setTaxa(taxaCalculada);
        return transferRepository.save(transfer);
    }

    public List<Transfer> listarTransferencias() {
        return transferRepository.findAll();
    }

    private BigDecimal calcularTaxa(BigDecimal valor, LocalDate dataTransferencia) {
        long dias = ChronoUnit.DAYS.between(LocalDate.now(), dataTransferencia);


        if (dias == 0) {
            return BigDecimal.valueOf(3.00);
        } else if (dias >= 1 && dias <= 10) {

            return valor.multiply(BigDecimal.valueOf(0.025));
        } else if (dias >= 11 && dias <= 20) {
            return valor.multiply(BigDecimal.valueOf(0.082));
        } else if (dias >= 21 && dias <= 30) {
            return valor.multiply(BigDecimal.valueOf(0.069));
        } else if (dias >= 31 && dias <= 40) {
            return valor.multiply(BigDecimal.valueOf(0.047));
        } else if (dias >= 41 && dias <= 50) {
            return valor.multiply(BigDecimal.valueOf(0.017));
        } else {
            return null;
        }
    }
}

