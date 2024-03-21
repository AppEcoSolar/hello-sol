package br.com.hellosol.hellosol.service;

import br.com.hellosol.hellosol.dto.UsinaDTO;
import br.com.hellosol.hellosol.dto.UsinaRequest;
import br.com.hellosol.hellosol.dto.UsuarioDTO;
import br.com.hellosol.hellosol.dto.UsuarioRequest;

import java.util.List;

public interface UsinaService {

    void criarUsina(UsinaRequest usinaRequest);

    List<UsinaDTO> listarUsinas(Long idEmpresa, String nome);

    UsinaDTO findById(Long id);

    void alterarUsina(UsinaRequest usinaRequest);

    void excluirUsina(Long id);

}