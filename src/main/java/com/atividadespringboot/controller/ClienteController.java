package com.atividadespringboot.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import java.util.List;
import com.atividadespringboot.dto.ClienteDTO;
import com.atividadespringboot.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@Valid @RequestBody ClienteDTO dto) {
        ClienteDTO salvo = service.salvar(dto);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
