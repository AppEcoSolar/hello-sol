package br.com.hellosol.hellosol.repository;

import br.com.hellosol.hellosol.model.Empresa;
import br.com.hellosol.hellosol.model.Usina;
import br.com.hellosol.hellosol.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsinaRepository extends JpaRepository<Usina,Long> {

    Optional<Usina> findByCnpj(String cpfCnpj);
    Optional<Usina> findByEmpresaGestoraAndNomeContainsIgnoreCaseOrderByNome(Empresa empresa, String nome);
}
