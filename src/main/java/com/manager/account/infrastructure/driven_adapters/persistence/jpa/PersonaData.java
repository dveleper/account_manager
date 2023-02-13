package com.manager.account.infrastructure.driven_adapters.persistence.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Inheritance(strategy= InheritanceType.JOINED)
@Getter
@Setter
public class PersonaData {
    @Id
    @Column(nullable = false, length = 20)
    @NotNull(message = "la identificacion no puede ser nula")
    @Size(min = 6, message = "la identificacion debe tener al menos seis caracteres")
    private String identificacion;

    @Column(nullable = false, length = 45)
    @NotNull(message = "el nombre no puede ser nulo")
    @Size(min = 10, message = "el nombre debe tener al menos diez caracteres")
    private String nombre;

    @Column(nullable = false, length = 10)
    @NotNull(message = "el genero no puede ser nulo")
    @Size(min = 5, message = "el genero debe tener al menos cinco caracteres")
    private String genero;

    @Column(nullable = false, length = 3)
    @NotNull(message = "la edad no puede ser nula")
    private Integer edad;

    @Column(nullable = false, length = 60)
    @NotNull(message = "la direccion no puede ser nula")
    @Size(min = 10, message = "el direccion debe tener al diez caracteres")
    private String direccion;

    @Column(nullable = false, length = 20)
    @NotNull(message = "el telefono no puede ser nulo")
    @Size(min = 8, message = "el telefono debe tener al menos ocho caracteres")
    private String telefono;
}
