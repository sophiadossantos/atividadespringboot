package com.atividadespringboot.repository;

import com.atividadespringboot.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {}
