package com.atividadespringboot.service;

import com.atividadespringboot.entity.Tecnico;
import com.atividadespringboot.repository.TecnicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TecnicoService {

    private final TecnicoRepository tecnicoRepository;

    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public List<Tecnico> listarTodos() {
        return tecnicoRepository.findAll();
    }

    public Tecnico buscarPorId(Long id) {
        return tecnicoRepository.findById(id).orElse(null);
    }

    public Tecnico salvar(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    public void deletar(Long id) {
        tecnicoRepository.deleteById(id);
    }
}
