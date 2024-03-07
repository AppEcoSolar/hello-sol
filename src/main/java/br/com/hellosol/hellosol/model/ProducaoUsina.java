package br.com.hellosol.hellosol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_PRODUCAO_USINA", schema = "HELLOSOL")
public class ProducaoUsina implements Serializable {

    @Id
    @Column(name = "id_producao_usina")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usina")
    private Usina usina;

    @Column(name = "dt_producao")
    private LocalDate dtProducao;

    @Column(name = "qtd_producao")
    private BigDecimal qtdProducao;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

}
