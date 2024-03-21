package br.com.hellosol.hellosol.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsinaDTO implements Serializable {

    private Long id;
    private Long idUsuarioProprietario;
    private Long idEmpresa;
    private String nome;
    private String telefone;
    private String endereco;
    private String complementoEndereco;
    private String bairro;
    private String municipio;
    private String uf;
    private String cep;

}
