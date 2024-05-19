package br.com.hellosol.hellosol.service;

import br.com.hellosol.hellosol.dto.UsuarioDTO;
import br.com.hellosol.hellosol.dto.UsuarioRequest;
import br.com.hellosol.hellosol.dto.UsuarioSemSenhaDTO;

import java.util.List;

public interface UsuarioService {

    void criarUsuario(UsuarioRequest usuarioRequest);

    List<UsuarioDTO> listarUsuarios(String cpfCnpjNome, String nome);

    UsuarioSemSenhaDTO consultarUsuario(String cpfCnpj);

    UsuarioDTO findById(Long id);

    void alterarUsuario(UsuarioRequest usuarioRequest);

    void excluirUsuario(Long id);

}