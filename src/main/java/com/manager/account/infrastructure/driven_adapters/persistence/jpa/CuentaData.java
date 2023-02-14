package com.manager.account.infrastructure.driven_adapters.persistence.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

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
    @JoinColumn(name = "cliente_id", updatable = false)
    private ClienteData cliente;

    //@OneToMany(mappedBy = "cuenta")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovimientoData> movimientos;

}
