package br.com.hellosol.hellosol.service.impl;

import br.com.hellosol.hellosol.dto.*;
import br.com.hellosol.hellosol.exception.BusinessException;
import br.com.hellosol.hellosol.exception.InternalServerErrorException;
import br.com.hellosol.hellosol.exception.NotFoundException;
import br.com.hellosol.hellosol.model.Empresa;
import br.com.hellosol.hellosol.model.Usina;
import br.com.hellosol.hellosol.model.Usuario;
import br.com.hellosol.hellosol.repository.UsinaRepository;
import br.com.hellosol.hellosol.repository.UsuarioRepository;
import br.com.hellosol.hellosol.service.UsinaService;
import br.com.hellosol.hellosol.service.UsuarioService;
import br.com.hellosol.hellosol.util.StringUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsinaServiceImpl implements UsinaService {

    @Autowired
    private UsinaRepository usinaRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<UsinaDTO> listarUsinas(Long idEmpresa, String nome) {
        Empresa empresa = new Empresa();
        empresa.setId(idEmpresa);
        nome = Objects.isNull(nome) ? nome : nome.toUpperCase();
        return usinaRepository.findByEmpresaGestoraAndNomeContainsIgnoreCaseOrderByNome(empresa, nome).stream()
                .map(p -> mapper.map(p, UsinaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsinaDTO findById(Long id) {
        return mapper.map(usinaRepository.findById(id).orElseThrow(() -> new NotFoundException("Nenhuma Usina encontrada!")), UsinaDTO.class);
    }

    @Transactional
    @Override
    public void criarUsina(UsinaRequest usinaRequest) {
        String cnpjApenasNumeros = StringUtil.somenteNumeros(usinaRequest.getCnpj());

        if(usinaRequest.getIdUsuarioProprietario() != null){
            usinaRequest.setUsuarioProprietario(new UsuarioDTO());
            usinaRequest.getUsuarioProprietario().setId(usinaRequest.getIdUsuarioProprietario());
        }

        if(usinaRequest.getIdEmpresa() != null){
            usinaRequest.setEmpresaGestora(new EmpresaDTO());
            usinaRequest.getEmpresaGestora().setId(usinaRequest.getIdEmpresa());
        }

        Optional<Usina> usinaOptional = usinaRepository.findByCnpj(cnpjApenasNumeros);
        if (usinaOptional.isPresent()) {
            throw new BusinessException("Já existe uma Usina cadastrada com esse CNPJ " + usinaRequest.getCnpj() + ".");
        }

        usinaRequest.setCnpj(cnpjApenasNumeros);
        usinaRequest.setCreatedAt(LocalDate.now());

        Usina usina = mapper.map(usinaRequest, Usina.class);

        try {
            usina = usinaRepository.save(usina);
        } catch
        (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Erro ao cadastrar Usina.");
        }
    }

    @Override
    public void alterarUsina(UsinaRequest usinaRequest) {
        Optional<Usina> usinaOptional = usinaRepository.findById(usinaRequest.getId());

        Usina usina = usinaOptional.orElseThrow(() -> new NotFoundException("Usina não encontrada para o ID: " + usinaRequest.getId()));

        if (!usina.getCnpj().equals(usinaRequest.getCnpj())) {
            throw new BusinessException("O CNPJ da Usina não pode ser alterado.");

        }

        usinaRequest.setUpdatedAt(LocalDate.now());

        usina = mapper.map(usinaRequest, Usina.class);

        try {
            usina = usinaRepository.save(usina);

        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Erro ao alterar a Usina.");
        }
    }
    @Override
    public void excluirUsina(Long usinaId) {
        Optional<Usina> usinaOptional = usinaRepository.findById(usinaId);
        Usina usina = usinaOptional.orElseThrow(() -> new NotFoundException("Usina não encontrada!"));
        usina.setDeletedAt(LocalDate.now());

        try {
            usinaRepository.save(usina);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Erro ao excluir a usina.");
        }
    }

}