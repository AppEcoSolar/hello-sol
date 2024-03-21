package br.com.hellosol.hellosol.controller;

import br.com.hellosol.hellosol.Response.OperacaoResponse;
import br.com.hellosol.hellosol.dto.UsinaDTO;
import br.com.hellosol.hellosol.dto.UsinaRequest;
import br.com.hellosol.hellosol.dto.UsuarioDTO;
import br.com.hellosol.hellosol.dto.UsuarioRequest;
import br.com.hellosol.hellosol.enumx.MensagemRetorno;
import br.com.hellosol.hellosol.service.UsinaService;
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

@Tag(name = "Gerênciar Usinas Endpoint")
@RestController
@RequestMapping("usinas")
public class UsinaController {

    @Autowired
    private UsinaService usinaService;

    @Operation(summary = "Consulta usinas")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsinaDTO>> listarUsinas(
            @RequestParam(value = "idEmpresa", required = false) Long idEmpresa,
            @RequestParam(value = "nome", required = false) String nome) {
        return ResponseEntity.ok(usinaService.listarUsinas(idEmpresa, nome));
    }

    @Operation(summary = "Consulta uma Usina")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsinaDTO> buscarUsinaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usinaService.findById(id));
    }

    @Operation(summary = "Cria uma Usina")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OperacaoResponse> criarUsina(@Valid @RequestBody UsinaRequest usinaRequest) {
        usinaService.criarUsina(usinaRequest);
        OperacaoResponse response = new OperacaoResponse(MensagemRetorno.SUCESSO_CRIACAO_USINA);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Alterar informações da Usina")
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OperacaoResponse> alterarUsina(@Valid @PathVariable("id") Long id, @RequestBody UsinaRequest usinaRequest) {
        usinaRequest.setId(id);
        usinaService.alterarUsina(usinaRequest);
        OperacaoResponse response = new OperacaoResponse(MensagemRetorno.SUCESSO_ALTERACAO_USINA);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Excluir Usina")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OperacaoResponse> excluirUsina(@PathVariable("id") Long id) {
        usinaService.excluirUsina(id);
        OperacaoResponse response = new OperacaoResponse(MensagemRetorno.SUCESSO_EXCLUSAO_USINA);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
