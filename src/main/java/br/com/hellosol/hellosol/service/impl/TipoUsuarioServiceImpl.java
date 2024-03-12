package br.com.hellosol.hellosol.service.impl;

import br.com.hellosol.hellosol.dto.TipoUsuarioDTO;
import br.com.hellosol.hellosol.exception.InternalServerErrorException;
import br.com.hellosol.hellosol.model.TipoUsuario;
import br.com.hellosol.hellosol.repository.TipoUsuarioRepository;
import br.com.hellosol.hellosol.service.TipoUsuarioService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public List<TipoUsuarioDTO> listarTipoUsuario() {

        List<TipoUsuario> listaTipoUsuario = null;
        try {
            listaTipoUsuario = tipoUsuarioRepository.findAll();
        }catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Ocorreu um erro ao consultar os Tipos de Usuário");
        }
        return listaTipoUsuario.stream().map(p -> mapper.map(p, TipoUsuarioDTO.class))
                .collect(Collectors.toList());
    }
}