package com.manager.account.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class Movimiento {
    private Integer idMovimiento;
    private Date fecha;
    private String tipoMovimiento;
    private BigInteger valor;
    private BigInteger saldo;
    private Cuenta cuenta;
}
