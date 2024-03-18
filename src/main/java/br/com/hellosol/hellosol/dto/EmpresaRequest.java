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
@Schema(name = "Empresa")
public class EmpresaRequest implements Serializable {

    @Schema(hidden = true)
    private Long id;

    @Schema(description = "Nome da Empresa Gestora", example = "GT")
    @Size(max = 100, message = "O tamanho do nome não pode ser maior que 100 caracteres.")
    @NotBlank(message = "Nome da Empresa não informado!")
    private String nome;

    @Schema(description = "CPF ou CNPJ")
    @NotBlank(message = "CNPJ não informado!")
    @CNPJ(message = "O CNPJ é inválido.")
    private String cnpj;

    @NotBlank(message = "O telefone não pode ser vazio.")
    @Size(min = 10, max = 15, message = "O telefone deve ter entre 10 e 15 caracteres.")
    @Pattern(regexp = "^(\\(?\\d{2}\\)?\\s?)?\\d{4,5}\\-\\d{4}$", message = "O formato do telefone é inválido.")
    private String telefone;

    @NotBlank(message = "O email não pode ser vazio.")
    @Email(message = "O email é inválido.")
    private String email;

    @NotBlank(message = "A rua não pode ser vazia.")
    private String rua;

    @NotBlank(message = "O número não pode ser vazio.")
    private String numero;

    private String complemento;

    @NotBlank(message = "A cidade não pode ser vazia.")
    private String cidade;

    @NotBlank(message = "O estado não pode ser vazio.")
    @Size(min = 2, max = 2, message = "O estado deve ter 2 caracteres.")
    private String estado;

    @NotBlank(message = "O CEP não pode ser vazio.")
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$", message = "O formato do CEP é inválido.")
    private String cep;

    @NotBlank(message = "O país não pode ser vazio.")
    private String pais;


}
