package br.com.hellosol.hellosol.repository;

import br.com.hellosol.hellosol.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Long> {
}
