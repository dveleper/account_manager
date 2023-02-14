package com.manager.account.domain.model;

import lombok.*;

import java.math.BigInteger;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
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
