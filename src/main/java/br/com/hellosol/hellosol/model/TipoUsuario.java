package br.com.hellosol.hellosol.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_TIPO_USUARIO", schema = "HELLOSOL")
public class TipoUsuario implements Serializable {

    @Id
    @Column(name = "id_tipo_usuario")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

}
