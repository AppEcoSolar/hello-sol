package br.com.hellosol.hellosol.controller;

import br.com.hellosol.hellosol.dto.TipoUsuarioDTO;
import br.com.hellosol.hellosol.service.TipoUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Tipo Usuário Endpoint")
@RestController
@RequestMapping("tipos-usuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @Operation(summary = "Consulta lista dos tipos de pessoa")
    @GetMapping
    public ResponseEntity<List<TipoUsuarioDTO>> listarTipoUsuario() {
        return ResponseEntity.ok(tipoUsuarioService.listarTipoUsuario());
    }
}
