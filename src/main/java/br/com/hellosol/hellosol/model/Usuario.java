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
@Table(name = "TB_USUARIO", schema = "HELLOSOL")
public class Usuario implements Serializable {

    @Id
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuario tipoUsuario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_pessoa")
    private TipoPessoa tipoPessoa;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Column(name = "senha")
    private byte[] senha;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

}
