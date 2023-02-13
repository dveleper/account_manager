package com.manager.account.infrastructure.driven_adapters.persistence.jpa;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class ClienteData extends PersonaData {
    private String contrasena;
    private String estado;
}
