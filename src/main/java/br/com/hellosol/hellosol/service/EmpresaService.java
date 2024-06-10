package br.com.hellosol.hellosol.service;

import br.com.hellosol.hellosol.dto.EmpresaDTO;
import br.com.hellosol.hellosol.dto.EmpresaRequest;
import br.com.hellosol.hellosol.dto.UsuarioDTO;
import br.com.hellosol.hellosol.dto.UsuarioRequest;

import java.util.List;

public interface EmpresaService {

    void criarEmpresa(EmpresaRequest empresaRequest);

    List<EmpresaDTO> listarEmpresas(String cnpj, String nome);

    List<EmpresaDTO> buscarListEmpresaById(Long id);

    EmpresaDTO buscarEmpresaById(Long id);

    void alterarEmpresa(EmpresaRequest empresaRequest);

    void excluirEmpresa(Long id);
}