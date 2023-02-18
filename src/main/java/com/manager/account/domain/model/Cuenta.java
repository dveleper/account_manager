package com.manager.account.domain.model;

import lombok.*;

import java.math.BigInteger;

@NoArgsConstructor
@Getter
@Setter
public class Cuenta {
    private String numero;
    private String tipoCuenta;
    private BigInteger saldo;
    private String estado;
    private Cliente cliente;

}
