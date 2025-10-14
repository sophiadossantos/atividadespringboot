package com.atividadespringboot.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.atividadespringboot.entity.Cliente;
import com.atividadespringboot.dto.ClienteDTO;
import com.atividadespringboot.mapper.ClienteMapper;
import com.atividadespringboot.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ClienteDTO salvar(ClienteDTO dto) {
        Cliente cliente = mapper.toEntity(dto);
        Cliente salvo = repository.save(cliente);
        return mapper.toDTO(salvo);
    }

    public List<ClienteDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<ClienteDTO> buscarPorId(Long id) {
        return repository.findById(id).map(mapper::toDTO);
    }
}
