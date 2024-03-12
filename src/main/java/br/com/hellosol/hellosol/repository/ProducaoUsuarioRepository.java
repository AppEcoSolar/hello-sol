package br.com.hellosol.hellosol.repository;

import br.com.hellosol.hellosol.model.ProducaoUsina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducaoUsuarioRepository extends JpaRepository<ProducaoUsina,Long> {
}
