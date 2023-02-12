package com.manager.account.domain.model;

import com.manager.account.util.TipoMovimiento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Movimiento {
    private Integer idMovimiento;
    private Date fecha;
    private TipoMovimiento tipoMovimiento;
    private BigInteger valor;
    private BigInteger saldo;
}
