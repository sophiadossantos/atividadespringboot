package com.atividadespringboot.controller;

import com.atividadespringboot.dto.TecnicoDTO;
import com.atividadespringboot.entity.Tecnico;
import com.atividadespringboot.mapper.TecnicoMapper;
import com.atividadespringboot.service.TecnicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    private final TecnicoService tecnicoService;
    private final TecnicoMapper tecnicoMapper;

    public TecnicoController(TecnicoService tecnicoService, TecnicoMapper tecnicoMapper) {
        this.tecnicoService = tecnicoService;
        this.tecnicoMapper = tecnicoMapper;
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> listar() {
        List<TecnicoDTO> tecnicos = tecnicoService.listarTodos()
                .stream()
                .map(tecnicoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tecnicos);
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> criar(@RequestBody TecnicoDTO dto) {
        Tecnico salvo = tecnicoService.salvar(tecnicoMapper.toEntity(dto));
        return ResponseEntity.ok(tecnicoMapper.toDto(salvo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tecnicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
