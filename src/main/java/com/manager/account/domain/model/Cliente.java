package com.manager.account.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Persona {
    private String clienteId;
    private String contrasena;
    private boolean estado;
}
