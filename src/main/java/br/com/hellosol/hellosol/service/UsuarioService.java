package br.com.hellosol.hellosol.service;

import br.com.hellosol.hellosol.dto.UsuarioDTO;
import br.com.hellosol.hellosol.dto.UsuarioRequest;

import java.util.List;

public interface UsuarioService {

    void criarUsuario(UsuarioRequest usuarioRequest);
    List<UsuarioDTO> listarUsuarios(String numeroContaBeneficiario, Integer codTipoPessoa,
                                    String cpfCnpjNome, String nome);
    UsuarioDTO findById(Long id);
    void alterarUsuario(UsuarioRequest usuarioRequest);

}