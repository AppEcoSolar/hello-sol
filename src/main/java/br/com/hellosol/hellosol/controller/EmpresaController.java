package br.com.hellosol.hellosol.controller;

import br.com.hellosol.hellosol.Response.OperacaoResponse;
import br.com.hellosol.hellosol.dto.EmpresaDTO;
import br.com.hellosol.hellosol.dto.EmpresaRequest;
import br.com.hellosol.hellosol.enumx.MensagemRetorno;
import br.com.hellosol.hellosol.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gerênciar Empresas Gestoras Endpoint")
@RestController
@RequestMapping("empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Operation(summary = "Consulta empresas gestoras")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmpresaDTO>> listarEmpresas(
            @RequestParam(value = "cnpj", required = false) String cnpj,
            @RequestParam(value = "nome", required = false) String nome) {
        return ResponseEntity.ok(empresaService.listarEmpresas(cnpj, nome));
    }

    @Operation(summary = "Consulta uma Empresa")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpresaDTO> buscarEmpresaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(empresaService.buscarEmpresaById(id));
    }

    @Operation(summary = "Consulta todas as Empresa")
    @GetMapping(value = "/lista/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmpresaDTO>> buscarListEmpresaById(@PathVariable("id") Long id) {
        List<EmpresaDTO> retorno = empresaService.buscarListEmpresaById(id);
        return ResponseEntity.ok(retorno);
    }

    @Operation(summary = "Cria uma empresa gestora")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OperacaoResponse> criarEmpresa(@Valid @RequestBody EmpresaRequest empresaRequest) {
        empresaService.criarEmpresa(empresaRequest);
        OperacaoResponse response = new OperacaoResponse(MensagemRetorno.SUCESSO_CRIACAO_EMPRESA);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Alterar os dados de uma empresa gestora")
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OperacaoResponse> alterarEmpresa(@PathVariable("id") Long id, @RequestBody EmpresaRequest empresaRequest) {
        empresaRequest.setId(id);
        empresaService.alterarEmpresa(empresaRequest);
        OperacaoResponse response = new OperacaoResponse(MensagemRetorno.SUCESSO_ALTERACAO_EMPRESA);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Exclusão lógica de uma empresa gestora")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OperacaoResponse> excluirEmpresa(@PathVariable("id") Long id) {
        empresaService.excluirEmpresa(id);
        OperacaoResponse response = new OperacaoResponse(MensagemRetorno.SUCESSO_EXCLUSAO_EMPRESA);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
