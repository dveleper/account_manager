package com.manager.account.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstadoCuentaInput {
    private String identificacion;
    private String fecha_inicial;
    private String fecha_final;
}
