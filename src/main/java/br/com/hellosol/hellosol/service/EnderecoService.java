package br.com.hellosol.hellosol.service;

import br.com.hellosol.hellosol.dto.EnderecoDTO;
import br.com.hellosol.hellosol.dto.EnderecoRequest;
import br.com.hellosol.hellosol.model.Endereco;

import java.util.List;

public interface EnderecoService {

    List<EnderecoDTO> listarEnderecoById(Integer id);

    Endereco salvarEndereco(EnderecoRequest enderecoRequest);

}