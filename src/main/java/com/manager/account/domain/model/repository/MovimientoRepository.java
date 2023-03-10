package com.manager.account.domain.model.repository;

import com.manager.account.domain.model.Movimiento;

import java.util.List;

public interface MovimientoRepository {
    Movimiento crear(Movimiento movimiento);
    List<Movimiento> listar();
    Movimiento listarPorId(Integer idMovimiento);
    boolean eliminar(Integer idMovimiento);
    List<Movimiento> consultaPoCuenta(String cuenta);
}
