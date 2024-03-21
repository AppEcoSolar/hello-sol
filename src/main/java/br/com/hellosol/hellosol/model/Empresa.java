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
@Table(name = "TB_EMPRESA", schema = "HELLOSOL")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

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
