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
@Table(name = "TB_GERENCIAMENTO", schema = "HELLOSOL")
public class ConsumoCliente implements Serializable {

    @Id
    @Column(name = "id_consumo")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usina")
    private Usina usina;

    @Column(name = "dt_consumo")
    private LocalDate dtConsumo;

    @Column(name = "qtd_consumo_kw")
    private BigDecimal qtdConsumoKw;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

}
