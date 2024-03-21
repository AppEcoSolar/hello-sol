package br.com.hellosol.hellosol.service.impl;

import br.com.hellosol.hellosol.dto.EmpresaDTO;
import br.com.hellosol.hellosol.dto.EmpresaRequest;
import br.com.hellosol.hellosol.dto.UsuarioDTO;
import br.com.hellosol.hellosol.dto.UsuarioRequest;
import br.com.hellosol.hellosol.exception.BusinessException;
import br.com.hellosol.hellosol.exception.InternalServerErrorException;
import br.com.hellosol.hellosol.exception.NotFoundException;
import br.com.hellosol.hellosol.model.Empresa;
import br.com.hellosol.hellosol.model.Usina;
import br.com.hellosol.hellosol.repository.EmpresaRepository;
import br.com.hellosol.hellosol.repository.UsuarioRepository;
import br.com.hellosol.hellosol.service.EmpresaService;
import br.com.hellosol.hellosol.service.UsuarioService;
import br.com.hellosol.hellosol.util.StringUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public List<EmpresaDTO> listarEmpresas(String cnpj, String nome) {
        nome = Objects.isNull(nome) ? nome : nome.toUpperCase();
        cnpj = Objects.isNull(cnpj) ? cnpj : StringUtil.somenteNumeros(cnpj);
        return empresaRepository.findByCnpjOrNomeOrderByNome(cnpj, nome).stream()
                .map(p -> mapper.map(p, EmpresaDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public EmpresaDTO buscarEmpresaById(Long id) {
        return mapper.map(empresaRepository.findById(id).orElseThrow(() -> new NotFoundException("Nenhuma Empresa encontrada!")), EmpresaDTO.class);
    }

    @Transactional
    @Override
    public void criarEmpresa(EmpresaRequest empresaRequest) {
        String cnpjApenasNumeros = StringUtil.somenteNumeros(empresaRequest.getCnpj());

        Optional<Empresa> empresaOptional = empresaRepository.findByCnpj(empresaRequest.getCnpj().trim());
        if (empresaOptional.isPresent()) {
            throw new BusinessException("Já existe uma empresa Registrada com esse CNPJ " + empresaRequest.getCnpj() + ".");
        }

        empresaRequest.setCnpj(cnpjApenasNumeros);
        empresaRequest.setCreatedAt(LocalDate.now());

        Empresa empresa = mapper.map(empresaRequest, Empresa.class);

        try {
            empresa = empresaRepository.save(empresa);
        } catch
        (Exception e) {
            e.printStackTrace();

            throw new InternalServerErrorException("Erro ao inserir a empresa gestora.");
        }
    }

    @Override
    public void alterarEmpresa(EmpresaRequest empresaRequest) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(empresaRequest.getId());

        Empresa empresa = empresaOptional.orElseThrow(() -> new NotFoundException("Empresa não encontrada para o ID: " + empresaRequest.getId()));

        if (!empresa.getCnpj().equals(empresaRequest.getCnpj())) {
            throw new BusinessException("O CNPJ da Empresa não pode ser alterado.");

        }

        empresaRequest.setUpdatedAt(LocalDate.now());

        empresa = mapper.map(empresaRequest, Empresa.class);
        try {
            empresa = empresaRepository.save(empresa);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Erro ao alterar a empresa.");
        }
    }
    @Override
    public void excluirEmpresa(Long empresaId) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(empresaId);
        Empresa empresa = empresaOptional.orElseThrow(() -> new NotFoundException("Empresa não encontrada!"));
        empresa.setDeletedAt(LocalDate.now());
        try {
            empresaRepository.save(empresa);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Erro ao excluir empresa.");
        }
    }


}