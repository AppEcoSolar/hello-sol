package br.com.hellosol.hellosol.service.impl;

import br.com.hellosol.hellosol.dto.TipoPessoaDTO;
import br.com.hellosol.hellosol.exception.InternalServerErrorException;
import br.com.hellosol.hellosol.model.TipoPessoa;
import br.com.hellosol.hellosol.repository.TipoPessoaRepository;
import br.com.hellosol.hellosol.service.TipoPessoaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TipoPessoaServiceImpl implements TipoPessoaService {

    @Autowired
    private TipoPessoaRepository tipoPessoaRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public List<TipoPessoaDTO> listarTipoPessoa() {

        List<TipoPessoa> listaTipoPessoa = null;
        try {
            listaTipoPessoa = tipoPessoaRepository.findAll();
        }catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Ocorreu um erro ao consultar os Tipos de Pessoa");
        }
        return listaTipoPessoa.stream().map(p -> mapper.map(p, TipoPessoaDTO.class))
                .collect(Collectors.toList());
    }
}