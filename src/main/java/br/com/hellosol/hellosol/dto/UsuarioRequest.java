package br.com.hellosol.hellosol.dto;

import br.com.hellosol.hellosol.util.validation.CpfCnpj;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
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

    @Schema(hidden = true)
    private Long id;

    @Schema (description = "Código da empresa",example ="1")
    @NotNull(message = "Código da empresa que será vinculada ao usuário!")
    private Long idEmpresa;

    @Schema (description = "Código do tipo de usuário",example ="1")
    @NotNull(message = "Código que identifica o tipo de usuário, Gestor, Cliente, Proprietário!")
    private Long idTipoUsuario;

    @Schema (description = "Código do tipo pessoa",example ="1")
    @NotNull(message = "Código do tipo de pessoa do usuário, PF ou PJ!")
    private Long idTipoPessoa;

    @Schema(description = "Nome do Usuário", example = "Joao da Silva")
    @Size(max = 100, message = "O tamanho do nome não pode ser maior que 100 caracteres.")
    @NotBlank(message = "Nome do Usuário não informado!")
    private String nome;

    @Schema(description = "CPF ou CNPJ", example = "713.176.941-04" )
    @NotBlank(message = "CPF ou CNPJ não informado!")
    @CpfCnpj(message = "O CPF ou CNPJ é inválido.")
    private String cpfCnpj;

    @Schema(description = "Telefone do usuário", example = "(61) 99273-0004")
    @NotBlank(message = "O telefone não pode ser vazio.")
    @Size(min = 10, max = 15, message = "O telefone deve ter entre 10 e 15 caracteres.")
    @Pattern(regexp = "^(\\(?\\d{2}\\)?\\s?)?\\d{4,5}\\-\\d{4}$", message = "O formato do telefone é inválido.")
    private String telefone;

    @Schema(description = "Email do Usuário", example = "gt@gmail.com")
    @NotBlank(message = "O email não pode ser vazio.")
    @Email(message = "O email é inválido.")
    private String email;

    @Schema(description = "Senha do Usuário", example = "@Teste0000")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
    message = "A senha deve ter entre 8 e 20 caracteres, incluir letras maiúsculas e minúsculas, números e símbolos especiais.")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres.")
    private String senha;

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

    @Schema(description = "CEP", example = "72445-020")
    @NotBlank(message = "O campo CEP não pode ser vazio.")
    @Size(max = 9, message = "O tamanho do campo CEP não pode ser maior que 9 caracteres.")
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$", message = "O formato do CEP é inválido.")
    private String cep;

    private LocalDate createdAt;
    private LocalDate updatedAt;

}
