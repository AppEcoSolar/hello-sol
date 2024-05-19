package br.com.hellosol.hellosol.dto;

import br.com.hellosol.hellosol.model.Empresa;
import br.com.hellosol.hellosol.model.TipoPessoa;
import br.com.hellosol.hellosol.model.TipoUsuario;
import br.com.hellosol.hellosol.model.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioSemSenhaDTO implements Serializable {

    private Long id;
    private Empresa empresa;
    private TipoUsuario tipoUsuario;
    private TipoPessoa tipoPessoa;
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    private String endereco;
    private String complementoEndereco;
    private String bairro;
    private String municipio;
    private String uf;
    private String cep;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

    public UsuarioSemSenhaDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.empresa = usuario.getEmpresa();
        this.tipoUsuario = usuario.getTipoUsuario();
        this.tipoPessoa = usuario.getTipoPessoa();
        this.nome = usuario.getNome();
        this.cnpj = usuario.getCpfCnpj();
        this.telefone = usuario.getTelefone();
        this.email = usuario.getEmail();
        this.endereco = usuario.getEndereco();
        this.complementoEndereco = usuario.getComplementoEndereco();
        this.bairro = usuario.getBairro();
        this.municipio = usuario.getMunicipio();
        this.uf = usuario.getUf();
        this.cep = usuario.getCep();
        this.createdAt = usuario.getCreatedAt();
        this.updatedAt = usuario.getUpdatedAt();
        this.deletedAt = usuario.getDeletedAt();
    }
}
