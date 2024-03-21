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

    @Schema(description = "CNPJ da empresa", example = "45.998.757/0001-54")
    @NotBlank(message = "CNPJ não informado!")
    @CNPJ(message = "O CNPJ é inválido.")
    private String cnpj;

    @Schema(description = "Telefone da empresa", example = "(61) 99273-0004")
    @NotBlank(message = "O telefone não pode ser vazio.")
    @Size(min = 10, max = 15, message = "O telefone deve ter entre 10 e 15 caracteres.")
    @Pattern(regexp = "^(\\(?\\d{2}\\)?\\s?)?\\d{4,5}\\-\\d{4}$", message = "O formato do telefone é inválido.")
    private String telefone;

    @Schema(description = "Email da empresa", example = "gt@gmail.com")
    @NotBlank(message = "O email não pode ser vazio.")
    @Email(message = "O email é inválido.")
    private String email;

    @Schema(description = "Endereço", example = "QD 02 lt 1420 Bl B Apt 806")
    @Size(max = 100, message = "O tamanho da rua não pode ser maior que 100 caracteres.")
    @NotBlank(message = "O campo endereço não pode ser vazio.")
    private String endereco;

    @Schema(description = "Complemento", example = "Ed. Idealle")
    @Size(max = 50, message = "O tamanho do complemento não pode ser maior que 50 caracteres.")
    private String complementoEndereco;

    @Schema(description = "Bairro", example = "Gama")
    @Size(max = 50, message = "O tamanho do campo bairro não pode ser maior que 50 caracteres.")
    @NotBlank(message = "O campo cidade não pode ser vazia.")
    private String bairro;

    @Schema(description = "Município", example = "Brasília")
    @NotBlank(message = "O campo município não pode ser vazio.")
    @Size(max = 50, message = "O tamanho do campo município não pode ser maior que 50 caracteres.")
    private String municipio;

    @Schema(description = "Estado", example = "DF")
    @NotBlank(message = "O campo estado não pode ser vazio.")
    @Size(min = 2, max = 2, message = "O estado deve ter 2 caracteres.")
    private String uf;

    @Schema(description = "CEP", example = "72.445-020")
    @NotBlank(message = "O campo CEP não pode ser vazio.")
    @Size(max = 9, message = "O tamanho do campo CEP não pode ser maior que 9 caracteres.")
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$", message = "O formato do CEP é inválido.")
    private String cep;

    private LocalDate createdAt;
    private LocalDate updatedAt;

}
