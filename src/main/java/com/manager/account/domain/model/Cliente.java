package com.manager.account.domain.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class Cliente extends Persona {
    private String contrasena;
    private String estado;
}
