package br.com.hellosol.hellosol.repository;

import br.com.hellosol.hellosol.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByCpfCnpj(String cpfCnpj);

    @Query("SELECT u FROM Usuario u WHERE (:cpfCnpj IS NULL OR u.cpfCnpj LIKE %:cpfCnpj%) AND (:nome IS NULL OR u.nome LIKE %:nome%) AND u.deletedAt IS NULL ORDER BY u.nome")
    List<Usuario> findByCpfCnpjOrNomeOrderByNome(@Param("cpfCnpj") String cpfCnpj, @Param("nome") String nome);

}
