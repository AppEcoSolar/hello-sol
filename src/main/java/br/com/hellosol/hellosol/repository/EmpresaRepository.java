package br.com.hellosol.hellosol.repository;

import br.com.hellosol.hellosol.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {

    Optional<Empresa> findByCnpj(String cnpj);

    @Query("SELECT e FROM Empresa e WHERE (:cnpj IS NULL OR e.cnpj LIKE %:cnpj%) AND (:nome IS NULL OR e.nome LIKE %:nome%) AND e.deletedAt IS NULL ORDER BY e.nome")
    List<Empresa> findByCnpjOrNomeOrderByNome(@Param("cnpj") String cnpj, @Param("nome") String nome);
}
