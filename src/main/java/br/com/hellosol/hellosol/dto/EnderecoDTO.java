package br.com.hellosol.hellosol.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnderecoDTO {

    private Integer id;
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
