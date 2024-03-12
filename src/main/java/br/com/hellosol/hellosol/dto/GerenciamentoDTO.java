package br.com.hellosol.hellosol.dto;

import br.com.hellosol.hellosol.model.Usina;
import br.com.hellosol.hellosol.model.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class GerenciamentoDTO {

    private Long id;
    private Usina usina;
    private Usuario usuario;
    private LocalDate dtInicio;
    private LocalDate dtFim;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;
}
