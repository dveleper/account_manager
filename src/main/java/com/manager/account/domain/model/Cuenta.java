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
public class Cuenta {
    private String numeroCuenta;
    private String tipoCuenta;
    private BigInteger saldo;
    private String estado;
    private Cliente cliente;

}
