package br.com.hellosol.hellosol.service;

import br.com.hellosol.hellosol.dto.EmpresaDTO;
import br.com.hellosol.hellosol.dto.EmpresaRequest;
import br.com.hellosol.hellosol.dto.UsuarioDTO;
import br.com.hellosol.hellosol.dto.UsuarioRequest;

import java.util.List;

public interface UsuarioService {

    void criarUsuario(UsuarioRequest usuarioRequest);

    List<UsuarioDTO> listarUsuarios(String cpfCnpjNome, String nome);

    UsuarioDTO findById(Long id);

    void alterarUsuario(UsuarioRequest usuarioRequest);

    void excluirUsuario(Long id);

}