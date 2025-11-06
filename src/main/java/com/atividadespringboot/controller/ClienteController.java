package com.atividadespringboot.controller;

import com.atividadespringboot.dto.ClienteDTO;
import com.atividadespringboot.entity.Cliente;
import com.atividadespringboot.mapper.ClienteMapper;
import com.atividadespringboot.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    public ClienteController(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar() {
        List<ClienteDTO> clientes = clienteService.listarTodos()
                .stream()
                .map(clienteMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscar(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return cliente != null
                ? ResponseEntity.ok(clienteMapper.toDto(cliente))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> criar(@RequestBody ClienteDTO dto) {
        Cliente salvo = clienteService.salvar(clienteMapper.toEntity(dto));
        return ResponseEntity.ok(clienteMapper.toDto(salvo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
