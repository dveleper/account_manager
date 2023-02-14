package com.manager.account.domain.model.repository;

import com.manager.account.domain.model.Movimiento;

import java.util.List;

public interface MovimientoRepository {
    Movimiento crear(Movimiento movimiento);
    List<Movimiento> listar();
    Movimiento listarPorId(Integer idMovimiento);
    Movimiento editar(Movimiento movimiento);
    boolean eliminar(Integer idMovimiento);
}
