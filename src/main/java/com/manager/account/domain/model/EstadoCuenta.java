package com.manager.account.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstadoCuenta {
    private String fecha;
    private String cliente;
    private String numeroCuenta;
    private String tipo;
    private BigInteger saldoInicial;
    private BigInteger movimiento;
    private BigInteger saldoDisponible;

}
