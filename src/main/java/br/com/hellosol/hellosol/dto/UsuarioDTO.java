package br.com.hellosol.hellosol.dto;

import br.com.hellosol.hellosol.model.Endereco;
import br.com.hellosol.hellosol.model.TipoPessoa;
import br.com.hellosol.hellosol.model.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO implements Serializable {

    private Long id;
    private Long idEmpresa;
    private Long idTipoUsuario;
    private Long idTipoPessoa;
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    private String senha;
    private String endereco;
    private String complementoEndereco;
    private String bairro;
    private String municipio;
    private String uf;
    private String cep;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

}
