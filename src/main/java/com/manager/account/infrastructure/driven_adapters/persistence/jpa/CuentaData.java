package com.manager.account.infrastructure.driven_adapters.persistence.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigInteger;

@Entity
@Table(name = "cuenta")
public class CuentaData {
    @Id
    @Column(name = "cuenta_id")
    private String cuentaId;

    @Column(name = "tipo_cuenta")
    private String tipoCuenta;

    @Column(name = "saldo_inicial")
    private BigInteger saldoInicial;

    private String estado;
}
