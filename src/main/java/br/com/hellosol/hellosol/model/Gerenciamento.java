package br.com.hellosol.hellosol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_GERENCIAMENTO", schema = "HELLOSOL")
public class Gerenciamento implements Serializable {

    @Id
    @Column(name = "id_gerenciamento")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usina")
    private Usina usina;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "dt_inicio")
    private LocalDate dtInicio;

    @Column(name = "dt_fim")
    private LocalDate dtFim;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

}
