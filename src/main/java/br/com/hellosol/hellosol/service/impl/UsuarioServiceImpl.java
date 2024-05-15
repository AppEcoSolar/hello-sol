package br.com.hellosol.hellosol.service.impl;

import br.com.hellosol.hellosol.dto.EmpresaDTO;
import br.com.hellosol.hellosol.dto.EmpresaRequest;
import br.com.hellosol.hellosol.dto.UsuarioDTO;
import br.com.hellosol.hellosol.dto.UsuarioRequest;
import br.com.hellosol.hellosol.exception.BusinessException;
import br.com.hellosol.hellosol.exception.InternalServerErrorException;
import br.com.hellosol.hellosol.exception.NotFoundException;
import br.com.hellosol.hellosol.model.Empresa;
import br.com.hellosol.hellosol.model.Usuario;
import br.com.hellosol.hellosol.repository.UsuarioRepository;
import br.com.hellosol.hellosol.service.UsuarioService;
import br.com.hellosol.hellosol.util.StringUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UsuarioDTO> listarUsuarios(String cpfCnpjNome, String nome) {
        nome = Objects.isNull(nome) ? nome : nome.toUpperCase();
        return usuarioRepository.findByCpfCnpjOrNomeOrderByNome(cpfCnpjNome, nome).stream()
                .map(p -> mapper.map(p, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO findById(Long id) {
        return mapper.map(usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Nenhum Usuário encontrado!")), UsuarioDTO.class);
    }

    @Transactional
    @Override
    public void criarUsuario(UsuarioRequest usuarioRequest) {
        String cpfCnpjApenasNumeros = StringUtil.somenteNumeros(usuarioRequest.getCpfCnpj());

        Usuario jaExisteUsuario = usuarioRepository.findByCpfCnpj(cpfCnpjApenasNumeros);
        if (jaExisteUsuario != null) {
            throw new BusinessException("Já existe um Usuário cadastrado com esse CPF/CNPJ " + usuarioRequest.getCpfCnpj() + ".");
        }

        Usuario jaExisteEmail = usuarioRepository.findByEmail(usuarioRequest.getEmail());
        if (jaExisteEmail != null) {
            throw new BusinessException("Já existe um Usuário cadastrado com esse Email " + usuarioRequest.getEmail() + ".");
        }

        var passwordHash = passwordEncoder.encode(usuarioRequest.getSenha());

        usuarioRequest.setSenha(passwordHash);
        usuarioRequest.setCpfCnpj(cpfCnpjApenasNumeros);
        usuarioRequest.setCreatedAt(LocalDate.now());

        Usuario usuario = mapper.map(usuarioRequest, Usuario.class);

        try {
            usuario = usuarioRepository.save(usuario);
        } catch
        (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Erro ao cadastrar Usuário.");
        }
    }

    @Override
    public void alterarUsuario(UsuarioRequest usuarioRequest) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioRequest.getId());

        Usuario usuario = usuarioOptional.orElseThrow(() -> new NotFoundException("Usuário não encontrada para o ID: " + usuarioRequest.getId()));

        if (!usuario.getCpfCnpj().equals(usuarioRequest.getCpfCnpj())) {
            throw new BusinessException("O CPF/CNPJ do Usuário não pode ser alterado.");

        }
        String encryptedPassword = passwordEncoder.encode(usuarioRequest.getSenha());
        usuarioRequest.setSenha(encryptedPassword);

        usuarioRequest.setUpdatedAt(LocalDate.now());

        usuario = mapper.map(usuarioRequest, Usuario.class);
        try {
            usuario = usuarioRepository.save(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Erro ao alterar o usuário.");
        }
    }
    @Override
    public void excluirUsuario(Long usuarioId) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
        usuario.setDeletedAt(LocalDate.now());

        try {
            usuarioRepository.save(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Erro ao excluir usuário.");
        }
    }

}