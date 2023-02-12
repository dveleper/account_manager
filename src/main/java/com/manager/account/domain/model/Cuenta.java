package com.manager.account.domain.model;

import com.manager.account.util.TipoCuenta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Cuenta {
    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private BigInteger saldoInicial;
    private boolean estado;
}
