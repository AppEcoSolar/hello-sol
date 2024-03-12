package br.com.hellosol.hellosol.repository;

import br.com.hellosol.hellosol.model.ConsumoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoClienteRepository extends JpaRepository<ConsumoCliente,Long> {
}
