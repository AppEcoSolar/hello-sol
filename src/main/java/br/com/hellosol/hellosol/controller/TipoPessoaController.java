package br.com.hellosol.hellosol.controller;

import br.com.hellosol.hellosol.dto.TipoPessoaDTO;
import br.com.hellosol.hellosol.service.TipoPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tipos-pessoa")
public class TipoPessoaController {

    @Autowired
    private TipoPessoaService tipoPessoaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipoPessoaDTO>> listarTipoPessoa() {
        return ResponseEntity.ok(tipoPessoaService.listarTipoPessoa());
    }
}
