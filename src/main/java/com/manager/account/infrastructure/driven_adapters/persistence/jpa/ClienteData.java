package com.manager.account.infrastructure.driven_adapters.persistence.jpa;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteData {
    @Id
    @Column(name = "cliente_id")
    private Integer clienteId;

    private String contrasena;
    private String estado;
}
