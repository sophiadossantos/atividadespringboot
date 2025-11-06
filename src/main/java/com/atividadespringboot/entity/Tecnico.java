package com.atividadespringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Tecnico extends Pessoa {

    @Column(nullable = false)
    private String especialidade;

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
}
