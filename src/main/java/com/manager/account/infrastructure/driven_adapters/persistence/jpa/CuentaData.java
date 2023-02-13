package com.manager.account.infrastructure.driven_adapters.persistence.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "cuenta")
@Getter
@Setter
public class CuentaData {
    @Id
    @Column(name = "cuenta_id")
    private String cuentaId;

    @Column(name = "tipo_cuenta")
    private String tipoCuenta;

    @Column(name = "saldo_inicial")
    private BigInteger saldoInicial;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id", insertable = true, updatable = false)
    private ClienteData cliente;
}
