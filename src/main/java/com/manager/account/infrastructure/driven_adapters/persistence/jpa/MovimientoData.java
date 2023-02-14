package com.manager.account.infrastructure.driven_adapters.persistence.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "movimiento")
@Getter
@Setter
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

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private CuentaData cuenta;
}
