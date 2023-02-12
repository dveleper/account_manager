package com.manager.account.domain.model.repository;

import com.manager.account.domain.model.Movimiento;

import java.util.List;

public interface MovimientoRepository {
    Movimiento crear(Movimiento movimiento);
    List<Movimiento> listar(Movimiento movimiento);
    Movimiento editar(Movimiento movimiento);
    void eliminar(Integer idMovimiento);
}
