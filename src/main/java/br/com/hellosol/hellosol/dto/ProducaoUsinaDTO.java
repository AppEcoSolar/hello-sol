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

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProducaoUsinaDTO {

    private Integer id;
    private Usina usina;
    private LocalDate dtProducao;
    private BigDecimal qtdProducao;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
