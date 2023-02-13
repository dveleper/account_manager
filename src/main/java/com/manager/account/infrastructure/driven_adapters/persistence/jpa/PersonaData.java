package com.manager.account.infrastructure.driven_adapters.persistence.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Inheritance(strategy= InheritanceType.JOINED)
@Getter
@Setter
public class PersonaData {
    @Id
    private String identificacion;
    private String nombre;
    private String genero;
    private int edad;
    private String direccion;
    private String telefono;
}
