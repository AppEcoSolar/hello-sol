package br.com.hellosol.hellosol.dto;

import br.com.hellosol.hellosol.model.Usina;
import br.com.hellosol.hellosol.model.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
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
public class ConsumoClienteDTO {

    private Integer id;
    private Usuario usuario;
    private Usina usina;
    private LocalDate dtConsumo;
    private BigDecimal qtdConsumoKw;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;
}
