package br.com.hellosol.hellosol.dto;

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
public class UsinaDTO implements Serializable {

    private Long id;
    private UsuarioDTO usuarioProprietário;
    private EmpresaDTO empresaGestora;
    private String cnpj;
    private String nome;
    private String telefone;
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
