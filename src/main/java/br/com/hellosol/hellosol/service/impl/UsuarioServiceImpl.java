package br.com.hellosol.hellosol.service.impl;

import br.com.hellosol.hellosol.dto.UsuarioDTO;
import br.com.hellosol.hellosol.dto.UsuarioRequest;
import br.com.hellosol.hellosol.repository.UsuarioRepository;
import br.com.hellosol.hellosol.service.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper mapper;


    @Transactional
    @Override
    public void criarUsuario(UsuarioRequest usuarioRequest) {
//        padraoBoletoDTO.validarDadosBoleto();
//        String contaBeneficiario = padraoBoletoDTO.getContaBeneficiario();
//        Beneficiario beneficiario = beneficiarioService.buscarBeneficiarioPorConta(contaBeneficiario);
//        padraoBoletoDTO.setAtivo(true);
//        Optional<PadraoBoleto> padraoBoletoOptional = padraoBoletoRepository.findByNomeAndBeneficiario(padraoBoletoDTO.getNome().trim(), beneficiario);
//        if(padraoBoletoOptional.isPresent()) {
//            throw new BusinessException("Já existe um padrão de boleto com o nome " + padraoBoletoDTO.getNome()+". Favor informar outro nome.");
//        }
//        try {
//            padraoBoleto = padraoBoletoRepository.save(padraoBoleto);
//            historicoPadraoBoletoService.incluirHistoricoPadraoBoleto(padraoBoleto, usuarioId, TipoAcaoUsuario.I, LocalDateTime.now());
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new InternalServerErrorException("Erro ao inserir padrão de preenchimento de boleto.");
//        }
    }

    @Override
    public List<UsuarioDTO> listarUsuarios(String numeroContaBeneficiario, Integer codTipoPessoa,
                                           String cpfCnpjNome, String nome) {
        nome = Objects.isNull(nome) ? nome : nome.toUpperCase();
        return usuarioRepository.findAll().stream()
                .map(p -> mapper.map(p, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO findById(Long id) {
        return null;
    }

    @Override
    public void alterarUsuario(UsuarioRequest usuarioRequest) {

    }

}