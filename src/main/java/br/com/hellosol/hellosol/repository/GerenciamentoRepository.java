package br.com.hellosol.hellosol.repository;

import br.com.hellosol.hellosol.model.Gerenciamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenciamentoRepository extends JpaRepository<Gerenciamento,Long> {
}
