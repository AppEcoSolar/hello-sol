package br.com.hellosol.hellosol.repository;

import br.com.hellosol.hellosol.model.TipoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPessoaRepository extends JpaRepository<TipoPessoa,Long> {
}
