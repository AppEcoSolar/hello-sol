package br.com.hellosol.hellosol.controller;

import br.com.hellosol.hellosol.dto.TipoPessoaDTO;
import br.com.hellosol.hellosol.service.TipoPessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Tipo Pessoa endpoint")
@RestController
@RequestMapping("tipos-pessoa")
public class TipoPessoaController {

    @Autowired
    private TipoPessoaService tipoPessoaService;

    @Operation(summary = "Consulta lista dos tipos de pessoa")
    @GetMapping
    public ResponseEntity<List<TipoPessoaDTO>> listarTipoPessoa() {
        return ResponseEntity.ok(tipoPessoaService.listarTipoPessoa());
    }
}
