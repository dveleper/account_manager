package com.manager.account.infrastructure.driven_adapters.persistence.jpa;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class ClienteData extends PersonaData {
    @Column(nullable = false, length = 10)
    @NotBlank(message = "la contraseña no puede ser nula")
    @Size(min = 5, message = "la contraseña debe terner al menos cinco caracteres")
    private String contrasena;
    private String estado;
}
