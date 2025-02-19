package br.com.exchange.trasferencia.Repository;

import br.com.exchange.trasferencia.Models.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer,String> {
}
