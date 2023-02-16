package com.manager.account.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstadoCuentaInput {
    private String identificacion;
    private Date fechaInicial;
    private Date fechaFinal;
}
