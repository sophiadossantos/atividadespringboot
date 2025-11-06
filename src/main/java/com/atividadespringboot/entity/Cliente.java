package com.atividadespringboot.entity;

import com.atividadespringboot.enums.StatusEnum;
import jakarta.persistence.*;

@Entity
public class Cliente extends Pessoa {

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String telefone;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public StatusEnum getStatus() { return status; }
    public void setStatus(StatusEnum status) { this.status = status; }
}
