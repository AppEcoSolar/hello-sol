package br.com.hellosol.hellosol.dto;

import br.com.hellosol.hellosol.model.Endereco;
import br.com.hellosol.hellosol.model.TipoPessoa;
import br.com.hellosol.hellosol.model.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class EmpresaDTO implements Serializable {

    private Long id;
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    private String rua;
    private String numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

}
