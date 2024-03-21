package br.com.hellosol.hellosol.controller;

import br.com.hellosol.hellosol.Response.OperacaoResponse;
import br.com.hellosol.hellosol.dto.UsuarioDTO;
import br.com.hellosol.hellosol.dto.UsuarioRequest;
import br.com.hellosol.hellosol.enumx.MensagemRetorno;
import br.com.hellosol.hellosol.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gerênciar Usuário Endpoint")
@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Consulta usuários")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(
            @RequestParam(value = "cpfCnpj", required = false) String cpfCnpj,
            @RequestParam(value = "nome", required = false) String nome) {
        return ResponseEntity.ok(usuarioService.listarUsuarios(cpfCnpj, nome));
    }

    @Operation(summary = "Consulta um Usuário")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> buscarUsuarioById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @Operation(summary = "Cria um usuario")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OperacaoResponse> criarUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest) {
        usuarioService.criarUsuario(usuarioRequest);
        OperacaoResponse response = new OperacaoResponse(MensagemRetorno.SUCESSO_CRIACAO_USUARIO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Alterar Informações do Usuário")
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OperacaoResponse> alterarUsuario(@Valid @PathVariable("id") Long id, @RequestBody UsuarioRequest usuarioRequest) {
        usuarioRequest.setId(id);
        usuarioService.alterarUsuario(usuarioRequest);
        OperacaoResponse response = new OperacaoResponse(MensagemRetorno.SUCESSO_ALTERACAO_USUARIO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Excluir Usuário")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OperacaoResponse> excluirUsuario(@PathVariable("id") Long id) {
        usuarioService.excluirUsuario(id);
        OperacaoResponse response = new OperacaoResponse(MensagemRetorno.SUCESSO_EXCLUSAO_USUARIO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
