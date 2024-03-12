package br.com.hellosol.hellosol.dto;

import br.com.hellosol.hellosol.model.Endereco;
import br.com.hellosol.hellosol.model.TipoPessoa;
import br.com.hellosol.hellosol.model.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioRequest implements Serializable {

    private Long id;
    private String nome;
    private String cpfCnpj;
    private TipoUsuario tipoUsuario;
    private TipoPessoa tipoPessoa;
    private String email;
    private Endereco endereco;
    private byte[] senha;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

}
