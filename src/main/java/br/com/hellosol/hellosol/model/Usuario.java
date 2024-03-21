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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuario tipoUsuario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_pessoa")
    private TipoPessoa tipoPessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private byte[] senha;

    @Column(name = "ds_endereco")
    private String endereco;

    @Column(name = "ds_complemento_endereco")
    private String complementoEndereco;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "no_municipio")
    private String municipio;

    @Column(name = "sg_uf")
    private String uf;

    @Column(name = "cep")
    private String cep;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

}
