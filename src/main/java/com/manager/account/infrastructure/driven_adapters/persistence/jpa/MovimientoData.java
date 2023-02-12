package com.manager.account.infrastructure.driven_adapters.persistence.jpa;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "movimiento")
public class MovimientoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movimiento_id")
    private Integer movimientoId;

    private Date fecha;

    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;

    private BigInteger valor;

    private BigInteger saldo;
}
