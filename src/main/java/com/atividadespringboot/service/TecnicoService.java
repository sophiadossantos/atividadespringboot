package com.atividadespringboot.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.atividadespringboot.entity.Tecnico;
import com.atividadespringboot.dto.TecnicoDTO;
import com.atividadespringboot.mapper.TecnicoMapper;
import com.atividadespringboot.repository.TecnicoRepository;

@Service
public class TecnicoService {

    private final TecnicoRepository repository;
    private final TecnicoMapper mapper;

    public TecnicoService(TecnicoRepository repository, TecnicoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TecnicoDTO salvar(TecnicoDTO dto) {
        Tecnico tecnico = mapper.toEntity(dto);
        Tecnico salvo = repository.save(tecnico);
        return mapper.toDTO(salvo);
    }

    public List<TecnicoDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<TecnicoDTO> buscarPorId(Long id) {
        return repository.findById(id).map(mapper::toDTO);
    }
}
